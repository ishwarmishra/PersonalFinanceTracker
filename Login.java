package pft;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login Page!");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        boolean loginSuccessful = validateCredentials(username, password);
        
        if (loginSuccessful) {
            // Redirect to Dashboard class
            Dashboard.showDashboard();        
        } else {
            System.out.println("Invalid username or password. Please try again.");
            
        }
      
        
    }

    private static boolean authenticateUser(String username, String password) {
        
        
        String expectedUsername = "ishwar";
        String expectedPassword = "ishwar123";

        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }

    private static boolean validateCredentials(String username, String password) {
            return username.equals("admin") && password.equals("password");
    }
}
