
package com.ebra.dao;

import com.ebra.dto.RoleDto;
import com.ebra.util.IRoleDBConnection;
import java.sql.*;
import java.util.ArrayList;


public class RoleDao implements IRoleDBConnection<RoleDto>{

    @Override
    public void addRole(RoleDto t) {
       
    }

    @Override
    public ArrayList<RoleDto> getRoles() {
         ArrayList<RoleDto> roles = new ArrayList<RoleDto> ();
       try(Connection connection = getRoleIConnection()){
            
            String sql = "select * from roles  ";
            PreparedStatement pstt=connection.prepareStatement(sql);
          
            ResultSet resultSet = pstt.executeQuery();
            
            while(resultSet.next()){
               int id = resultSet.getInt("RoleId");
             
               String role = resultSet.getString("RoleName");
           
              roles.add(new RoleDto(id,role));
            }
            return roles;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
   
        } 
    }

    @Override
    public int getId(RoleDto t) {
      
       try(Connection connection = getRoleIConnection()){
            
            String sql = "select * from roles where RoleName = ?  ";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setString(1, t.getRoleName());
            ResultSet resultSet = pstt.executeQuery();
            
            if(resultSet.next()){
               int id = resultSet.getInt("RoleId");
              return id;
            }
            return 0;
        }catch (SQLException e) {
            e.printStackTrace();
            return 0;
   
        } 
    }
    
}
