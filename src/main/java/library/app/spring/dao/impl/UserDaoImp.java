package library.app.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import library.app.spring.dao.UserDao;
import library.app.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public Optional<User> getByUserName(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "from User WHERE username =:username", User.class);
        query.setParameter("username", username);
        Optional<User> optionalUser;
        try {
            optionalUser = Optional.of(query.getSingleResult());
        } catch (Exception e) {
            optionalUser = Optional.empty();
        }
        return optionalUser;
    }
}
