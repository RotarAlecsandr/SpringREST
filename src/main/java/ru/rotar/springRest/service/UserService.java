package ru.rotar.springRest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rotar.springRest.model.User;
import ru.rotar.springRest.repositories.UserRepositories;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService  {
    private final UserRepositories userRepositories;

    public List<User> findAll() {
        return userRepositories.findAll();
    }

    public User findOne(int id) {
        return userRepositories.findById(id).orElse(null);
    }

    @Transactional
    public User saveUser(User user) {
        return userRepositories.save(user);
    }

    @Transactional
    public String deleteUser(int id) {
        userRepositories.deleteById(id);
        return "Пользователь удален";
    }
}
