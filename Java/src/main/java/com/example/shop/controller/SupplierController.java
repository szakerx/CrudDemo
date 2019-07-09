package com.example.shop.controller;

import com.example.shop.model.Supplier;
import com.example.shop.repo.SupplierRepository;
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
public class SupplierController {
    @Autowired
    SupplierRepository repository;

    public SupplierController(SupplierRepository repository){
        this.repository = repository;
    }

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers(){
        System.out.println("Get all suppliers");
        List<Supplier> suppliers = new ArrayList<>();
        repository.findAll().forEach(suppliers::add);
        return  suppliers;
    }
}
