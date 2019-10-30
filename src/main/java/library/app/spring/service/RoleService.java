package library.app.spring.service;

import java.util.List;
import java.util.Optional;

import library.app.spring.entity.Role;

public interface RoleService {

    void add(Role role);

    Optional<Role> getRoleByName(String name);

    List<Role> getAllRoles();
}
