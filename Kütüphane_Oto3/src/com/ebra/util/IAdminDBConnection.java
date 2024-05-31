
package com.ebra.util;
import java.sql.Connection;
public interface IAdminDBConnection <T>{
    
    default Connection getCustomerIConnection(){

        DatabaseConnectionDb connectionDb = new DatabaseConnectionDb();
        return connectionDb.getConnection();

    }
    
    public void LoginUserControl(T t);
     
    public void passwordControl(T t);
        
        
    
}
