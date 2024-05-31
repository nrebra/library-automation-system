
package com.ebra.util;
import com.ebra.dto.UserDto;
import com.ebra.dto.İnfoRentalDto;
import java.sql.Connection;
import java.util.ArrayList;
public interface IUserDBConnection <T>{
    
    default Connection getCustomerIConnection(){

        DatabaseConnectionDb connectionDb = new DatabaseConnectionDb();
        return connectionDb.getConnection();

    }
    public void register(T t);
    
    public boolean loginCtrl(T t);
    
    public boolean userControl(T t);
    
    public void deleteUser(T t);
    
    public void editRole(T t);
    
    public ArrayList<İnfoRentalDto> myBooks(T t);
    
    public ArrayList<UserDto> getUsers();
    
    public void updateUser(T t);
    
   
    
}
