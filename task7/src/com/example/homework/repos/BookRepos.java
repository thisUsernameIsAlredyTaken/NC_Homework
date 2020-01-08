package com.example.homework.repos;

import com.example.homework.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepos extends JpaRepository<Book, Long> {

    interface BookPrice {
        String getTitle();

        double getPrice();
    }

    @Query("select b from Book b")
    List<BookPrice> findTitleAndPrice();

    @Query("select b from Book b " +
            "where upper(b.title) like upper(:pattern) or b.price > :price " +
            "order by b.title")
    List<BookPrice> findTitleAndPriceByTitleLikeOrPriceGreaterThan(
            @Param("pattern") String pattern,
            @Param("price") double price
    );
}
