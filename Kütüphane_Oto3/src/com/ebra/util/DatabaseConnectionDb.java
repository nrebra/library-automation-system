
package com.ebra.util;
import java.sql.*;


public class DatabaseConnectionDb {
    private String url="jdbc:mysql://localhost:3306/bas?useUnicode=yes&characterEncoding=UTF-8";
    private String user="root";
    private String password="Ebranursyr123."; 
    
    private Connection connection;

    public Connection getConnection(){

        try{
            if(this.connection == null || this.connection.isClosed()){
                Class.forName("com.mysql.jdbc.Driver");
       
                connection= DriverManager.getConnection(url, user, password);
        
            }else{
                return connection;
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
           
        }

        return connection;
    }
}
