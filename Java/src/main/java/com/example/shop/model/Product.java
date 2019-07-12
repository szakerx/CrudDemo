package com.example.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    //Klasy utworzone w package'u model służą do odwzorowania encji z bazy danych

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "country")
    private String country;

    @Column(name = "count")
    private double count;

    @Column(name = "category")
    private String category;

    //Dostarczenie danych z klulcza obcego
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier")
    private Supplier supplier;


    public Product(){}

    //Gettery potrzebne do utworzenia json'a

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getCount() {
        return count;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
