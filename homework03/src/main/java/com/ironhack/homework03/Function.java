package com.ironhack.homework03;

import com.ironhack.homework03.model.*;
import com.ironhack.homework03.repository.AuthorRepository;
import com.ironhack.homework03.repository.BookRepository;
import com.ironhack.homework03.repository.IssueRepository;
import com.ironhack.homework03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Function {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    StudentRepository studentRepository;

    private final Scanner scanner = new Scanner(System.in);

    public void addBook(){

        System.out.println("Please introduce the data to add a new book.");
        Book book =  new Book();
        System.out.print("Introduce ISBN: ");
        String res = scanner.nextLine();
        book.setIsbn(res);
        System.out.print("Introduce Title: ");
        res = scanner.nextLine();
        book.setTitle(res);
        System.out.print("Introduce Category: ");
        res = scanner.nextLine();
        book.setCategory(res);
        Author author = new Author();
        System.out.print("Introduce Author Name: ");
        res = scanner.nextLine();
        author.setName(res);
        System.out.print("Introduce Author Email: ");
        res = scanner.nextLine();
        author.setEmail(res);
        System.out.print("Enter number of books: ");
        res = scanner.nextLine();
        book.setQuantity(Integer.parseInt(res));
        author.setAuthorbook(book);
        authorRepository.save(author);

//        System.out.print("Enter isbn : ");
//        String isbn = scanner.nextLine();
//
//        System.out.print("Enter title : ");
//        String title = scanner.nextLine();
//
//        System.out.print("Enter category : ");
//        String category = scanner.nextLine();
//
//        System.out.print("Enter Author name : ");
//        String authorName = scanner.nextLine();
//
//        System.out.print("Enter Author mail : ");
//        String authorMail = scanner.nextLine();
//
//        System.out.print("Enter number of books : ");
//        int numBooks = scanner.nextInt();
//
//        Book book = new Book();
//        book.setIsbn(isbn);
//        book.setTitle(title);
//        book.setCategory(category);
//        book.setQuantity(numBooks);
//
//        Author author = new Author();
//        author.setName(authorName);
//        author.setEmail(authorMail);
//
//        book.setAuthor(author);
//        author.setAuthorbook(book);
//
//        // Save author before assign to book
//        authorRepository.save(author);
//
//        // Save book with the author
//        bookRepository.save(book);

        System.out.println(Style.SUCCESS_BG+Style.BOLD+ "The book with isbn " +
                "( " + Style.SUCCESS  + book.getIsbn() + Style.RESET+Style.SUCCESS_BG+Style.BOLD + " ) " +
                "has been saved " + Style.SUCCESS + "successfully." + Style.RESET+Style.SUCCESS_BG+Style.BOLD + " " + Style.RESET);
    }

    public void searchBookByTitle(){
        System.out.print("Please Introduce the Book's Title : ");
        String title = scanner.nextLine();
        Optional<Book> book2 = bookRepository.findByTitle(title);
        if(book2.isPresent()){
//            System.out.println("The following book matches the author : ");
//            System.out.println(book2.get().getIsbn() + " - " + book2.get().getTitle() + " - " + book2.get().getCategory() + " - " + book2.get().getQuantity());

            System.out.printf(Style.BOLD + "\n%-20s %-20s %-15s %-10s%n" + Style.RESET,
                    "Book ISBN",
                    "Book Title",
                    "Category",
                    "No of Books");

            System.out.printf(Style.STUDENT + "%-20s %-20s %-15s %-10d%n" + Style.RESET,
                    book2.get().getIsbn(),
                    book2.get().getTitle(),
                    book2.get().getCategory(),
                    book2.get().getQuantity());

        }else{
            System.out.println(Style.NOT_FOUND + "No book found by title." + Style.RESET);
        }
    }

    public void searchBookByCategory(){
        System.out.print("Please Introduce the Book's Category : ");
        String category = scanner.nextLine();
        Optional<Book> book3 = bookRepository.findByCategory(category);
        if(book3.isPresent()){
//            System.out.println("The following book matches the author : ");
//            System.out.println(book3.get().getIsbn() + " - " + book3.get().getTitle() + " - " + book3.get().getCategory() + " - " + book3.get().getQuantity());
            System.out.printf(Style.BOLD + "\n%-20s %-20s %-15s %-10s%n" + Style.RESET,
                    "Book ISBN",
                    "Book Title",
                    "Category",
                    "No of Books");

            System.out.printf(Style.STUDENT + "%-20s %-20s %-15s %-10d%n" + Style.RESET,
                    book3.get().getIsbn(),
                    book3.get().getTitle(),
                    book3.get().getCategory(),
                    book3.get().getQuantity());
        }else{
            System.out.println(Style.NOT_FOUND + "No book found by category." + Style.RESET);
        }
    }

    public void searchBookByAuthor(){
        System.out.print("Please Introduce the Author's Name : ");
        String res4 = scanner.nextLine();
        Optional<Author> author4 = authorRepository.findByName(res4);
        if(author4.isPresent()){
//            System.out.println("The following book matches the author : ");
//            System.out.println(author4.get().getAuthorbook().toString());
            System.out.printf(Style.BOLD + "\n%-20s %-20s %-15s %-10s%n" + Style.RESET,
                    "Book ISBN",
                    "Book Title",
                    "Category",
                    "No of Books");

            System.out.printf(Style.STUDENT + "%-20s %-20s %-15s %-10d%n" + Style.RESET,
                    author4.get().getAuthorbook().getIsbn(),
                    author4.get().getAuthorbook().getTitle(),
                    author4.get().getAuthorbook().getCategory(),
                    author4.get().getAuthorbook().getQuantity());
        }else{
            System.out.println(Style.NOT_FOUND + "No book found for author." + Style.RESET);
        }
    }

    public void searchBooksWithAuthor(){
        List<Author> authorList = authorRepository.findAll();
        System.out.printf(Style.BOLD + "\n%-20s %-20s %-15s %-15s %-25s %-20s%n" + Style.RESET,
                "Book ISBN",
                "Book Title",
                "Category",
                "No of Books",
                "Author name",
                "Author mail");

        for(Author a : authorList){
//            System.out.println(a.toString());
            System.out.printf(Style.STUDENT + "%-20s %-20s %-15s %-15d %-25s %-20s%n" + Style.RESET,
                    a.getAuthorbook().getIsbn(),
                    a.getAuthorbook().getTitle(),
                    a.getAuthorbook().getCategory(),
                    a.getAuthorbook().getQuantity(),
                    a.getName(),
                    a.getEmail());
        }
    }

    public void issueBookToStudent(){
        Issue issue = new Issue();
        Student student = new Student();
        System.out.println("Enter usn: ");
        String res6 = scanner.nextLine();
        student.setUsn(res6);
        System.out.println("Enter student name: ");
        res6 = scanner.nextLine();
        student.setName(res6);
        System.out.println("Enter isbn: ");
        res6 = scanner.nextLine();
        Optional<Book> book6 = bookRepository.findById(res6);
        if(book6.isPresent()){// CASCADE EFFECT
            studentRepository.save(student);
            issue.setIssuestudent(student);
            issue.setIssuebook(book6.get());
            issue.setIssueDate("Now");
            issue.setReturnDate("In one week");
            issueRepository.save(issue);
            System.out.println("Issue and student registered correctly.");
        }else{
            System.out.println("Could not find that book.");
        }
    }

    public void searchBooksByUsn(){
        System.out.print("Please Introduce an USN : ");
        String res7 = scanner.nextLine();
        List<Object[]> bookList = bookRepository.findAllWhereUsnParams(res7);
        if(!bookList.isEmpty()){
//            System.out.println(bookList.get(0)[0] +  " - " + bookList.get(0)[1] + " - "  + bookList.get(0)[2]);
            System.out.printf(Style.BOLD + "\n%-20s %-20s %-30s%n" + Style.RESET,
                    "Book Title",
                    "Student Name",
                    "Return date");

            System.out.printf(Style.STUDENT + "%-20s %-20s %-30s%n" + Style.RESET,
                    bookList.get(0)[0],
                    bookList.get(0)[1],
                    bookList.get(0)[2]);
        }else{
            System.out.println(Style.NOT_FOUND + "No book found by usn." + Style.RESET);
        }
    }

}
