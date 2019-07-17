package com.example.shop.model.ViewModels;

import com.example.shop.model.Supplier;

public class SupplierName {

    private String name;

    public SupplierName(){}
    public SupplierName(Supplier supplier){
        this.name = supplier.getName();
    }
    public String getName() {
        return name;
    }
}
