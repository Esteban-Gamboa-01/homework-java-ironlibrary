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

import java.util.Optional;

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
        author.setName("Robert");
        issue = new Issue();
    }

    @AfterEach
    public void tearDown(){ // EL ORDEN ES IMPORTANTE
        issueRepository.deleteAll();
        studentRepository.deleteAll();
        authorRepository.deleteAll();
        bookRepository.deleteAll();
    }

    @Test
    public void savingAuthorCascadesBook_validAuthor_expectedBook(){
        book.setIsbn("SBN01");
        book.setTitle("Long Jaw");
        author.setAuthorbook(book);
        author.setId(123);
        author.setName("Gionino");
        authorRepository.save(author);
        Optional<Book> caseBook = bookRepository.findById("SBN01");
        assertEquals("Long Jaw",caseBook.get().getTitle());
    }

    @Test
    public void savingIssueDoesNotCascadesBookOrStudent_validIssue_expectedBookAndStudent(){
        assertEquals(0,studentRepository.findAll().size());
        assertEquals(0,bookRepository.findAll().size());
        assertEquals(0,issueRepository.findAll().size());
        assertEquals(0,authorRepository.findAll().size());
        issue.setIssuebook(book);
        issue.setIssuestudent(student);
        bookRepository.save(book);
        studentRepository.save(student);
        issueRepository.save(issue);//necesary to save student and book items before
        assertEquals(1,studentRepository.findAll().size());
        assertEquals(1,bookRepository.findAll().size());
        assertEquals(1,issueRepository.findAll().size());
        assertEquals(0,authorRepository.findAll().size());
    }

    @Test
    public void savingIssueThenUsingMappedBy_validInput_mappedByWorking(){
        Author author = new Author();
        author.setName("Robert2");

        Book book = new Book();
        book.setIsbn("ISBN-022");
        book.setTitle("Introduction to Scripting");

        author.setAuthorbook(book);
        authorRepository.save(author);

        Student student = new Student();
        student.setUsn("USN-131");
        student.setName("Juanita Doe");
        studentRepository.save(student);

        Issue firstIssue = new Issue();
        firstIssue.setIssueDate("2025-03-04");
        firstIssue.setReturnDate("2025-03-10");
        firstIssue.setIssuestudent(student);
        firstIssue.setIssuebook(book);
        issueRepository.save(firstIssue);

        // NOW--- MAPPED BY!!

        Optional<Book> testBook = bookRepository.findById("ISBN-022");

        System.out.println(testBook.get().getIssue().getIssueId()+" is the issue id of this book," +
                "it is currently issued to "+testBook.get().getIssue().getIssuestudent().getName());

        System.out.println(testBook.get().getAuthor().getName()+" is the author of "+testBook.get().getTitle());
        assertEquals("Robert2",testBook.get().getAuthor().getName());
        assertEquals("Juanita Doe",testBook.get().getIssue().getIssuestudent().getName());


        Optional<Student> testStudent = studentRepository.findById("USN-131");
        System.out.println(testStudent.get().getName()+" has been issued the book "+testStudent.get().getIssue().getIssuebook().getTitle());
        assertEquals("Introduction to Scripting",testStudent.get().getIssue().getIssuebook().getTitle());
    }

    @Test
    public void createAuthorThenBookSaveAuthorSaveStudentSaveIssue_issueSaved(){
        Author author = new Author();
        author.setName("Robert");

        Book book = new Book();
        book.setIsbn("ISBN-001");
        book.setTitle("Introduction to Java");

        author.setAuthorbook(book);
        authorRepository.save(author);

        Student student = new Student();
        student.setUsn("USN-001");
        student.setName("Jane Doe");
        studentRepository.save(student);

        Issue firstIssue = new Issue();
        firstIssue.setIssueDate("2025-03-04");
        firstIssue.setReturnDate("2025-03-10");
        firstIssue.setIssuestudent(student);
        firstIssue.setIssuebook(book);
        issueRepository.save(firstIssue);

        // Uncomment to test exception
        /*Issue secondIssue = new Issue();
        secondIssue.setIssueDate("2025-03-05");
        secondIssue.setReturnDate("2025-03-15");
        secondIssue.setIssuestudent(student);
        secondIssue.setIssuebook(bookRepository.findById("ISBN-001")
                .orElseThrow(() -> new AssertionError("Book not found")));
        assertThrows(DataIntegrityViolationException.class, () -> {
            issueRepository.save(secondIssue);
        });*/

        assertNotNull(issueRepository.findAll());
    }

    @Test
    public void getBookWithoutAuthorAndStudentFromDatabaseAndAssignIssue_issueSaved(){
        Issue secondIssue = new Issue();
        secondIssue.setIssueDate("2025-03-04");
        secondIssue.setReturnDate("2025-03-10");
        student = new Student();
        student.setUsn("STUDENT");
        book = new Book();
        book.setIsbn("COOLBOOK");
        studentRepository.save(student);
        bookRepository.save(book);
        Optional<Book> newBook = bookRepository.findById("COOLBOOK");
        Optional<Student> newStudent = studentRepository.findById("STUDENT");
        secondIssue.setIssuestudent(newStudent.get());
        secondIssue.setIssuebook(newBook.get());
        issueRepository.save(secondIssue);
        System.out.println("Issue Repository Size: "+issueRepository.findAll().size());
        assertNotNull(issueRepository.findAll());
    }

    @Test
    public void getBookWithAuthorAndStudentFromDatabaseAndAssignIssue_issueSaved(){
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