
package com.ebra.dto;

import java.util.Date;


public class RentalDto {
    
    private int rentalId;
    private int fk_userId;
    private int fk_bookId;
    private Date startingDate;
    private Date endingDate;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getFk_userId() {
        return fk_userId;
    }

    public void setFk_userId(int fk_userId) {
        this.fk_userId = fk_userId;
    }

    public int getFk_bookId() {
        return fk_bookId;
    }

    public void setFk_bookId(int fk_bookId) {
        this.fk_bookId = fk_bookId;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    
    
}
