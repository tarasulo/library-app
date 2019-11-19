package library.app.spring.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;

import library.app.spring.config.AppConfig;
import library.app.spring.entity.Author;
import library.app.spring.entity.Book;
import library.app.spring.entity.Role;
import library.app.spring.entity.User;
import library.app.spring.service.AuthorService;
import library.app.spring.service.BookService;
import library.app.spring.service.RoleService;
import library.app.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/injectdata")
public class InjectDataController {

    private static final Role USER = new Role("ROLE_USER");
    private static final Role ADMIN = new Role("ROLE_ADMIN");

    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;
    private final RoleService roleService;

    public InjectDataController(BookService bookService, AuthorService authorService,
                                UserService userService, RoleService roleService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String injectData() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

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

    @PostConstruct
    public void injectUsers() {
        roleService.add(USER);
        roleService.add(ADMIN);

        User davidMiller = new User("David", "Miller", "david.miller@i.ua",
                "admin", "$2a$10$LvfOeF3VgJNk/JQnuGHlD.V1X2AExI9ipAtcf5xRNFvKSn8sUSL7.");
        Role davidMillerRole = roleService.getRoleByName("ROLE_ADMIN").get();
        Set<Role> davidMillerRoles = new HashSet<>();
        davidMillerRoles.add(davidMillerRole);
        davidMiller.setRoles(davidMillerRoles);
        userService.add(davidMiller);

        User user = new User("Sunil", "Bora", "suni.bora@example.com",
                "user", "$2a$10$diDQUDVrl5QWCGWixKzlH.YJfmHl1CN5/KgMRXO.CPtnAZND6CHC6");
        Role userRole = roleService.getRoleByName("ROLE_USER").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        userService.add(user);

    }
}
