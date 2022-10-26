package ru.mark.springwebapp.service;

import ru.mark.springwebapp.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(Long id);
    void save(User user);
    void update(User newUser);
    void delete(Long id);
}