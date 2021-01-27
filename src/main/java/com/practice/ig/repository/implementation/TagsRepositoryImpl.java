package com.practice.ig.repository.implementation;

import com.practice.ig.entity.Tags;
import com.practice.ig.repository.interfaces.TagsRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TagsRepositoryImpl implements TagsRepository {
    private EntityManager entityManager;
    @Autowired
    public TagsRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Tags> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Tags", Tags.class);
        List<Tags> tags = query.getResultList();
        return tags;
    }

    @Override
    public Tags findTagById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Tags tag = session.get(Tags.class, id);
        return tag;
    }
}
