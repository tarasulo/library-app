package library.app.spring.service.impl;

import java.util.List;

import library.app.spring.dao.LibraryDao;
import library.app.spring.entity.Book;
import library.app.spring.entity.Rent;
import library.app.spring.entity.User;
import library.app.spring.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        return libraryDao.rentBook(user, book);
    }

    @Override
    public Rent getRent(User user, Book book) {
        return libraryDao.getRent(user, book);
    }

    @Override
    public void returnBook(User user, Book book) {
        libraryDao.returnBook(user, book);
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        return libraryDao.getBooksRentByUser(user);
    }
}
