package com.example.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "count")
    private double count;

    @Column(name = "category")
    private String category;


    @Column(name = "supplier")
    private int supplierid;

    public Product(){}
    public Product(int id, String name,String country, double count, String category, int supplierid){
        this.id = id;
        this.country = country;
        this.category = category;
        this.count = count;
        this.name = name;
        this.supplierid = supplierid;
    }

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

    public int getSupplierid() {
        return supplierid;
    }

    public String getCategory() {
        return category;
    }
}
