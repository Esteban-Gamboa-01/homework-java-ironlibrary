package com.ironhack.homework03.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository {

    @Modifying
    @Transactional
    @Query("INSERT INTO Book (isbn, title, category, quality) VALUES (:isbn, :title, :category, :quality)")
    void addBook(@Param("isbn") String isbn ,@Param("title") String title, @Param("category") String category, @Param("quality") Integer quality);

    Book findByTitle(String title);
    Book findByCategory(String category);
    Book findByAuthor(String author);

}
