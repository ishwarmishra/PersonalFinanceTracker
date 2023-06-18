package pft.model.IncomeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pft.model.IncomeExpenseRepository.IncomeExpenseCommon;
import pft.model.IncomeExpenseRepository.IncomeExpenseDetails;

public  class IncomeService<T>  implements IncomeExpenseDetails<T> {

    private List<Income<T>> incomeSources;
    Scanner scanner;
    private DateTimeFormatter dateFormatter;
    private int nextIncomeId;

    public IncomeService() {
        incomeSources = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nextIncomeId = 1;
    }

    @Override
    public void addIncomeExpense(T income, BigDecimal amount, LocalDate date) {
        Income<T> newIncome = new Income<>(income, amount, date, nextIncomeId);
        incomeSources.add(newIncome);
        nextIncomeId++;
    }

    @Override
    public void displayIncomeExpenseSources() {
        if (incomeSources.isEmpty()) {
            System.out.println("No income sources added.");
        } else {
            System.out.println("Income Sources:");
            for (Income<T> income : incomeSources) {
                System.out.println(income.id + " " + income.source + "  " + income.amount + " " + income.date.format(dateFormatter));

            }
        }
    }

    @Override
    public void deleteIncomeExpense(int id) {
        Income<T> incomeToRemove = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToRemove = income;
                break;
            }
        }
        if (incomeToRemove != null) {
            incomeSources.remove(incomeToRemove);
            System.out.println("Income source with ID " + id + " deleted.");
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void updateIncomeExpense(int id, T newIncome, BigDecimal newAmount, LocalDate newDate) {
        Income<T> incomeToUpdate = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToUpdate = income;
                break;
            }
        }
        if (incomeToUpdate != null) {
            incomeToUpdate.source = newIncome;
            incomeToUpdate.amount = newAmount;
            incomeToUpdate.date = newDate;
            System.out.println("Income source with ID " + id + " updated.");
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void findIncomeExpenseById(int id) {
        Income<T> incomeToFind = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToFind = income;
                break;
            }
        }
        if (incomeToFind != null) {
            System.out.println("Income Source Details:");
            System.out.println("ID: " + incomeToFind.id);
            System.out.println("Source: " + incomeToFind.source);
            System.out.println("Amount: " + incomeToFind.amount);
            System.out.println("Date: " + incomeToFind.date.format(dateFormatter));
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void findParticularColumnById(int id, String column) {
        Income<T> incomeToFind = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToFind = income;
                break;
            }
        }
        if (incomeToFind != null) {
            System.out.println("Income Source Details:");
            switch (column.toLowerCase()) {
                case "id":
                    System.out.println("ID: " + incomeToFind.id);
                    break;
                case "source":
                    System.out.println("Source: " + incomeToFind.source);
                    break;
                case "amount":
                    System.out.println("Amount: " + incomeToFind.amount);
                    break;
                case "date":
                    System.out.println("Date: " + incomeToFind.date.format(dateFormatter));
                    break;
                default:
                    System.out.println("Invalid column. Available columns: id, source, amount, date");
                    return;
            }
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }
    public void showMenu(String i) {
        int choice;
        IncomeExpenseCommon prs=new IncomeExpenseCommon();

        if(i =="i"){do{
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
                    scanner.nextLine();
                    T income = (T) scanner.nextLine();

                    System.out.print("Enter the amount: ");
                    double amountDouble = scanner.nextDouble();
                    BigDecimal amount = BigDecimal.valueOf(amountDouble);

                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.next();
                    LocalDate date = prs.parseDate(dateInput,dateFormatter);
                    if (date != null) {
                        addIncomeExpense(income, amount, date);
                int nextId = 0;
                        System.out.println("Income source added with ID: " + (nextId - 1));
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 2:
                    displayIncomeExpenseSources();
                    break;
                case 3:
                    System.out.print("Enter the ID of the income source to delete: ");
                    int id = scanner.nextInt();
                    deleteIncomeExpense(id);
                    break;
                case 4:
                    System.out.print("Enter the ID of the income source to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter the new income source: ");
                    scanner.nextLine();
                    T newIncome = (T) scanner.nextLine();

                    System.out.print("Enter the new amount: ");
                    BigDecimal newAmount = scanner.nextBigDecimal();
                    
                    System.out.println("New amount: " + newAmount);

                    System.out.print("Enter the new date (dd/mm/yyyy): ");
                    String newDateInput = scanner.next();
                    
                    LocalDate newDate = prs.parseDate(newDateInput,dateFormatter);
                    if (newDate != null) {
                        updateIncomeExpense(updateId, newIncome, newAmount, newDate);
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter the ID of the income source to find: ");
                    int findId = scanner.nextInt();
                    findIncomeExpenseById(findId);
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
         }while (choice != 7);
        
       }
    
    
    
}

    

}
