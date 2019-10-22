package library.app.spring.service.impl;

import java.util.List;

import library.app.spring.dao.AuthorDao;
import library.app.spring.entity.Author;
import library.app.spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        return authorDao.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        return authorDao.findByNameAndSurname(name, surname);
    }
}
