
package pft;



public class ExpenseTrackerCLI {
    
    public static void main(String args[]){
        
        //create the IncomeDetails objects
        IncomeDetails incomeManager=new IncomeDetails();
        incomeManager.generateUniqueId();
        incomeManager.showMenu();
        
        //create the object for the ExpenseDetails 
        
        ExpenseDetails expenseManager=new ExpenseDetails();
        expenseManager.generateUniqueId();
        expenseManager.showMenu();
        
        
        
        
        
    }
    
}
