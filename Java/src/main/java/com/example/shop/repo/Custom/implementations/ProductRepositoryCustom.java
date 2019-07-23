package com.example.shop.repo.Custom.implementations;

import com.example.shop.controller.filters.ProductFilter;
import com.example.shop.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> productFilter(ProductFilter pf);
}
