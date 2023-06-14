package pft;
import java.util.Scanner;
import java.time.LocalDate;



public class IncomeDetails implements IncomeExpensedetails {
    
    private  Scanner scanner;
 
   
    
    public IncomeDetails() {
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
    public void add() {
        
        
         
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        
//        List<String> stringList = new ArrayList<>();
//        stringList.add("salary");
//        stringList.add("Investment");
//        stringList.add("Rent");
//        System.out.print(stringList);
        
        System.out.println("Enter the source of income: ");
        
        String source = scanner.next();

        System.out.print("Enter the date (YYYY-MM-DD): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);
        
       

       }

    
       
    }
        
            
      
}
