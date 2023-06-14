
package pft;

import java.util.Scanner;


public class Dashboard {
    
    public static void printMenu(String[] options){
        System.out.println("Dashboard");
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void main(String[] args) {
        String[] options = {"1- Income",
                            "2- Expense",
                            "3- exit",
                            
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=3){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: income(); break;
                    
                    case 2: expense(); break;
                    
                    case 3: exit(); 
                    
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    private static void income() {
        System.out.println("Welcome in Income Details");
    }
    private static void expense() {
        System.out.println("Welcome in Expense Details");
    }
    private static void exit() {
        System.out.println("You are exiting");
    }

    
}
