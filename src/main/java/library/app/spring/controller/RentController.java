package library.app.spring.controller;

import library.app.spring.service.BookService;
import library.app.spring.service.LibraryService;
import library.app.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/rentbook")
    public String rentBook(@RequestParam("book_id") Long bookId, ModelMap model) {
        model.put("book", libraryService.rentBook(userService.getById(USER_ID),
                bookService.getById(bookId)));
        return "book/all";
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("book_id") Long id) {
        libraryService.returnBook(userService.getById(USER_ID), bookService.getById(id));
        return "book/all";
    }

    @GetMapping("/rentedBooks")
    public String getBooksRentByUser(@RequestParam("user_id") Long id, ModelMap model) {
        model.addAttribute("books", libraryService.getBooksRentByUser(userService.getById(id)));
        return "book/all";
    }

}
