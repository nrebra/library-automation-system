
package com.ebra.dto;

import java.io.Serializable;



public class UserDto implements Serializable{
    private int Id;
    private String Name;
    private String Surname;
    private String User;
    private String Password;
    private int RoleId;
    private String RoleName;

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public UserDto(){
        
    }
    public UserDto(int Id, String Name, String Surname, String User, String RoleName) {
        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.User = User;
        this.RoleName = RoleName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }
    
   
        
        
}
