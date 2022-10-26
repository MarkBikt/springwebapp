package ru.mark.springwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mark.springwebapp.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private final EntityManager entityManager;


    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User newUser) {
        entityManager.merge(newUser);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
