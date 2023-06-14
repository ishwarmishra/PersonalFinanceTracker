package pft;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;



public  class IncomeDetails implements IncomeExpensedetails {
    
    private class Income {
        String source;
        Date date;

        public Income(String source, Date date) {
            this.source = source;
            this.date = date;
        }
    }
    
    private List<Income>incomeSources;
    private  Scanner scanner;
  

    
    public IncomeDetails() {
        incomeSources = new ArrayList<>();
        scanner = new Scanner(System.in); 
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
    public void addIncome(String income,Date date) {
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
                    String income = scanner.nextLine();
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String dateInput = scanner.nextLine();
                    Date date = parseDate(dateInput);
                    addIncome(income, date);
                    System.out.println("Income source added.");
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
    
        
    private Date parseDate(String dateInput) {
        
        String[] parts = dateInput.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Month is zero-based
        int year = Integer.parseInt(parts[2]) - 1900; // Adjust year based on Java Date class
        return new Date(year, month, day);
    }

    

    
       
}
        
            
      

