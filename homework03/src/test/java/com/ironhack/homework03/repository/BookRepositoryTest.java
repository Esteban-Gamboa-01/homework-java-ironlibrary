package com.ironhack.homework03.repository;

import com.ironhack.homework03.model.Author;
import com.ironhack.homework03.model.Book;
import com.ironhack.homework03.model.Issue;
import com.ironhack.homework03.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    StudentRepository studentRepository;

    Issue issue;
    Author author;
    Book book;
    Student student;

    @BeforeEach
//    public void setUp(){
//        Student student = new Student("STUDENT130", "John Doe", null);
//        Student student2 = new Student("STUDENT500", "Alice Dean", null);
//        studentRepository.save(student);
//        studentRepository.save(student2);
//
//        Book book1 = new Book("123456789", "Da Vinci Code", "Mystery", 5, null, null);
//        Book book2 = new Book("987654321", "Inferno", "Thriller", 3, null, null);
//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        Issue issue1 = new Issue(1,"2022-08-01", "2022-08-15", student, book1);
//
//        Issue issue2 = new Issue(2,"2022-09-01", "2022-09-15", student2, book2);
//        issueRepository.save(issue1);
//        issueRepository.save(issue2);
//    }

    @AfterEach
    public void tearDown(){
        issueRepository.deleteAll();
        studentRepository.deleteAll();
        authorRepository.deleteAll();
        bookRepository.deleteAll();
    }

//    @Test
//    void findAllWhereUsnParams() {
//        List<Object[]> result = bookRepository.findAllWhereUsnParams("STUDENT130");
//        System.out.println("Book Title: " + result.get(0)[0] + " - Student Name: " + result.get(0)[1] + " - Return Date: " + result.get(0)[2]);
//
//        assertEquals("Da Vinci Code", result.get(0)[0]);
//
//    }

    @Test
    void findAllWhereUsnParams() {
        Issue secondIssue = new Issue();
        secondIssue.setIssueDate("2025-03-04");
        secondIssue.setReturnDate("2025-03-10");
        student = new Student();
        student.setUsn("STUDENT2");
        book = new Book();
        book.setIsbn("COOLBOOK2");
        author = new Author();
        author.setAuthorbook(book);
        studentRepository.save(student);
        authorRepository.save(author);

        Optional<Book> newBook = bookRepository.findById("COOLBOOK2");
        Optional<Student> newStudent = studentRepository.findById("STUDENT2");

        secondIssue.setIssuestudent(newStudent.get());
        secondIssue.setIssuebook(newBook.get());

        issueRepository.save(secondIssue);

        assertNotNull(issueRepository.findAll());
    }
}