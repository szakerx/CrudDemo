package com.example.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="nip")
    private String nip;
    public Supplier(){}
    public Supplier(String name, String nip, int id){
        this.id = id;
        this.name = name;
        this.nip = nip;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getNip() {
        return nip;
    }
}
