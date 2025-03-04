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
public class Student {
    @Id
    private String usn;
    private String name;

    @OneToOne(mappedBy = "issuestudent" ,  cascade = CascadeType.ALL, orphanRemoval = true)
    private Issue issue;
}