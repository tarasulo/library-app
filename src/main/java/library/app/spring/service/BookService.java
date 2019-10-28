package library.app.spring.service;

import java.util.List;

import library.app.spring.entity.Book;

public interface BookService {
    void add(Book book);

    List<Book> listBooks();

    List<Book> findByTitle(String name);

    Book getById(Long id);

    void delete(Long bookId);
}
