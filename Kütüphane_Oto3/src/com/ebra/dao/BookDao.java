
package com.ebra.dao;

import com.ebra.dto.BookDto;
import com.ebra.util.IBookDBConnection;
import java.sql.*;
import java.util.ArrayList;

public class BookDao implements IBookDBConnection<BookDto>{
    
   
   public void addBook(BookDto bookDto) {
    
       try(Connection connection = getBookIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "insert into books(BookName,BookWriter,BookType) values (?,?,?)";
            PreparedStatement pstt_b=connection.prepareStatement(sql);
            pstt_b.setString(1, bookDto.getBookName());
            pstt_b.setString(2, bookDto.getWriter());
            pstt_b.setString(3, bookDto.getType());
            
           
            
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
    public ArrayList<BookDto> getBooks() {
       ArrayList<BookDto> books = new ArrayList<BookDto> ();
       try(Connection connection = getBookIConnection()){
            
            String sql = "select * from books  ";
            PreparedStatement pstt=connection.prepareStatement(sql);
          
            ResultSet resultSet = pstt.executeQuery();
            
            while(resultSet.next()){
               int id = resultSet.getInt("BooksId");
               String bookName= resultSet.getString("BookName");
               String writer = resultSet.getString("BookWriter");
               String type = resultSet.getString("BookType");
               boolean status = resultSet.getBoolean("BookStatus");
           
              books.add(new BookDto(id,bookName,writer,type,status));
            }
            return books;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
   
        } 
        
    }

    @Override
    public boolean bookCtrl(BookDto bookDto) {
        try(Connection connection = getBookIConnection()){
            
            String sql = "select * from books where BookName = ? ";
            PreparedStatement pstt=connection.prepareStatement(sql);
            pstt.setString(1,bookDto.getBookName() );
            
            ResultSet resultSet = pstt.executeQuery();
            
            if(resultSet.next()){
               bookDto.setId(resultSet.getInt("BooksId"));
                  
                    return true;
              
            }
           
            
        }catch (SQLException e) {
            e.printStackTrace();

        } 
       return false;
    
    }

    @Override
    public void updateStatus(BookDto bookDto) {
        int txt =0;
        if(bookDto.isStatus()) txt=1;
        
        
        try(Connection connection = getBookIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "update books set BookStatus = ? where BooksId = ?";
            PreparedStatement pstt_b=connection.prepareStatement(sql);
            pstt_b.setInt(1,txt);
            pstt_b.setInt(2, bookDto.getId());
           
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
    public void deleteBook(BookDto t) {
        try(Connection connection = getBookIConnection()){
            connection.setAutoCommit(false);
            
            String sql = "delete from books where BooksId = ? ";
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

  
    

}
