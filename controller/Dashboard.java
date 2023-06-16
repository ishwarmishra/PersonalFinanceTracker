package pft.controller;

import java.util.Scanner;

import pft.model.IncomeExpenseMain;


public class Dashboard {
      public static void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("==== Personal Finance Tracker ====");
            System.out.println("1. IncomeExpenseMenu ");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    IncomeExpenseMain.main(null);
                    break;
                
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Exiting Personal Finance Tracker. Goodbye!");
    }
}
