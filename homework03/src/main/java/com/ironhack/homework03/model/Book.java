package com.ironhack.homework03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String isbn;
    private String title;
    private String category;
    private int quantity;

    @OneToOne(mappedBy = "authorBook")
    private Book book;

    @OneToOne(mappedBy = "issueBook")
    private Issue issue;
}
