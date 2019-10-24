package library.app.spring.controller;

import java.util.List;

import library.app.spring.entity.Book;
import library.app.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/allBooks")
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.listBooks());
        return "book/allBooks";
    }

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable("id") Long id, ModelMap model) {
        model.put("book", bookService.getById(id));
        return "book/info";
    }

    @GetMapping("/find")
    public String findByTittle(@RequestParam String title, Model model) {
        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("allBooks", books);
        return "book/allBooks";
    }

    @PostMapping
    public String addBook(@ModelAttribute Book book) {
        bookService.add(book);
        return "forward:/book/allBooks";
    }
}
