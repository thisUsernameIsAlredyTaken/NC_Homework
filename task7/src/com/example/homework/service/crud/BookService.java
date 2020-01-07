package com.example.homework.service.crud;

import com.example.homework.entity.Book;
import com.example.homework.repos.BookRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepos bookRepos;

    public boolean add(Book book) {
        if (book == null || book.getId() != null) {
            return false;
        }
        bookRepos.save(book);
        return true;
    }

    public Book findById(long id) {
        if (id < 1) {
            return null;
        }
        return bookRepos.findById(id).orElse(null);
    }

    public boolean update(Book book) {
        if (book == null || book.getId() == null) {
            return false;
        }
        if (!isExist(book.getId())) {
            return false;
        }
        bookRepos.save(book);
        return true;
    }

    public boolean deleteById(long id) {
        if (!isExist(id)) {
            return false;
        }
        bookRepos.deleteById(id);
        return true;
    }

    public List<Book> findAll() {
        return bookRepos.findAll();
    }

    public boolean patchById(long id, String title, Double price,
                             String warehouse, Integer amount) {
        Book book = findById(id);
        if (book == null) {
            return false;
        }
        Optional.ofNullable(title).ifPresent(book::setTitle);
        Optional.ofNullable(price).ifPresent(book::setPrice);
        Optional.ofNullable(warehouse).ifPresent(book::setWarehouse);
        Optional.ofNullable(amount).ifPresent(book::setAmount);
        bookRepos.save(book);
        return true;
    }


    public boolean isExist(long id) {
        if (id < 1) {
            return false;
        }
        return bookRepos.existsById(id);
    }
}
