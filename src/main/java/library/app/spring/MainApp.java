package library.app.spring;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import library.app.spring.config.AppConfig;
import library.app.spring.entity.Author;
import library.app.spring.entity.Book;
import library.app.spring.entity.Rent;
import library.app.spring.entity.User;
import library.app.spring.service.AuthorService;
import library.app.spring.service.BookService;
import library.app.spring.service.LibraryService;
import library.app.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Add Users
        User davidMiller = new User("David", "Miller", "david.miller@example.com");
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(davidMiller);
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        AuthorService authorService = context.getBean(AuthorService.class);
        Author joshuaBloch = new Author("Joshua", "Bloch");
        authorService.add(joshuaBloch);

        BookService bookService = context.getBean(BookService.class);
        // Add Books
        Book effectialJava = new Book("Effective Java: 3rd Edition", 2019, 650.);
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
        LocalDate localDate = LocalDate.now();
        Rent firstRent = new Rent(localDate, davidMiller, effectialJava, true);
        LibraryService libraryService = context.getBean(LibraryService.class);
        // Get Books
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println("Book id = " + book.getId());
            System.out.println("Book name = " + book.getName());
            System.out.println("Book year = " + book.getYear());
            System.out.println("Book price = " + book.getPrice());
            System.out.println();
        }

        context.close();
    }
}
