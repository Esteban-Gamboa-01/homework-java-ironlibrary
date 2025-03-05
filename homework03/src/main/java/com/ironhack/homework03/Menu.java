package com.ironhack.homework03;

import com.ironhack.homework03.model.Style;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
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
}

