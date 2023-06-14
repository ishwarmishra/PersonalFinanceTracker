package pft;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class IncomeDetails implements IncomeExpensedetails {
    
    private List<String>incomeSources;
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
    public void addIncome(String income) {
        incomeSources.add(income);
    }

    @Override
    public void displayIncomeSources() {
        if (incomeSources.isEmpty()) {
            System.out.println("No income sources added.");
        } else {
            System.out.println("Income Sources:");
            for (String income : incomeSources) {
                System.out.println(income);
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
                    addIncome(income);
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
    
        
    @Override
    public void add() {
        
        
         
//        System.out.print("Enter the amount: ");
//        double amount = scanner.nextDouble();
        
//        List<String> stringList = new ArrayList<>();
//        stringList.add("salary");
//        stringList.add("Investment");
//        stringList.add("Rent");
//        System.out.print(stringList);
        
//        System.out.println("Enter the source of income: ");
//        String source = scanner.next();

        
        

        System.out.print("Enter the date (YYYY-MM-DD): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);
        
       

       }

    

    
       
}
        
            
      

