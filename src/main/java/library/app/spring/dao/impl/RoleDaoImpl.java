package library.app.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import library.app.spring.dao.RoleDao;
import library.app.spring.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery(
                "from Role WHERE roleName =:roleName", Role.class);
        query.setParameter("roleName", roleName);
        Optional<Role> optionalRole;
        try {
            optionalRole = Optional.of(query.getSingleResult());
        } catch (Exception e) {
            optionalRole = Optional.empty();
        }
        return optionalRole;
    }

    @Override
    public List<Role> getAllRoles() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession()
                .createQuery("from Role", Role.class);
        return query.getResultList();
    }
}
