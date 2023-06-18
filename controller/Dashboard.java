package pft.controller;

import java.util.Scanner;
import pft.model.ExpenseRepository.ExpenseMain;

import pft.model.IncomeRepository.IncomeMain;


public class Dashboard {
      public static void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("==== Personal Finance Tracker ====");
            System.out.println("1. IncomeMenu ");
            System.out.println("2. ExpenseMenu ");

            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    IncomeMain.main(null);
                    break;
               case 2:
                    ExpenseMain.main(null);
               
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Exiting Personal Finance Tracker. Goodbye!");
    }
}
