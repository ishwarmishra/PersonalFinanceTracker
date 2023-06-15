package pft;

import java.util.Scanner;

public class Dashboard {
      public static void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("==== Personal Finance Tracker ====");
            System.out.println("1. Income Tracker");
            System.out.println("2. Expense Tracker");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    IncomeTrackerCLI.main(null);
                    break;
                case 2:
                    ExpenseTrackerCLI.main(null);
                    break;
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
