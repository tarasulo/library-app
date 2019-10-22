package library.app.spring.dao;

import java.util.List;

import library.app.spring.entity.Author;

public interface AuthorDao {
    void add(Author author);

    List<Author> listAuthor();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
