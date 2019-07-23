package com.example.shop.controller;

import com.example.shop.model.User;
import com.example.shop.model.ViewModels.UserVM;
import com.example.shop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {

    //Kontroler służy do ustawiania endpointów tak, aby aplikacja z angulara mogła pobierać dane z bazy

    //Wstrzyknięci repozytorium
    @Autowired
    UserRepository repository;

    public UserController(UserRepository repo) {
        this.repository = repo;
    }

    //Wybierz z bazy wszystkich userów
    @GetMapping("/users")
    public List<UserVM> getAllUsers() {
        List<User> users = repository.findAll();
        List<UserVM> usersVms = new ArrayList<>();
        users.forEach(data ->
            usersVms.add(new UserVM(data)));
        return usersVms;
    }

    @PutMapping("/users/changestate/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<User> changeactive(@PathVariable("id") Long id,
                                               @RequestBody UserVM user) {
        System.out.println(user.isActive());
        Optional<User> _user = repository.findById(id);
        if(_user.isPresent()) {
            User saveMe = _user.get();
            saveMe.changeField(user);
            return new ResponseEntity<>(repository.save(saveMe),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/users/create")
    public User addUser(@RequestBody User user){
        User _user = repository.save(user);
        return _user;
    }

//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id")long id){
//        System.out.println("Delete User with ID = "+id);
//        repository.deleteById(id);
//        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
//    }
}
