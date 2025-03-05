package com.ironhack.homework03;

import com.ironhack.homework03.model.Style;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    Scanner scanner = new Scanner(System.in);
    public Menu() {
    }

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

    public boolean selectCommand(){
        boolean option = true;

        System.out.println("\nPlease introduce a command:");
        String cmd = scanner.nextLine();
        cmd = cmd.toUpperCase();
        if(cmd.equals("EXIT")){
            option = false;
            scanner.close();
        }else{
            try{
//                sanitize(cmd);
            } catch (Exception e) {
                //System.out.println("Command not recognized, please try again.");
                System.out.println(e.getMessage());
            }
        }
        //scanner.close();
        return option;
    }

//    public void sanitize(String args){
//        //boolean sanitize = false;
//        String[] values = args.split( " ");
//        if (values.length > 3 && !values[0].equals("EXIT")) throw new IllegalArgumentException(Style.ERROR + "Too many arguments." + Style.RESET);
//        if (values.length < 2 && !values[0].equals("EXIT")) throw new IllegalArgumentException(Style.ERROR + "Too few arguments." + Style.RESET);
//
//        CommandFunction command = new CommandFunction();
//
//        // COMMANDO ENROLL
//        if(values.length == 3 && values[0].equals("ENROLL")){
//            if(isValidStudentId(values[1]) && isValidCourseId(values[2])){
//                command.enroll(values[1],values[2]);
//            }else{
//                throw new IllegalArgumentException(Style.ERROR + "Parameters for ENROLL are incorrect." + Style.RESET);
//            }
//            // COMMANDO ASSIGN
//        }else if (values.length == 3 && values[0].equals("ASSIGN")){
//            if(isValidTeacherId(values[1]) && isValidCourseId(values[2])){
//                command.assign(values[1],values[2]);
//            }else{
//                throw new IllegalArgumentException(Style.ERROR + "Parameters for ASSIGN are incorrect." + Style.RESET);
//            }
//            // COMMANDO SHOW
//        }else if(values[0].equals("SHOW") && values.length == 2){
//            if(values[1].equals("COURSES")){
//                command.showCourses();
//            }else if(values[1].equals("STUDENTS")){
//                command.showStudents();
//            }else if(values[1].equals("TEACHERS")){
//                command.showTeachers();
//            }else if(values[1].equals("PROFIT")){
//                command.showProfit();
//            }else{
//                throw new IllegalArgumentException(Style.ERROR + "Invalid parameters for SHOW." + Style.RESET);
//            }
//            // COMMANDO LOOKUP
//        }else if(values[0].equals("LOOKUP") && values.length == 3) {
//            if (values[1].equals("STUDENT") && isValidStudentId(values[2])) {
//                command.lookupStudent(values[2]);
//            } else if (values[1].equals("COURSE") && isValidCourseId(values[2])) {
//                command.lookupCourse(values[2]);
//            } else if (values[1].equals("TEACHER") && isValidTeacherId(values[2])) {
//                command.lookupTeacher(values[2]);
//            } else {
//                throw new IllegalArgumentException(Style.ERROR + "Invalid parameters for LOOKUP." + Style.RESET);
//            }
//            //showStudentsByCourse and showTeachersByCourse
//        }else if(values[0].equals("SHOW") && values.length == 3){
//            if(values[1].equals("ENLISTED") && isValidCourseId(values[2])){
//                command.showStudentsByCourse(values[2]);
//            }else if(values[1].equals("ASSIGNED") && isValidCourseId(values[2])){
//                command.showTeachersByCourse(values[2]);
//            }else if(values[1].equals("MONEY") && values[2].equals("SPENT")){
//                command.showMoneySpent();
//            }else if(values[1].equals("MONEY") && values[2].equals("EARNED")){
//                command.showMoneyEarned();
//            }else{
//                throw new IllegalArgumentException("Invalid parameters for SHOW");
//            }
//        }else{
//            throw new IllegalArgumentException(Style.ERROR + "Invalid Command." + Style.RESET);
//        }
//        //return sanitize;
//    }

    public void closeScanner() {
        this.scanner.close();
    }
}
