package library.app.spring.dao;

import java.util.List;
import java.util.Optional;

import library.app.spring.entity.Role;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(String name);

    List<Role> getAllRoles();
}
