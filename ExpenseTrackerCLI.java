
package pft;



public class ExpenseTrackerCLI {
    
    public static void main(String args[]){
        
                
        //create the object for the ExpenseDetails 
        ExpenseDetails<String> expenseManager=new ExpenseDetails<>();
        expenseManager.generateUniqueId();
        expenseManager.showMenu();
        
        
        
        
        
    }
    
}
