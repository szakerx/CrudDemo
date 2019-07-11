package com.example.shop.controller;
import com.example.shop.model.User;
import com.example.shop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserRepository repository;
    public UserController(UserRepository repo){
        this.repository = repo;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("users/{firstname}")
    public List<User> getUserByFirstname(@PathVariable("firstname")String firstname){
        return repository.findByFirstname(firstname);
    }
    @GetMapping("/checkuser")
    public boolean checkUserExistance(@RequestParam("login") String login,@RequestParam("pass") String pass){
        List<User> users = repository.findByLoginAndPass(login,pass);
        if (users.size() > 0) {
            System.out.println(users.size());
            System.out.println("true");
            return true;
        } else{
            System.out.println(users.size());
            System.out.println("false");
            return false;
        }
    }


//    @PostMapping(value = "/users/create")
//    public User postUser(@RequestBody User user){
//        User _user = repository.save(new User(user.getFirstname(),user.getLastname()));
//        return _user;
//    }

//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id")long id){
//        System.out.println("Delete User with ID = "+id);
//        repository.deleteById(id);
//        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
//    }
}
