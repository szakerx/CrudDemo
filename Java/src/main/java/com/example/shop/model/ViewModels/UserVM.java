package com.example.shop.model.ViewModels;

import com.example.shop.model.Enums.Roles;
import com.example.shop.model.User;

public class UserVM {

    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private Roles role;
    private boolean active;

    public UserVM(){}
    public UserVM(User user){
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.login = user.getLogin();
        this.role = user.getRole();
        this.active = user.isActive();
    }

    public Long getId() { return id; }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public Roles getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }
}
