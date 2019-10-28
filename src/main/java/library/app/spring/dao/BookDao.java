package library.app.spring.dao;

import java.util.List;

import library.app.spring.entity.Book;

public interface BookDao {
    void add(Book book);

    List<Book> listBooks();

    List<Book> findByTitle(String title);

    Book getById(Long id);

    void delete(Long bookId);
}
