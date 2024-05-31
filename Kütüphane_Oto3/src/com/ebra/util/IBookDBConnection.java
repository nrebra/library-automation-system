
package com.ebra.util;

import com.ebra.dto.BookDto;
import java.sql.Connection;
import java.util.ArrayList;


public interface IBookDBConnection<T>{
    
    default Connection getBookIConnection(){

        DatabaseConnectionDb connectionDb = new DatabaseConnectionDb();
        return connectionDb.getConnection();
    }
    
    public void addBook(T t);
    
    public ArrayList<T> getBooks();
    
    boolean bookCtrl(T t);
    
    public void updateStatus(T t);
    
    public void deleteBook(T t);
 
    
  
    
    
    
}
