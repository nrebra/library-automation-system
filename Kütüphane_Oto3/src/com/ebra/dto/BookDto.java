
package com.ebra.dto;

import java.io.Serializable;

public class BookDto implements Serializable {
    
    private int Id;
    private String BookName;
    private String Writer;
    private String Type;
    private boolean Status;

    public BookDto(int Id, String BookName, String Writer, String Type, boolean Status) {
        this.Id = Id;
        this.BookName = BookName;
        this.Writer = Writer;
        this.Type = Type;
        this.Status = Status;
    }

    public BookDto() {
    }
  

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String Writer) {
        this.Writer = Writer;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    
    
}
