package com.example.shop.controller.filters;

public class ProductFilter {
    private String name;
    private String supplier;
    private String country;

    public void setName(String name) {
        this.name = name;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    public ProductFilter () {}

    public ProductFilter(String name, String supplier, String country) {
        this.name = name;
        this.supplier = supplier;
        this.country = country;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getName() {
        return name;
    }

    public void checkValues() {
        System.out.println(this.name);
        System.out.println(this.supplier);
        System.out.println(this.country);
    }
}
