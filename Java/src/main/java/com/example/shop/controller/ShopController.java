package com.example.shop.controller;
import com.example.shop.model.User;
import com.example.shop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http:localhost:4200")
@RestController
@RequestMapping("/api")
public class ShopController {
    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        System.out.println("Get all Users...");

        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);

        return users;
    }
    @PostMapping(value = "/users/create")
    public User postUser(@RequestBody User user){
        User _user = repository.save(new User(user.getFirstname(),user.getLastname()));
        return _user;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")long id){
        System.out.println("Delete User with ID = "+id);
        repository.deleteById(id);
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }
}
