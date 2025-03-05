package com.ironhack.homework03;

import com.ironhack.homework03.model.*;
import com.ironhack.homework03.repository.AuthorRepository;
import com.ironhack.homework03.repository.BookRepository;
import com.ironhack.homework03.repository.IssueRepository;
import com.ironhack.homework03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Menu {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    public BookRepository bookRepository;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    StudentRepository studentRepository;

    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println(Style.BOLD + "\n--------------------------------- COMMAND LIST ---------------------------------\n" + Style.RESET);
        System.out.println(
                "1 " + Style.SUCCESS_BG + Style.BOLD + " ADD BOOK " + Style.RESET +
                        "\n2 " + Style.SUCCESS_BG + Style.BOLD + " SEARCH BOOK TITLE " + Style.RESET +
                        "\n3 " + Style.SUCCESS_BG + Style.BOLD + " SEARCH BOOK CATEGORY " + Style.RESET +
                        "\n4 " + Style.SUCCESS_BG + Style.BOLD + " SEARCH BOOK AUTHOR " + Style.RESET +
                        "\n5 " + Style.SUCCESS_BG + Style.BOLD + " LIST BOOK AUTHOR " + Style.RESET +
                        "\n6 " + Style.SUCCESS_BG + Style.BOLD + " ISSUE BOOK STUDENT " + Style.RESET +
                        "\n7 " + Style.SUCCESS_BG + Style.BOLD + " LIST BOOK USN " + Style.RESET +
                        "\n8 " + Style.SUCCESS_BG + Style.BOLD + " EXIT  " + Style.RESET);
        System.out.println(Style.BOLD + "\n--------------------------------------------------------------------------------" + Style.RESET);

    }

    public boolean selectCommand(){
        boolean option = true;

        System.out.println("\nPlease introduce a command:");
        try {
            int cmd = scanner.nextInt();
            scanner.nextLine();
                try{
                    sanitize(cmd);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        } catch (InputMismatchException e) {
            // If the input is not a number
            System.out.println(Style.ERROR + "Invalid input. Please enter a valid number." + Style.RESET);
            scanner.nextLine();
        }

        return option;
    }

    public void sanitize(int option){

        switch (option) {
            case 0:
                showMenu();
                break;
            case 1:
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
                System.out.println("Book saved succesfully\n");

                // ADD BOOK

                break;
            case 2:
                // SEARCH BOOK BY TITLE

                break;
            case 3:
                // SEARCH BOOK BY CATEGORY

                break;
            case 4:
                // SEARCH BOOK BY AUTHOR
                System.out.println("Please Introduce the Author's Name: ");
                String res4 = scanner.nextLine();
                Optional<Author> author4 = authorRepository.findByName(res4);
                if(author4.isPresent()){
                    System.out.println("The following book matches the author: ");
                    System.out.println(author4.get().getAuthorbook().toString());
                }else{
                    System.out.println("No book found for author.");
                }
                break;
            case 5:
                // LIST ALL BOOKS ALONG WITH AUTHOR
                List<Author> authorList = authorRepository.findAll();
                for(Author a : authorList){
                    System.out.println(a.toString());
                }
                break;
            case 6:
                // ISSUE BOOK TO STUDENT
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


                break;
            case 7:
                // LIST BOOKS BY USN

                break;
            case 8:
                // EXIT
                System.out.println(Style.SUCCESS_BG+Style.BOLD + "Exiting program..." + Style.RESET);

                // End the program safe
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException(Style.ERROR + "Invalid Option." + Style.RESET);
        }
    }


    public void closeScanner(){
        scanner.close();
    }

}

