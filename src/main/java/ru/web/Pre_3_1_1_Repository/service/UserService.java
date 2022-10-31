package ru.web.Pre_3_1_1_Repository.service;

import ru.web.Pre_3_1_1_Repository.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(Long id);

    void update(Long id, User updateUser);

    User getOne(Long id);

    List<User> getAll();
}
