package com.practice.ig.repository.implementation;

import com.practice.ig.entity.Users;
import com.practice.ig.repository.interfaces.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Users> findAll() {
//        Query query = entityManager.createQuery("from Users");
//        List<Users> users = query.getResultList();
//        return users;

        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Users", Users.class);
        List<Users> usersList = query.getResultList();
        return usersList;
    }

    @Override
    public Users findUserById(int id) {
//        Users user = entityManager.find(Users.class, id);
//        return user;

        Session session = entityManager.unwrap(Session.class);
        Users user = session.get(Users.class, id);
        return user;
    }

    @Override
    public void saveUser(Users user) {
//        Users userDB = entityManager.merge(users);

        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
//        Query query = entityManager.createQuery("delete from Users where id=:id");
//        query.setParameter("id", id);
//        query.executeUpdate();

        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE FROM Users WHERE id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Users> findUsersWithIdGreaterThan(int id) {
        String sql = "SELECT username FROM Users u WHERE u.id > :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", id);
        List<Users> users = query.getResultList();
        return users;
    }


}
