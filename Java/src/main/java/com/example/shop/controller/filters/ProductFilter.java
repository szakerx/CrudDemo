package com.example.shop.controller.filters;

import com.example.shop.model.Enums.Category;
import com.example.shop.model.Enums.Type;

public class ProductFilter {
    private String supplier;
    private String country;
    private String type;
    private String category;
    private Type type_enum;
    private Category category_enum;

    public ProductFilter () {}

    public ProductFilter(String supplier, String country, String type, String category) {
        this.supplier = supplier;
        this.country = country;
        this.type = type;
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public Type getType_enum() { return type_enum; }

    public Category getCategory_enum() {
        return category_enum;
    }

    public void createEnums() {
        if(type.equals("weight")) {
            type_enum = Type.weight;
        } else if(type.equals("count")) {
            type_enum = Type.count;
        }

        if(category.equals("fruit")) {
            category_enum = Category.fruit;
        } else if(category.equals("vegetable")) {
            category_enum = Category.vegetable;
        } else if(category.equals("other")) {
            category_enum = Category.other;
        }
    }
    public boolean isEmpty() {
        if(supplier.equals("")  && country.equals("")  && type.equals("")  && category.equals("")) {
            return true;
        }
        return false;
    }
}
