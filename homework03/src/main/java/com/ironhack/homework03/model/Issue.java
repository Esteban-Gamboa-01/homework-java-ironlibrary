package com.ironhack.homework03.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;
    private String issueDate;
    private String returnDate;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book issueBook;

}