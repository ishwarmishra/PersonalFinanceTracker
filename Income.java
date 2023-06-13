
package pft;
import java.util.Date;


public class Income implements IncomeExpensedetails {
    
    
   private int id;
   private Date date;
   private int category_id;
   private float amount;
   private String description;
   
   public Income(int id, Date date, int category_id, float amount, String description){
       this.id=id;
       this.date=date;
       this.category_id=category_id;
       this.amount=amount;
       this.description=description;
   }
    
    

    @Override
    public void add(int id, Date date, int category_id, float amount, String description) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
        
        
    }

    @Override
    public void edit(int id) {
        throw new UnsupportedOperationException("Not supported yet.");  
        
    }

    @Override
    public void viewDetails(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }

    @Override
    public void back() {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }

        
    
   
    
    
    
}
