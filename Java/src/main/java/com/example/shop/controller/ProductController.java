package com.example.shop.controller;

import com.example.shop.controller.filters.ProductFilter;
import com.example.shop.model.Enums.Category;
import com.example.shop.model.Product;
import com.example.shop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shop.model.Enums.Type;

import java.util.*;

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
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
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

    @PutMapping("products/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
                                 @RequestBody Product product) {
        Optional<Product> _product = repository.findById(id);
        if(_product.isPresent()) {
            System.out.println("Updating...");
            return new ResponseEntity<>(repository.save(product),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/products/enums/types")
    public String[] getTypes() {
        Type[] types = Type.values();
        String[] names = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }
        return names;
    }

    @GetMapping("/products/enums/categories")
    public String[] getCategories() {
        Category[] categories = Category.values();
        String[] names = new String[categories.length];
        for (int i = 0; i < categories.length; i++) {
            names[i] = categories[i].name();
        }
        return names;
    }

    @PostMapping("/products/myquery")
    public List<Product> myQuery(@RequestBody ProductFilter productFilter) {
        productFilter.checkValues();
        List<Product> products = new ArrayList<>();
        Set<String> suppliers = new HashSet<>();
        Set<String> countries = new HashSet<>();
        suppliers.add(productFilter.getSupplier());
        countries.add(productFilter.getCountry());
        repository.findProductBySupplierNameAndCountry(productFilter.getSupplier(),productFilter.getCountry()).forEach(products::add);
        return products;
    }
}
