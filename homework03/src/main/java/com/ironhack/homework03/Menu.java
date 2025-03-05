package com.ironhack.homework03;

import com.ironhack.homework03.model.Style;
import org.springframework.stereotype.Component;

@Component
public class Menu {

    public void showMenu(){
        System.out.println(Style.SUCCESS+Style.BOLD + "\nFantastic! All data introduced is correct. Then, we provide a command list " +
                "for managing or adding a new information." + Style.RESET);
        System.out.println(Style.BOLD + "\n--------------------------------- COMMAND LIST ---------------------------------\n" + Style.RESET);
        System.out.println(
                "1 "+Style.SUCCESS_BG+Style.BOLD+" Add a book "+Style.RESET+
                        "\n2 "+Style.SUCCESS_BG+Style.BOLD+" Search book by title "+Style.RESET+
                        "\n3 "+Style.SUCCESS_BG+Style.BOLD+" Search book by category " +Style.RESET+
                        "\n4 "+Style.SUCCESS_BG+Style.BOLD+" Search book by Author "+ Style.RESET+
                        "\n5 "+Style.SUCCESS_BG+Style.BOLD+" List all books along with author " +Style.RESET+
                        "\n6 "+Style.SUCCESS_BG+Style.BOLD+" Issue book to student "+ Style.RESET+
                        "\n7 "+Style.SUCCESS_BG+Style.BOLD+" List books by usn " +Style.RESET+
                        "\n8 "+Style.SUCCESS_BG+Style.BOLD+" Exit "+ Style.RESET);
        System.out.println(Style.BOLD + "\n--------------------------------------------------------------------------------" + Style.RESET);

    }
}
