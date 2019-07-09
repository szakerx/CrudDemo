package com.example.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="login")
    private String login;

    @Column(name="pass")
    private String pass;

    @Column(name="role")
    private String role;
    public User(){}
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }

    public int getId() {
        return id;
    }
    public String getFirstname(){
        return this.firstname;
    }
    public String getLastname(){
        return this.lastname;
    }
    public String getLogin() { return this.login;}
    public String getPass() {
        return pass;
    }
    public String getRole() {
        return role;
    }
}
