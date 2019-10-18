package library.app.spring.service;

import java.util.List;

import library.app.spring.entity.Author;

public interface AuthorService {

    void add(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
