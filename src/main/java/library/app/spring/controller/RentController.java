package library.app.spring.controller;

import library.app.spring.service.BookService;
import library.app.spring.service.LibraryService;
import library.app.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {

    private final UserService userService;
    private final BookService bookService;
    private final LibraryService libraryService;

    public RentController(UserService userService, BookService bookService,
                          LibraryService libraryService) {
        this.userService = userService;
        this.bookService = bookService;
        this.libraryService = libraryService;
    }

    @GetMapping("/rentbook")
    public String rentBook(@RequestParam("book_id") Long bookId, ModelMap model) {
        model.put("book", libraryService.rentBook(userService.getById(bookId),
                bookService.getById(bookId)));
        return "book/all";
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("book_id") Long id) {
        libraryService.returnBook(userService.getById(id), bookService.getById(id));
        return "book/all";
    }

    @GetMapping("/rentedBooks")
    public String getBooksRentByUser(@RequestParam("user_id") Long id, ModelMap model) {
        model.addAttribute("books", libraryService.getBooksRentByUser(userService.getById(id)));
        return "book/all";
    }

}
