package library.app.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;

import library.app.spring.dao.BookDao;
import library.app.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    private final SessionFactory sessionFactory;

    public BookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("from Book WHERE title LIKE CONCAT('%', :title, '%')", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public Book getById(Long id) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("from Book WHERE id = :id", Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void delete(Long bookId) {
        Book removeBook = (Book) sessionFactory.getCurrentSession().load(Book.class, bookId);
        if (removeBook != null) {
            sessionFactory.getCurrentSession().delete(removeBook);
        }
    }
}
