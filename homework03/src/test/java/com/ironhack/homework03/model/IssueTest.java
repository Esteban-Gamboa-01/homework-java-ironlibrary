package com.ironhack.homework03.model;

import com.ironhack.homework03.repository.AuthorRepository;
import com.ironhack.homework03.repository.BookRepository;
import com.ironhack.homework03.repository.IssueRepository;
import com.ironhack.homework03.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueTest {


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
    public void setUp(){
        student = new Student();
        student.setUsn("STU001");
        book = new Book();
        book.setIsbn("SBN01");
        book.setTitle("Long Jaw");
        author = new Author();
        issue = new Issue();
    }

    @AfterEach
    public void tearDown(){
        issueRepository.deleteAll();
        authorRepository.deleteAll();
        bookRepository.deleteAll();
        studentRepository.deleteAll();
    }

    @Test
    public void savingAuthorCascadesBook_validAuthor_expectedBook(){
        author.setName("Robert");
        author.setAuthorbook(book);
        authorRepository.save(author);
        assertEquals("Long Jaw",bookRepository.findAll().get(0).getTitle());
    }

    @Test
    public void savingIssueCascadesBookOrStudent_validIssue_expectedBookAndStudent(){
        assertEquals(0,studentRepository.findAll().size());
        assertEquals(0,bookRepository.findAll().size());
        assertEquals(0,issueRepository.findAll().size());
        issue.setIssuebook(book);
        issue.setIssuestudent(student);
//        bookRepository.save(book);
//        studentRepository.save(student);
        issueRepository.save(issue);
        assertEquals(1,studentRepository.findAll().size());
        assertEquals(1,bookRepository.findAll().size());
        assertEquals(1,issueRepository.findAll().size());
    }


}