
package com.ebra.util;


import java.sql.Connection;
import java.util.ArrayList;


public interface IRoleDBConnection<T>{
    
    default Connection getRoleIConnection(){

        DatabaseConnectionDb connectionDb = new DatabaseConnectionDb();
        return connectionDb.getConnection();
    }
    
    public void addRole(T t);
    
    public ArrayList<T> getRoles();
    
    public int getId(T t);
    
  
    
    
    
}
