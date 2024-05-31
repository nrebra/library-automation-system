
package com.ebra.util;
import java.sql.Connection;
public interface IRecipientDBConnection <T>{
    
    default Connection getCustomerIConnection(){

        DatabaseConnectionDb connectionDb = new DatabaseConnectionDb();
        return connectionDb.getConnection();

    }
    public void createRec(T t);
    
    public void LoginUserControl(T t);
     
    public void passwordControl(T t);
        
        
    
}
