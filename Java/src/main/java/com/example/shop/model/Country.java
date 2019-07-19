package com.example.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "continent")
    private String continent;

    public Country() {}

    public String getName() {
        return name;
    }
    public String getContinent() {
        return continent;
    }
}
