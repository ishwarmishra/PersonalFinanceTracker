
package pft;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public  class ExpenseDetails<T> implements IncomeExpensedetails<T>{

    private class Income {
        T source;
        LocalDate date;

        public Income(T source, LocalDate date) {
            this.source = source;
            this.date = date;
        }
    }
    
    private List<Income>incomeSources;
    private  Scanner scanner;
    private DateTimeFormatter dateFormatter;


    
    public ExpenseDetails() {
        incomeSources = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    @Override
    public String generateUniqueId() {
        System.out.println("Enter a unique ID: ");
        String uniqueId = scanner.nextLine();
        // You can perform validation or manipulation on the user input if required
        return uniqueId;
    }
    //place holder method for thegeneratedUniqueId
    public void doSomething() {
        String uniqueId = generateUniqueId();
       
    }
    
    @Override
    public void addIncome(T income,LocalDate date) {
        Income newIncome = new Income(income, date);
        incomeSources.add(newIncome);
    }

    @Override
    public void displayIncomeSources() {
        if (incomeSources.isEmpty()) {
            System.out.println("No income sources added.");
        } else {
            System.out.println("Income Sources:");
            for(Income income: incomeSources){
                System.out.println(income.source + " - "+ income.date.format(dateFormatter));
                
            }
        }
    }

    @Override
    public void showMenu() {
          int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expense Sources");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Expense source: ");
                    scanner.nextLine(); // Consume the newline character
                    T income = (T) scanner.nextLine();
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.nextLine();
                    LocalDate date = parseDate(dateInput);
                    if (date != null) {
                        addIncome(income, date);
                        System.out.println("Expense source added.");
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
    
        
    private LocalDate parseDate(String dateInput){
        try {
            return LocalDate.parse(dateInput,dateFormatter);
        } catch (DateTimeParseException e) {
            return null;
        }

    
    }

    
    
}
