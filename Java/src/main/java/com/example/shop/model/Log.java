package com.example.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "logs")
@IdClass(Log.class)
public class Log {

    //Klasy utworzone w package'u model służą do odwzorowania encji z bazy danych

    @Id
    @Column(name="logtime")
    private Date date;
    @Id
    @Column(name = "operation")
    private String operation;
    @Id
    @Column(name = "userid")
    private int userid;
    public Log(){}
    public Log(Date date, String operation, int userid){
        this.date = date;
        this.operation = operation;
        this.userid = userid;
    }

    //Gettery potrzebne do utworzenia json'a
    public Date getDate() {
        return date;
    }

    public int getUserid() {
        return userid;
    }

    public String getOperation() {
        return operation;
    }
}
