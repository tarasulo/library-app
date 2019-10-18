package library.app.spring.service;

import java.util.List;
import library.app.spring.entity.Book;

public interface BookService {
    void add(Book book);

    List<Book> listBooks();

    List<Book> findByName(String name);
}