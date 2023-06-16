package pft.model;

import java.util.Scanner;

public class IncomeExpenseMain {
    public static void main(String[] args) {
        IncomeExpenseService<String> incomeExpenseService = new IncomeExpenseService<>();

        // Creating IncomeMenu and ExpenseMenu instances
        IncomeMenu<String> incomeMenu = new IncomeMenu<>(incomeExpenseService);
        ExpenseMenu<String> expenseMenu = new ExpenseMenu<>(incomeExpenseService);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 'i' for income menu or 'e' for expense menu: ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("i")) {
            incomeMenu.showMenu("i");
        } else if (choice.equalsIgnoreCase("e")) {
            expenseMenu.showMenu("e");
        } else {
            System.out.println("Invalid choice. Exiting...");
        }
    }
}
