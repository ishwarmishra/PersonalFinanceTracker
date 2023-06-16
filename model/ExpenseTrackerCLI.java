
package pft.model;

import java.math.BigDecimal;
import java.time.LocalDate;



public class ExpenseTrackerCLI {
    
    public static void main(String args[]){
        
                
        IncomeExpenseService<String> incomeDetails = new IncomeExpenseService<>();
        incomeDetails.showMenu("e");
        
        
        
    }
    
}
