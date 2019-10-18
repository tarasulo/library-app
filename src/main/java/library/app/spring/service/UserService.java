package library.app.spring.service;

import java.util.List;

import library.app.spring.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
