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

    //Kontroler służy do ustawiania endpointów tak, aby aplikacja z angulara mogła pobierać dane z bazy

    //Wstrzyknięcie repozytorium
    @Autowired
    SupplierRepository repository;

    public SupplierController(SupplierRepository repository){
        this.repository = repository;
    }

    //Wybierz wszystkich dostawców
    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers(){
        List<Supplier> suppliers = new ArrayList<>();
        repository.findAll().forEach(suppliers::add);
        return  suppliers;
    }
}
