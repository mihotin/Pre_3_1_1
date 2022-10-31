package ru.web.Pre_3_1_1_Repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web.Pre_3_1_1_Repository.model.User;
import ru.web.Pre_3_1_1_Repository.repositorys.UserRepo;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;
    @Autowired
    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, User updateUser) {
        updateUser.setId(id);
        userRepo.save(updateUser);
    }

    @Override
    public User getOne(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
