package library.app.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;

import library.app.spring.dao.LibraryDao;
import library.app.spring.entity.Book;
import library.app.spring.entity.Rent;
import library.app.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDaoImpl implements LibraryDao {

    private final SessionFactory sessionFactory;

    public LibraryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(user, book);
        sessionFactory.getCurrentSession().save(rent);
        return rent;
    }

    @Override
    public Rent getRent(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("from Rent WHERE user=:user AND book=:book");
        query.setParameter("user", user);
        query.setParameter("book", book);
        return query.getSingleResult();
    }

    @Override
    public void returnBook(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("from Rent WHERE user=:user AND book=:book");
        query.setParameter("user", user);
        query.setParameter("book", book);
        Rent rent = query.getSingleResult();
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("select rent.book from Rent rent "
                        + "where user=:user and active = true", Book.class);
        query.setParameter("user", user);
        return query.getResultList();
    }
}
