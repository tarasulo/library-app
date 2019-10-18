package library.app.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;

import library.app.spring.dao.RentDao;
import library.app.spring.entity.Rent;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
    }

    @Override
    public List<Rent> listRents() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("from Rent", Rent.class);
        return query.getResultList();
    }
}
