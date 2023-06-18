package pft.model.IncomeExpenseRepository;

import pft.controller.Dashboard;
import java.util.Scanner;

public class Login {
    private static final String USERNAME = "ishwar";
    private static final String PASSWORD = "ishwar";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get username and password input
        System.out.print("Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // Perform validation or authentication
        if (validateCredentials(username, password)) {
            System.out.println("Login successful!");
            Dashboard.showDashboard();
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
    private static boolean validateCredentials(String username, String password) {
        // Perform validation/authentication logic here
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}

