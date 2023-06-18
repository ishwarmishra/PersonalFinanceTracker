package pft.model.IncomeExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface IncomeExpenseDetails<T> {
     //Existing Methods for the income management
    void addIncomeExpense(T income, BigDecimal amount, LocalDate date);
    void displayIncomeExpenseSources();
    void deleteIncomeExpense(int id);
    void updateIncomeExpense(int id, T newIncome, BigDecimal newAmount, LocalDate newDate);
    void findIncomeExpenseById(int id);
    void findParticularColumnById(int id,String column);
   
         
        
}
