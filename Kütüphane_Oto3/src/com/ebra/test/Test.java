
package com.ebra.test;

import com.ebra.dao.BookDao;
import com.ebra.dao.UserDao;
import com.ebra.dto.BookDto;
import com.ebra.dto.UserDto;
import java.util.Scanner;


public class Test {
    
   /* public static void main (String[] args){
        
        /*UserDto ebra = new UserDto();
        ebra.setName("Ebra");
        ebra.setSurname("Sayar");
        ebra.setUser("Zivk");
        ebra.setPassword("2536");
        
        UserDao dao = new UserDao();
        dao.register(ebra);*/
        
       /* BookDto bookDto = new BookDto();
        bookDto.setBookName("Lavinia");
        bookDto.setWriter("Özdemir Asaf");
        bookDto.setType("Şiir");
       
        BookDao b_dao = new BookDao();
        b_dao.register(bookDto);*/
       /*
       UserDto dto = new UserDto();
       Scanner scanner = new Scanner(System.in);
       String text = scanner.nextLine();
       
       dto.setUser(text);
       text =  scanner.nextLine();
       
       dto.setPassword(text);
       
       UserDao dao = new UserDao();
       
       if(dao.userNameCtrl(dto) == true && dao.passwordCtrl(dto ) == true){
           
           System.out.println("Giriş Başarılı..");
           dao.roleCtrl(dto);
           System.out.println(dto.getRoleId());
       }
       else{
           System.out.println("Giriş Başarısız..");
       }
    }
    */
}
