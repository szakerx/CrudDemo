package com.example.shop.model;

import javax.persistence.Column;

public class User {
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

    public User(String firstname,String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getFirstname(){
        return this.firstname;
    }
    public String getLastname(){
        return this.lastname;
    }
    @Override
    public String toString(){
        return firstname + " " + lastname;
    }
}
