package com.ironhack.homework03.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    private String usn;
    private String name;

    @OneToOne(mappedBy = "issueStudent", cascade = CascadeType.ALL)
    private Issue issue;

    public Student() {
    }

    public Student(String usn, String name) {
        this.usn = usn;
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "usn='" + usn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
