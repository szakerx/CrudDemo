package com.example.shop.controller;

import com.example.shop.model.Product;
import com.example.shop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ProductController {

    //Kontroler służy do ustawiania endpointów tak, aby aplikacja z angulara mogła pobierać dane z bazy

    //Wstrzyknięice repozytorium
    @Autowired
    ProductRepository repository;
    public ProductController(ProductRepository repository){
        this.repository=repository;
    }

    //Wybierz wszystkie produkty
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        System.out.println("Get all products");
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }
}
