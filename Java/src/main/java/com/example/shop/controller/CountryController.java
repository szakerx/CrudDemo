package com.example.shop.controller;

import com.example.shop.model.Country;
import com.example.shop.repo.CountryRepository;
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
public class CountryController {
    @Autowired
    CountryRepository repository;

    @GetMapping("/countries")
    public List<String> getCountries() {
        List<String> countries = new ArrayList<>();
        repository.findAll().forEach(data -> {
            countries.add(data.getName());
        });
        return countries;
    }
}
