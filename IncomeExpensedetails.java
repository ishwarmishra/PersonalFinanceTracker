package pft;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public interface IncomeExpensedetails {

    //for the incomeDetails class
    public String generateUniqueId();

    void addIncome(String income, Date date);

    void displayIncomeSources();

    void showMenu();

}
