
package pft;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public  class ExpenseDetails<T> implements IncomeExpensedetails<T>{

    private List<Income> incomeSources;
    private Map<Integer, Income>incomeMap;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;
    private int nextId;

    public ExpenseDetails() {
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
            System.out.println("No expense sources added.");
        } else {
            System.out.println("Income Sources:");
            for (Income expense : incomeSources) {
                System.out.println(expense.id + " " +expense.source + "  " + expense.amount+ " "+ expense.date.format(dateFormatter));
                

            }
        }
    }
    @Override
     public void deleteIncome(int id) {
        Income income = incomeMap.get(id);
        if (income != null) {
            incomeSources.remove(income);
            incomeMap.remove(id);
            System.out.println("Expense source with ID " + id + " deleted.");
        } else {
            System.out.println("Expense source with ID " + id + " not found.");
        }
    }
     @Override
     public void updateIncome(int id, T newIncome, double newAmount, LocalDate newDate) {
        Income income = incomeMap.get(id);
        if (income != null) {
            income.source = newIncome;
            income.amount = newAmount;
            income.date = newDate;
            System.out.println("Expense source with ID " + id + " updated.");
        } else {
            System.out.println("Expense source with ID " + id + " not found.");
        }
    }
     @Override
     public void findIncomeById(int id) {
        Income expense = incomeMap.get(id);
        if (expense != null) {
            System.out.println("Expense Source Details:");
            System.out.println("ID: " + expense.id);
            System.out.println("Source: " + expense.source);
            System.out.println("Amount: " + expense.amount);
            System.out.println("Date: " + expense.date.format(dateFormatter));
        } else {
            System.out.println("Expense source with ID " + id + " not found.");
        }
    }
     

    @Override
    public void showMenu() {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expense Sources");
            System.out.println("3. Delete Expense Source");
            System.out.println("4. Update Expense Source");
            System.out.println("5. Find Expense Source by id");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Expense source: ");
                    scanner.nextLine(); // Consume the newline character
                    T income = (T) scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.next();
                    LocalDate date = parseDate(dateInput);
                    if (date != null) {
                        addIncome(income,amount,date);
                        System.out.println("Expenses source added with ID: "+ (nextId-1));
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 2:
                    displayIncomeSources();
                    break;
                case 3:
                   System.out.print("Enter the ID of the expense source to delete: ");
                    int id = scanner.nextInt();
                    deleteIncome(id);
                    break;
                case 4:
                    System.out.print("Enter the ID of the expense source to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter the new expense source: ");
                    scanner.nextLine(); // Consume the newline character
                    T newIncome = (T)scanner.nextLine();
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
                    System.out.print("Enter the ID of the expense source to find: ");
                    int findId = scanner.nextInt();
                    findIncomeById(findId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 6);
    }

    private LocalDate parseDate(String dateInput) {
        try {
            return LocalDate.parse(dateInput, dateFormatter);
        } catch(Exception e) {
            return null;
        }

    }
    
}
