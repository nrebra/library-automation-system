
package com.ebra.dao;

import com.ebra.dto.RentalDto;
import com.ebra.util.IRentalDBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalDao implements IRentalDBConnection<RentalDto>{

    @Override
    public void addRental(RentalDto t) {
    
         try(Connection connection = getBookIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "insert into rentals(FK_UserId,FK_BookId,StartingDate,EndDate) values (?,?,?,?)";
            PreparedStatement pstt_b=connection.prepareStatement(sql);
            pstt_b.setInt(1, t.getFk_userId());
            pstt_b.setInt(2,t.getFk_bookId());
            pstt_b.setDate(3, (Date) t.getStartingDate());
            pstt_b.setDate(4, (Date) t.getEndingDate());
            
           
            
            int rowEffect = pstt_b.executeUpdate();

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
    public void updateDate(RentalDto t) {
        java.util.Date date = new java.util.Date();
        java.sql.Date nowdate = new java.sql.Date(date.getTime());
        t.setEndingDate(nowdate);
        try(Connection connection = getBookIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "update rentals set EndDate = ? where RentalId = ?";
            PreparedStatement pstt_b=connection.prepareStatement(sql);
            pstt_b.setInt(2, t.getRentalId());
           
            pstt_b.setDate(1, (Date) t.getEndingDate());
            
            int rowEffect = pstt_b.executeUpdate();

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
