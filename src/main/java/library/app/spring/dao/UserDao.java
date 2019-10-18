package library.app.spring.dao;

import java.util.List;

import library.app.spring.entity.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
