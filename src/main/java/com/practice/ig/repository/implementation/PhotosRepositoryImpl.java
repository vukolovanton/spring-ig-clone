package com.practice.ig.repository.implementation;

import com.practice.ig.entity.Photos;
import com.practice.ig.repository.interfaces.PhotosRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PhotosRepositoryImpl implements PhotosRepository {
    private EntityManager entityManager;
    @Autowired
    public PhotosRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Photos> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Photos", Photos.class);
        List<Photos> photos = query.getResultList();
        return photos;
    }

    @Override
    public Photos findPhotoById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Photos photo = session.get(Photos.class, id);
        return photo;
    }

    @Override
    public void savePhoto(Photos photo) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(photo);
//        session.saveOrUpdate(photo);
    }

    @Override
    public List<Photos> getOldestPhotos(Timestamp time) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("FROM Photos P WHERE P.createdAt < :time");
        query.setParameter("time", time);
        List<Photos> result = query.getResultList();
        return result;
    }
}
