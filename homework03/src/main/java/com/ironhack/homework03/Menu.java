package com.ironhack.homework03;

import com.ironhack.homework03.model.Style;
import com.ironhack.homework03.repository.AuthorRepository;
import com.ironhack.homework03.repository.BookRepository;
import com.ironhack.homework03.repository.IssueRepository;
import com.ironhack.homework03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    AuthorRepository authorRepository;
    BookRepository bookRepository;
    IssueRepository issueRepository;
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
            case 1:
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

                break;
            case 5:
                // LIST ALL BOOKS ALONG WITH AUTHOR

                break;
            case 6:
                // ISSUE BOOK TO STUDENT

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

