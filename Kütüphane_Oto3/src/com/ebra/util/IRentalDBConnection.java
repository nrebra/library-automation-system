
package com.ebra.util;

import java.sql.Connection;


public interface IRentalDBConnection<T>{
    
    default Connection getBookIConnection(){

        DatabaseConnectionDb connectionDb = new DatabaseConnectionDb();
        return connectionDb.getConnection();
    }
    
    public void addRental(T t );
    
   public void updateDate(T t);
    
  
    
    
    
}
