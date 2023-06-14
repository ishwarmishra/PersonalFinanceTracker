package pft;

/**
 *
 * @author ishwar
 */
public class IncomeTrackerCLI {
    public static void main(String[] args){
        //create the IncomeDetails objects
        IncomeDetails incomeManager=new IncomeDetails();
        incomeManager.generateUniqueId();
        incomeManager.showMenu();

        
    }
    
}
