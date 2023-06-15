package pft;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IncomeDetails<T> implements IncomeExpensedetails<T> {

    private List<Income> incomeSources;
    private Map<Integer, Income>incomeMap;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;
    private int nextId;

    public IncomeDetails() {
        incomeSources = new ArrayList<>();
        incomeMap = new HashMap<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nextId = 1;
    }

    @Override
    public void addIncome(T income,double amount, LocalDate date) {
        Income newIncome = new Income(income,amount, date,nextId);
        incomeSources.add(newIncome);
        incomeMap.put(nextId, newIncome);
        nextId++;
    }

    @Override
    public void displayIncomeSources() {
        if (incomeSources.isEmpty()) {
            System.out.println("No income sources added.");
        } else {
            System.out.println("Income Sources:");
            for (Income income : incomeSources) {
                System.out.println(income.id + "-" +income.source + " - " + income.amount+ "-"+ income.date.format(dateFormatter));
                

            }
        }
    }

    @Override
    public void showMenu() {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Income");
            System.out.println("2. Display Income Sources");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income source: ");
                    scanner.nextLine(); // Consume the newline character
                    T income = (T) scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.next();
                    LocalDate date = parseDate(dateInput);
                    if (date != null) {
                        addIncome(income,amount,date);
                        System.out.println("Income source added with ID: "+ (nextId-1));
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 2:
                    displayIncomeSources();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 3);
    }

    private LocalDate parseDate(String dateInput) {
        try {
            return LocalDate.parse(dateInput, dateFormatter);
        } catch(Exception e) {
            return null;
        }

    }
}
