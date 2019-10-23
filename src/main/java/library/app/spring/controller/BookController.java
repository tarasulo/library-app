package library.app.spring.controller;

import library.app.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/info")
    public String bookInfo(@RequestParam("book_id") Long id, ModelMap model) {
        model.put("info", bookService.getById(id));
        return "bookInfo";
    }

}
