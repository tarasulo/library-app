package library.app.spring.dao;

import java.util.List;
import java.util.Optional;

import library.app.spring.entity.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getById(Long id);

    Optional<User> getByUserName(String username);
}
