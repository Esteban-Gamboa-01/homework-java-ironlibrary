package com.ironhack.homework03.model;

import jakarta.persistence.CascadeType;
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




        @OneToOne(mappedBy = "authorbook")
        private Author author;
//    private Book book;

        @OneToOne(mappedBy = "issuebook") //, cascade = CascadeType.REMOVE, orphanRemoval = true
        private Issue issue;

        @Override
        public String toString() {
            return "Book{" +
                    "isbn='" + isbn + '\'' +
                    ", title='" + title + '\'' +
                    ", category='" + category + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }
