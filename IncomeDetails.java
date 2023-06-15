package pft;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IncomeDetails<T> implements IncomeExpensedetails<T> {

    private List<Income> incomeSources;
    private Map<Integer, Income> incomeMap;
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
    public void addIncome(T income, double amount, LocalDate date) {
        Income newIncome = new Income(income, amount, date, nextId);
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
                System.out.println(income.id + " " + income.source + "  " + income.amount + " " + income.date.format(dateFormatter));

            }
        }
    }

    @Override
    public void deleteIncome(int id) {
        Income income = incomeMap.get(id);
        if (income != null) {
            incomeSources.remove(income);
            incomeMap.remove(id);
            System.out.println("Income source with ID " + id + " deleted.");
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void updateIncome(int id, T newIncome, double newAmount, LocalDate newDate) {
        Income income = incomeMap.get(id);
        if (income != null) {
            income.source = newIncome;
            income.amount = newAmount;
            income.date = newDate;
            System.out.println("Income source with ID " + id + " updated.");
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void findIncomeById(int id) {
        Income income = incomeMap.get(id);
        if (income != null) {
            System.out.println("Income Source Details:");
            System.out.println("ID: " + income.id);
            System.out.println("Source: " + income.source);
            System.out.println("Amount: " + income.amount);
            System.out.println("Date: " + income.date.format(dateFormatter));
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void findParticularColumnById(int id, String column) {
        Income income = incomeMap.get(id);
        if (income != null) {
            System.out.println("Income Source Details:");
            switch (column.toLowerCase()) {
                case "id":
                    System.out.println("ID: " + income.id);
                    break;
                case "source":
                    System.out.println("Source: " + income.source);
                    break;
                case "amount":
                    System.out.println("Amount: " + income.amount);
                    break;
                case "date":
                    System.out.println("Date: " + income.date.format(dateFormatter));
                    break;
                default:
                    System.out.println("Invalid column. Available columns: id, source, amount, date");
                    return;
            }
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void showMenu() {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Income");
            System.out.println("2. Display Income Sources");
            System.out.println("3. Delete Income Source");
            System.out.println("4. Update Income Source");
            System.out.println("5. Find Income Source by id");
            System.out.println("6. Find particular data of Income Source by id");

            System.out.println("7. Exit");
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
                        addIncome(income, amount, date);
                        System.out.println("Income source added with ID: " + (nextId - 1));
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 2:
                    displayIncomeSources();
                    break;
                case 3:
                    System.out.print("Enter the ID of the income source to delete: ");
                    int id = scanner.nextInt();
                    deleteIncome(id);
                    break;
                case 4:
                    System.out.print("Enter the ID of the income source to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter the new income source: ");
                    scanner.nextLine(); // Consume the newline character
                    T newIncome = (T) scanner.nextLine();
                    System.out.print("Enter the new amount: ");
                    double newAmount = scanner.nextDouble();
                    System.out.print("Enter the new date (dd/mm/yyyy): ");
                    String newDateInput = scanner.next();
                    LocalDate newDate = parseDate(newDateInput);
                    if (newDate != null) {
                        updateIncome(updateId, newIncome, newAmount, newDate);
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the ID of the income source to find: ");
                    int findId = scanner.nextInt();
                    findIncomeById(findId);
                    break;
                case 6:
                    System.out.print("Enter the ID of the income source to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the column to search (id, source, amount, date): ");
                    String searchColumn = scanner.nextLine();
                    findParticularColumnById(searchId, searchColumn);
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

    private LocalDate parseDate(String dateInput) {
        try {
            return LocalDate.parse(dateInput, dateFormatter);
        } catch (Exception e) {
            return null;
        }

    }
}
