
package com.ebra.dao;

import com.ebra.dto.UserDto;
import com.ebra.dto.İnfoRentalDto;
import com.ebra.util.IUserDBConnection;
import java.sql.*;
import java.util.ArrayList;

public class UserDao implements IUserDBConnection<UserDto>{

    @Override
    public void register(UserDto userDto) {
    
       try(Connection connection = getCustomerIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "insert into users(UserName,Password,Name,Surname) values (?,?,?,?)";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setString(1, userDto.getUser());
            pstt.setString(2, userDto.getPassword());
            pstt.setString(3, userDto.getName());
            pstt.setString(4, userDto.getSurname());
            int rowEffect = pstt.executeUpdate();

            if(rowEffect>0) {
               
                connection.commit();
               
            }else {
               
                connection.rollback();
                connection.setAutoCommit(true);
               
            }
        }catch (SQLException e) {
            e.printStackTrace();

        } 

    }

    @Override
    public boolean loginCtrl(UserDto userDto) {
       
       try(Connection connection = getCustomerIConnection()){
            
            String sql = "select * from users where UserName = ? and Password = ?";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setString(1, userDto.getUser());
             pstt.setString(2, userDto.getPassword());
            ResultSet resultSet = pstt.executeQuery();
            
            if(resultSet.next()){
                   userDto.setId(resultSet.getInt("UserId"));
                    userDto.setName(resultSet.getString("Name"));
                    userDto.setSurname(resultSet.getString("Surname"));
                    userDto.setRoleId(resultSet.getInt("FK_Role"));
                    return true;
              
            }
           
            
        }catch (SQLException e) {
            e.printStackTrace();

        } 
       return false;
    }

    @Override
    public void deleteUser(UserDto t) {
     
         try(Connection connection = getCustomerIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "delete from users where UserId = ? ";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setInt(1, t.getId());
           
            int rowEffect = pstt.executeUpdate();

            if(rowEffect>0) {
               
                connection.commit();
               
            }else {
               
                connection.rollback();
                connection.setAutoCommit(true);
                
               
            }
        }catch (SQLException e) {
            e.printStackTrace();

        } 

    }

    @Override
    public void editRole(UserDto t) {
         try(Connection connection = getCustomerIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "update users set FK_Role = ? where UserName = ?";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setInt(1, t.getRoleId());
            pstt.setString(2,t.getUser());
           
            int rowEffect = pstt.executeUpdate();

            if(rowEffect>0) {
               
                connection.commit();
               
            }else {
               
                connection.rollback();
                connection.setAutoCommit(true);
                
               
            }
        }catch (SQLException e) {
            e.printStackTrace();

        } 

    }

    @Override
    public ArrayList<İnfoRentalDto> myBooks(UserDto userDto) {
        ArrayList<İnfoRentalDto> books = new ArrayList<İnfoRentalDto> ();
       try(Connection connection = getCustomerIConnection()){
            
            String sql = "select * from inforentals where UserName = ? ";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setString(1, userDto.getUser());
          
            ResultSet resultSet = pstt.executeQuery();
            
            while(resultSet.next()){
               int id = resultSet.getInt("RentalId");
               String userName= resultSet.getString("UserName");
               String name = resultSet.getString("Name");
               String surname = resultSet.getString("Surname");
               String bookName= resultSet.getString("BookName");
               String bookWriter = resultSet.getString("BookWriter");
               String bookType = resultSet.getString("BookType");
               Date startingDate = resultSet.getDate("StartingDate");
               Date endDate = resultSet.getDate("EndDate");
               books.add(new İnfoRentalDto(id,userName,name,surname,bookName,bookWriter,bookType,startingDate,endDate));
            }
            return books;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
   
        } 
    
    }

    @Override
    public boolean userControl(UserDto userDto) {
      try(Connection connection = getCustomerIConnection()){
            
            String sql = "select * from users where UserName = ? ";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setString(1, userDto.getUser());
            
            ResultSet resultSet = pstt.executeQuery();
            
            if(resultSet.next()){
               userDto.setId(resultSet.getInt("UserId"));
                  
                    return true;
              
            }
           
            
        }catch (SQLException e) {
            e.printStackTrace();

        } 
       return false;
    
    }

    @Override
    public ArrayList<UserDto> getUsers() {
         ArrayList<UserDto> users = new ArrayList<UserDto> ();
       try(Connection connection = getCustomerIConnection()){
            
            String sql = "select * from usersview  ";
            PreparedStatement pstt=connection.prepareStatement(sql);
          
            ResultSet resultSet = pstt.executeQuery();
            
            while(resultSet.next()){
               int id = resultSet.getInt("UserId");
               String userName= resultSet.getString("UserName");
               String name = resultSet.getString("Name");
               String surname = resultSet.getString("Surname");
               String role = resultSet.getString("RoleName");
           
              users.add(new UserDto(id,name,surname,userName,role));
            }
            return users;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
   
        } 
    
    }

    @Override
    public void updateUser(UserDto userDto) {
       try(Connection connection = getCustomerIConnection()){
             connection.setAutoCommit(false);
           if(userDto.getPassword() == null){
            String sql = "select * from users where UserId = ? ";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setInt(1, userDto.getId());
            ResultSet resultSet = pstt.executeQuery();
            
            if(resultSet.next()){
               String password = resultSet.getString("Password");
               userDto.setPassword(password);
            }
            
           }
            String query = "update users set UserName = ? , Name = ? , Surname = ? , Password = ? where UserId = ?";
            PreparedStatement pstt=connection.prepareStatement(query);
            pstt.setString(1, userDto.getUser());
            pstt.setString(2, userDto.getName());
            pstt.setString(3, userDto.getSurname());
            pstt.setString(4, userDto.getPassword());
            pstt.setInt(5, userDto.getId());
            
            
            int rowEffect = pstt.executeUpdate();
             if(rowEffect>0) {
               
                connection.commit();
               
            }else {
               
                connection.rollback();
                connection.setAutoCommit(true);
                
               
            }
        }catch (SQLException e) {
            e.printStackTrace();
          
   
        } 
    }

 
    
}
