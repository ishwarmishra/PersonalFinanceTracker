package pft.model.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pft.model.IncomeExpenseRepository.IncomeExpenseCommon;
import pft.model.IncomeExpenseRepository.IncomeExpenseDetails;

public  class ExpenseService<T>  implements IncomeExpenseDetails<T> {

    private List<Expense<T>> expenseSources;
    Scanner scanner;
    private DateTimeFormatter dateFormatter;
    private int nextExpenseId;

    public ExpenseService() {
        expenseSources = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nextExpenseId = 1;
    }

    @Override
    public void addIncomeExpense(T expense, BigDecimal amount, LocalDate date) {
        Expense<T> newExpense = new Expense<>(expense, amount, date, nextExpenseId);
        expenseSources.add(newExpense);
        nextExpenseId++;
    }

    @Override
    public void displayIncomeExpenseSources() {
        if (expenseSources.isEmpty()) {
            System.out.println("No expense sources added.");
        } else {
            System.out.println("Expense Sources:");
            for (Expense<T> expense : expenseSources) {
                System.out.println(expense.id + " " + expense.source + "  " + expense.amount + " " + expense.date.format(dateFormatter));

            }
        }
    }

    @Override
    public void deleteIncomeExpense(int id) {
        Expense<T> expenseToRemove = null;
        for (Expense<T> expense : expenseSources) {
            if (expense.id == id) {
                expenseToRemove = expense;
                break;
            }
        }
        if (expenseToRemove != null) {
            expenseSources.remove(expenseToRemove);
            System.out.println("Expense source with ID " + id + " deleted.");
        } else {
            System.out.println("Expense source with ID " + id + " not found.");
        }
    }

    @Override
    public void updateIncomeExpense(int id, T newExpense, BigDecimal newAmount, LocalDate newDate) {
        Expense<T> expenseToUpdate = null;
        for (Expense<T> expense : expenseSources) {
            if (expense.id == id) {
                expenseToUpdate = expense;
                break;
            }
        }
        if (expenseToUpdate != null) {
            expenseToUpdate.source = newExpense;
            expenseToUpdate.amount = newAmount;
            expenseToUpdate.date = newDate;
            System.out.println("Expense source with ID " + id + " updated.");
        } else {
            System.out.println("Expense source with ID " + id + " not found.");
        }
    }

    @Override
    public void findIncomeExpenseById(int id) {
        Expense<T> expenseToFind = null;
        for (Expense<T> expense : expenseSources) {
            if (expense.id == id) {
                expenseToFind = expense;
                break;
            }
        }
        if (expenseToFind != null) {
            System.out.println("Expense Source Details:");
            System.out.println("ID: " + expenseToFind.id);
            System.out.println("Source: " + expenseToFind.source);
            System.out.println("Amount: " + expenseToFind.amount);
            System.out.println("Date: " + expenseToFind.date.format(dateFormatter));
        } else {
            System.out.println("Expense source with ID " + id + " not found.");
        }
    }

    @Override
    public void findParticularColumnById(int id, String column) {
        Expense<T> expenseToFind = null;
        for (Expense<T> expense : expenseSources) {
            if (expense.id == id) {
                expenseToFind = expense;
                break;
            }
        }
        if (expenseToFind != null) {
            System.out.println("Expense Source Details:");
            switch (column.toLowerCase()) {
                case "id":
                    System.out.println("ID: " + expenseToFind.id);
                    break;
                case "source":
                    System.out.println("Source: " + expenseToFind.source);
                    break;
                case "amount":
                    System.out.println("Amount: " + expenseToFind.amount);
                    break;
                case "date":
                    System.out.println("Date: " + expenseToFind.date.format(dateFormatter));
                    break;
                default:
                    System.out.println("Invalid column. Available columns: id, source, amount, date");
                    return;
            }
        } else {
            System.out.println("Expense source with ID " + id + " not found.");
        }
    }
    public void showMenu(String i) {
        int choice;
        IncomeExpenseCommon prs=new IncomeExpenseCommon();
        if(i =="i"){do{
            System.out.println("Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expense Sources");
            System.out.println("3. Delete Expense Source");
            System.out.println("4. Update Expense Source");
            System.out.println("5. Find Expense Source by id");
            System.out.println("6. Find particular data of Expense Source by id");

            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense source: ");
                    scanner.nextLine();
                    T expense = (T) scanner.nextLine();

                    System.out.print("Enter the amount: ");
                    double amountDouble = scanner.nextDouble();
                    BigDecimal amount = BigDecimal.valueOf(amountDouble);

                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.next();
                    LocalDate date = prs.parseDate(dateInput,dateFormatter);
                    
                    if (date != null) {
                        addIncomeExpense(expense, amount, date);
                int nextId = 0;
                        System.out.println("Expense source added with ID: " + (nextId - 1));
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 2:
                    displayIncomeExpenseSources();
                    break;
                case 3:
                    System.out.print("Enter the ID of the expense source to delete: ");
                    int id = scanner.nextInt();
                    deleteIncomeExpense(id);
                    break;
                case 4:
                    System.out.print("Enter the ID of the expense source to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter the new expense source: ");
                    scanner.nextLine();
                    T newExpense = (T) scanner.nextLine();

                    System.out.print("Enter the new amount: ");
                    BigDecimal newAmount = scanner.nextBigDecimal();
                    
                    System.out.println("New amount: " + newAmount);

                    System.out.print("Enter the new date (dd/mm/yyyy): ");
                    String newDateInput = scanner.next();
                    LocalDate newDate = prs.parseDate(newDateInput,dateFormatter);
                    if (newDate != null) {
                        updateIncomeExpense(updateId, newExpense, newAmount, newDate);
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the ID of the expense source to find: ");
                    int findId = scanner.nextInt();
                    findIncomeExpenseById(findId);
                    break;
                case 6:
                    System.out.print("Enter the ID of the expense source to search: ");
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
         }while (choice != 7);
        
       }
    
    
    
}

    

    
   }
