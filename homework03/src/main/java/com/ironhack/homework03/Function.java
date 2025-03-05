package com.ironhack.homework03;

import com.ironhack.homework03.model.Author;
import com.ironhack.homework03.model.Book;
import com.ironhack.homework03.model.Style;
import com.ironhack.homework03.repository.AuthorRepository;
import com.ironhack.homework03.repository.BookRepository;
import com.ironhack.homework03.repository.IssueRepository;
import com.ironhack.homework03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
//        Author author = new Author();
//        Book book = new Book();

        System.out.print("Enter isbn : ");
        String isbn = scanner.nextLine();

        System.out.print("Enter title : ");
        String title = scanner.nextLine();

        System.out.print("Enter category : ");
        String category = scanner.nextLine();

        System.out.print("Enter Author name : ");
        String authorName = scanner.nextLine();

        System.out.print("Enter Author mail : ");
        String authorMail = scanner.nextLine();

        System.out.print("Enter number of books : ");
        int numBooks = scanner.nextInt();

        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setCategory(category);
        book.setQuantity(numBooks);

        Author author = new Author();
        author.setName(authorName);
        author.setEmail(authorMail);

        book.setAuthor(author);
        author.setAuthorbook(book);

        // Save author before assign to book
        authorRepository.save(author);

        // Save book with the author
        bookRepository.save(book);

        System.out.println(Style.SUCCESS_BG+Style.BOLD+ "The book with isbn " +
                "( " + Style.SUCCESS  + book.getIsbn() + Style.RESET+Style.SUCCESS_BG+Style.BOLD + " ) " +
                "has been saved " + Style.SUCCESS + "successfully." + Style.RESET+Style.SUCCESS_BG+Style.BOLD + " " + Style.RESET);
    }

    public void searchBookByTitle(String title){

    }

}
