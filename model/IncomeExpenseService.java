package pft.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncomeExpenseService<T> implements IncomeExpenseDetails<T> {
    
    
    private List<Income<T>> incomeSources;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;
    private int nextId;

    public IncomeExpenseService() {
        incomeSources = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nextId = 1;
    }
    

   @Override
    public void addIncome(T income, BigDecimal amount, LocalDate date) {
        Income<T> newIncome = new Income<>(income, amount, date, nextId);
        incomeSources.add(newIncome);
        nextId++;
    }

    @Override
    public void displayIncomeSources() {
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
    public void deleteIncome(int id) {
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
    public void updateIncome(int id, T newIncome, BigDecimal newAmount, LocalDate newDate) {
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
    public void findIncomeById(int id) {
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

    @Override
    public void showMenu(String i) {
        int choice;
        if(i=="i"){do{
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
                    scanner.nextLine();
                    T newIncome = (T) scanner.nextLine();

                    System.out.print("Enter the new amount: ");
                    BigDecimal newAmount = scanner.nextBigDecimal();
                    
                    System.out.println("New amount: " + newAmount);

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
         }while (choice != 7);
        
       }
        else{
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
                    System.out.print("Enter Expense source: ");
                    scanner.nextLine();
                    T income = (T) scanner.nextLine();

                    System.out.print("Enter the amount: ");
                    double amountDouble = scanner.nextDouble();
                    BigDecimal amount = BigDecimal.valueOf(amountDouble);

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
                    System.out.print("Enter the ID of the expense source to delete: ");
                    int id = scanner.nextInt();
                    deleteIncome(id);
                    break;
                case 4:
                    System.out.print("Enter the ID of the expense source to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter the new expense source: ");
                    scanner.nextLine();
                    T newIncome = (T) scanner.nextLine();

                    System.out.print("Enter the new amount: ");
                    BigDecimal newAmount = scanner.nextBigDecimal();
                    
                    System.out.println("New amount: " + newAmount);

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

    

    
