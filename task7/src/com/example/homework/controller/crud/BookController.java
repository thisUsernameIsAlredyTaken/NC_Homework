package com.example.homework.controller.crud;

import com.example.homework.entity.Book;
import com.example.homework.service.crud.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void addBook(@RequestBody Book book,
                        HttpServletResponse response) {
        if (bookService.add(book)) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @GetMapping("{id}")
    public Book findBookById(@PathVariable long id,
                             HttpServletResponse response) {
        Book book = bookService.findById(id);
        if (book == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return book;
    }

    @PutMapping("{id}")
    public void updateBook(@PathVariable long id,
                           @RequestBody Book book,
                           HttpServletResponse response) {
        if (book.getId() != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        book.setId(id);
        if (bookService.update(book)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable long id,
                           HttpServletResponse response) {
        if (bookService.deleteById(id)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
    //

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }

    @PatchMapping("{id}")
    public void patchBook(@PathVariable long id,
                          @RequestParam(required = false) String title,
                          @RequestParam(required = false) Double price,
                          @RequestParam(required = false) String warehouse,
                          @RequestParam(required = false) Integer amount,
                          HttpServletResponse response) {
        if (bookService.patchById(id, title, price, warehouse, amount)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
