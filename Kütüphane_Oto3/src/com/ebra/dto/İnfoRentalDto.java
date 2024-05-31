
package com.ebra.dto;

import java.util.Date;


public class İnfoRentalDto {
    private int rentalId;
    private String userName;
    private String name;
    private String surname;
    private String bookName;
    private String bookWriter;
    private String bookType;
    private Date startingDate;
    private Date endDate;

    public İnfoRentalDto(int rentalId, String userName, String name, String surname, String bookName, String bookWriter, String bookType, Date startingDate, Date endDate) {
        this.rentalId = rentalId;
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.bookType = bookType;
        this.startingDate = startingDate;
        this.endDate = endDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
            
    
    
}
