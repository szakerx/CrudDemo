package com.example.shop.model;

import com.example.shop.model.Enums.Roles;
import com.example.shop.model.ViewModels.UserVM;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    //Klasy utworzone w package'u model służą do odwzorowania encji z bazy danych

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="login")
    private String login;

    @Column(name="pass")
    private String pass;


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @Type(type = "pgsql_enum")
    private Roles role;

    @Column(name="active")
    private boolean active;


    public User(){}

    public void changeField(UserVM uvm) {
        this.active = uvm.isActive();
    }

    //Gettery potrzebne do utworzenia json'a

    public Long getId() {
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
    public Roles getRole() {
        return role;
    }
    public String getStringRole() {
        if(role==Roles.admin) {
            return "admin";
        } else {
            return "worker";
        }
    }
    public boolean isActive() { return active; }

    public void update(UserVM user) {
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.login = user.getLogin();
        this.role = user.getRole();
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean canBeAdded() {
        if(firstname.equals("") || lastname.equals("") || login.equals("") || pass.equals("") && (role.equals(Roles.worker) || role.equals(Roles.admin))) {
            return false;
        } else {
            return true;
        }
    }
}
