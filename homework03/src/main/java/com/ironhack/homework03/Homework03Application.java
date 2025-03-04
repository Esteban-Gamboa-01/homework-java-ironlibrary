package com.ironhack.homework03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;

@SpringBootApplication
public class Homework03Application implements CommandLineRunner {

	@Autowired
	Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(Homework03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		menu.showMenu();
		boolean res = true;
		do{
			res = menu.selectCommand();
		}while(res);
		menu.closeScanner();

		// End the program
//		System.exit(0);
	}
}
