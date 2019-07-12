package com.example.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    //Klasy utworzone w package'u model służą do odwzorowania encji z bazy danych

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="nip")
    private String nip;

    //Stworzenie adnotacji o kluczu obcym w innej tablicy
    @OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER)
    private List<Product> products;

    public Supplier(){}

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //Gettery potrzebne do utworzenia json'a
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
