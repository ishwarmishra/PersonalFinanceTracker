package pft;

import java.math.BigDecimal;
import java.time.LocalDate;


public class IncomeTrackerCLI {
    public static void main(String[] args){
        //create the IncomeExpenseService objects
        IncomeExpenseService<String> incomeDetails = new IncomeExpenseService<>();
        incomeDetails.showMenu("i");
        
        
    }
    
}

