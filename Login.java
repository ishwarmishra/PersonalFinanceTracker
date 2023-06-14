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

        if (authenticateUser(username, password)) {
            System.out.println("Login successful! Welcome, " + username + ".");
            
            //actions to be performed after successful login
        } else {
            System.out.println("Invalid username or password. Please try again.");
            // handling unsuccessful login attempts
        }
      
        
    }

    private static boolean authenticateUser(String username, String password) {
        // implement your authentication logic.
        
        String expectedUsername = "ishwar";
        String expectedPassword = "ishwar123";

        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }
}
