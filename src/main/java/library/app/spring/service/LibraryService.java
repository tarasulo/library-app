package library.app.spring.service;

import java.util.List;

import library.app.spring.entity.Book;
import library.app.spring.entity.Rent;
import library.app.spring.entity.User;

public interface LibraryService {

    Rent rentBook(User user, Book book);

    Rent getRent(User user, Book book);

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
