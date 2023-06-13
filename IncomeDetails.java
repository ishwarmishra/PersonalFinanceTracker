package pft;

import java.util.Scanner;


public class IncomeDetails implements IncomeExpensedetails {
    
    private final Scanner scanner;

    public IncomeDetails() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void add() {
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source: ");
        String source = scanner.next();

        System.out.print("Enter the date (YYYY-MM-DD): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);

        // Create an instance of IncomeDetails and populate it with the entered data
        IncomeDetails income = new IncomeDetails();
        income.setAmount(amount);
        income.setSource(source);
        income.setDate(date);

        // Perform further operations with the income details
        // ...
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void view() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void back() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        
    }

    
    

   
}
