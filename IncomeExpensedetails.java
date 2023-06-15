package pft;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface IncomeExpensedetails<T> {

   
 

    void addIncome(T income,double amount, LocalDate date);
    void displayIncomeSources();
    void deleteIncome(int id);
    void updateIncome(int id, T newIncome, double newAmount, LocalDate newDate);
    void findIncomeById(int id);
    void findParticularColumnById(int id,String column);
    void showMenu();

}
