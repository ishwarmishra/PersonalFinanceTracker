
package pft;
import java.util.Date;
import java.util.UUID;

public interface IncomeExpensedetails {
    
    String generatedUniqueId();
    
    void add(int id,Date date,int category_id,float amount,String description);
    void edit(int id);
    
    void viewDetails(int id);
    void back();
    
}
