package ru.mark.springwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mark.springwebapp.dao.UserDao;
import ru.mark.springwebapp.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(Long id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User newUser) {
        userDao.update(newUser);
    }

    @Override
    @Transactional
    public void delete(Long id) { userDao.delete(id); }
}
