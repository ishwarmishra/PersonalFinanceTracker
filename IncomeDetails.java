package pft;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public  class IncomeDetails<T> implements IncomeExpensedetails<T> {
    
    private class Income {
        T source;
        Date date;

        public Income(T source, Date date) {
            this.source = source;
            this.date = date;
        }
    }
    
    private List<Income>incomeSources;
    private  Scanner scanner;
    private SimpleDateFormat dateFormat;


    
    public IncomeDetails() {
        incomeSources = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
    public void addIncome(T income,Date date) {
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
                System.out.println(income.source + "-"+ income.date);
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
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.nextLine();
                    Date date = parseDate(dateInput);
                    if (date != null) {
                        addIncome(income, date);
                        System.out.println("Income source added.");
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
    
        
    private Date parseDate(String dateInput){
        try {
            return dateFormat.parse(dateInput);
        } catch (ParseException e) {
            return null;
        }

    
    }
}
    
       

        
            
      

