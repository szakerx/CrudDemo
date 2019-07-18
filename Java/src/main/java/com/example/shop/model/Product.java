package com.example.shop.model;

import com.example.shop.model.Enums.Category;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "products")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Product {

    //Klasy utworzone w package'u model służą do odwzorowania encji z bazy danych

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @Type(type = "pgsql_enum")
    private com.example.shop.model.Enums.Type type;

    @Column(name = "country")
    private String country;

    @Column(name = "count")
    private double count;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    @Column(name = "category")
    private Category category;

    //Dostarczenie danych z klucza obcego
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    public Product(){}

    //Gettery potrzebne do utworzenia json'a

    public Long getId() {
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

    public Category getCategory() {
        return category;
    }

    public com.example.shop.model.Enums.Type getType() {
        return type;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
