package library.app.spring.service.impl;

import java.util.List;

import library.app.spring.dao.BookDao;
import library.app.spring.entity.Book;
import library.app.spring.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public Book getById(Long id) {
        return bookDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long bookId) {
        bookDao.delete(bookId);
    }
}
