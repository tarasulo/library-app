package library.app.spring.service.impl;

import java.util.List;
import java.util.Optional;

import library.app.spring.dao.RoleDao;
import library.app.spring.entity.Role;
import library.app.spring.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Role> getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
