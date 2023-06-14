package pft;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public interface IncomeExpensedetails<T> {

   
    public String generateUniqueId();

    void addIncome(T income, LocalDate date);

    void displayIncomeSources();

    void showMenu();

}
