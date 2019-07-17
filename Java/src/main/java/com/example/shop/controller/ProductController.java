package com.example.shop.controller;

import com.example.shop.model.Enums.Category;
import com.example.shop.model.Product;
import com.example.shop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shop.model.Enums.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")long id){
        System.out.println("Delete Product with ID = " + id);
        repository.deleteById(id);
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }

    @PostMapping("products/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){

        Product _product = repository.save(product);
        return _product;
    }

    @GetMapping("/products/enums/types")
    public String[] getTypes() {
        Type[] types = Type.values();
        String[] names = new String[types.length];

        System.out.println("typy");
        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }
        return names;
    }

    @GetMapping("/products/enums/categories")
    public String[] getCategories() {
        Category[] categories = Category.values();
        String[] names = new String[categories.length];

        System.out.println("kategorie");
        for (int i = 0; i < categories.length; i++) {
            names[i] = categories[i].name();
        }
        return names;
    }
}
