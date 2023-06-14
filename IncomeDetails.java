package pft;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class IncomeDetails implements IncomeExpensedetails {
    
    private  Scanner scanner;
    
    public IncomeDetails() {
        scanner = new Scanner(System.in);
    
        
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
