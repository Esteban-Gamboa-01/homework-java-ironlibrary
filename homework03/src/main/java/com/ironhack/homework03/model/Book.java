package com.ironhack.homework03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
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

//    @OneToOne(mappedBy = "authorbook")
=======
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

        public Book(String isbn, String title, String category, int quantity) {
            this.isbn = isbn;
            this.title = title;
            this.category = category;
            this.quantity = quantity;
        }

        //    @OneToOne(mappedBy = "authorbook")
>>>>>>> maindev03
//    private Book book;
//
//    @OneToOne(mappedBy = "issuebook")
//    private Issue issue;
}
