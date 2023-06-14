
package pft;



public class ExpenseTrackerCLI {
    
    public static void main(String args[]){
        
        //create the IncomeDetails objects
        IncomeDetails incomeManager=new IncomeDetails();
        incomeManager.generateUniqueId();
        incomeManager.showMenu();
        incomeManager.add();
        
        
        
    }
    
}
