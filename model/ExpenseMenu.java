package pft.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseMenu<T> {
    private IncomeExpenseService<T> service;

    public ExpenseMenu(IncomeExpenseService<T> service) {
        this.service = service;
    }

    public void showMenu(String e) {
        int choice;
        if(e=="i"){
        Scanner scanner = service.getScanner();

        do {
            System.out.println("Expense Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expense Sources");
            System.out.println("3. Delete Expense Source");
            System.out.println("4. Update Expense Source");
            System.out.println("5. Find Expense Source by ID");
            System.out.println("6. Find particular data of Expense Source by ID");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense source: ");
                    scanner.nextLine();
                    T expense = (T) scanner.nextLine();

                    System.out.print("Enter the amount: ");
                    BigDecimal amount = scanner.nextBigDecimal();

                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.next();
                    LocalDate date = service.parseDate(dateInput);
                    if (date != null) {
                        service.addIncome(expense, amount, date);
                        System.out.println("Expense source added with ID: " + (service.getNextId() - 1));
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 2:
                    service.displayIncomeSources();
                    break;
                case 3:
                    System.out.print("Enter the ID of the expense source to delete: ");
                    int id = scanner.nextInt();
                    service.deleteIncome(id);
                    break;
                case 4:
                    System.out.print("Enter the ID of the expense source to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter the new expense source: ");
                    scanner.nextLine();
                    T newExpense = (T) scanner.nextLine();

                    System.out.print("Enter the new amount: ");
                    BigDecimal newAmount = scanner.nextBigDecimal();

                    System.out.print("Enter the new date (dd/mm/yyyy): ");
                    String newDateInput = scanner.next();
                    LocalDate newDate = service.parseDate(newDateInput);
                    if (newDate != null) {
                        service.updateIncome(updateId, newExpense, newAmount, newDate);
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the ID of the expense source to find: ");
                    int findId = scanner.nextInt();
                    service.findIncomeById(findId);
                    break;
                case 6:
                    System.out.print("Enter the ID of the expense source to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the column to search (id, source, amount, date): ");
                    String searchColumn = scanner.nextLine();
                    service.findParticularColumnById(searchId, searchColumn);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 7);
    }
  }
    
}
