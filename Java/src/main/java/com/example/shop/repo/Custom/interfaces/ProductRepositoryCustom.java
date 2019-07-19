package com.example.shop.repo.Custom.interfaces;

import com.example.shop.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findProductBySupplierNameAndCountry(String supplier, String country);
}
