package library.app.spring.controller;

import java.util.List;

import library.app.spring.entity.Book;
import library.app.spring.service.BookService;
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

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.listBooks());
        return "book/all";
    }

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable("id") Long id, ModelMap model) {
        model.put("book", bookService.getById(id));
        return "book/info";
    }

    @GetMapping("/find")
    public String findByTittle(@RequestParam String title, Model model) {
        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("all", books);
        return "book/all";
    }

    @PostMapping("/create")
    public String addBook(@ModelAttribute Book book, ModelMap model) {
        bookService.add(book);
        return getAllBooks(model);
    }

    @GetMapping("/create")
    public String addBookPage() {
        return "book/create";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("book_id") Long id, ModelMap modelMap) {
        bookService.delete(id);
        return getAllBooks(modelMap);
    }
}
