package library.app.spring.service;

import java.util.List;
import java.util.Optional;

import library.app.spring.entity.User;

public interface UserService {
    void add(User user);

    User getById(Long id);

    Optional<User> getByUserName(String username);

    List<User> listUsers();
}
