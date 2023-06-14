package pft;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public interface IncomeExpensedetails<T> {

   
    public String generateUniqueId();

    void addIncome(T income, Date date);

    void displayIncomeSources();

    void showMenu();

}
