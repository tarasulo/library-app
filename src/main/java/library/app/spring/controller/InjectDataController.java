package library.app.spring.controller;

import java.util.ArrayList;
import java.util.List;

import library.app.spring.config.AppConfig;
import library.app.spring.entity.Author;
import library.app.spring.entity.Book;
import library.app.spring.entity.User;
import library.app.spring.service.AuthorService;
import library.app.spring.service.BookService;
import library.app.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/injectdata")
public class InjectDataController {

    @GetMapping
    public String injectData() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        // Add Users
        User davidMiller = new User("David", "Miller", "david.miller@example.com");
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(davidMiller);
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        AuthorService authorService = context.getBean(AuthorService.class);
        Author joshuaBloch = new Author("Joshua", "Bloch");
        authorService.add(joshuaBloch);

        BookService bookService = context.getBean(BookService.class);
        // Add Books
        Book effectialJava = new Book("Effectial Java: 3rd Edition", 2019, 650.);
        bookService.add(effectialJava);
        bookService.add(new Book("Java: A Beginner's Guide, Seventh Edition", 2019, 350.));
        bookService.add(new Book("Head First Java", 2003, 99.99));
        bookService.add(new Book("A Dance with Dragons", 2011, 299.));
        List<Author> authorsBloch = new ArrayList<>();
        authorsBloch.add(joshuaBloch);
        effectialJava.setAuthors(authorsBloch);
        List<Book> javaBook = new ArrayList<>();
        javaBook.add(effectialJava);
        joshuaBloch.setBooks(javaBook);

        context.close();
        return "forward:/book/all";
    }
}
