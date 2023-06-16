package pft.model;

import java.math.BigDecimal;
import java.time.LocalDate;




public class IncomeTrackerCLI {
    public static void main(String[] args){
        IncomeExpenseService<String> incomeManager =new IncomeExpenseService<>();
        incomeManager.showMenu("i");
    }
}