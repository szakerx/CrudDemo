package com.example.shop.controller;

import com.example.shop.model.Enums.Roles;
import com.example.shop.model.User;
import com.example.shop.model.ViewModels.UserVM;
import com.example.shop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        List<User> users = repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        List<UserVM> usersVms = new ArrayList<>();
        users.forEach(data ->
            usersVms.add(new UserVM(data)));
        return usersVms;
    }

    @PutMapping("/users/changestate/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<User> changeActive(@PathVariable("id") Long id,
                                               @RequestBody UserVM user) {
        Optional<User> _user = repository.findById(id);
        if(_user.isPresent()) {
            User saveMe = _user.get();
            saveMe.changeField(user);
            return new ResponseEntity<>(repository.save(saveMe),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("users/update/{id}")
    public ResponseEntity<User> updateProduct(@PathVariable("id") Long id,
                                                 @RequestBody UserVM user) {
        Optional<User> _user = repository.findById(id);
        if(_user.isPresent()) {
            User saveMe = _user.get();
            saveMe.update(user);
            return new ResponseEntity<>(repository.save(saveMe),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("users/changepassword/{id}")
    public ResponseEntity<String> changePassword(@PathVariable("id") Long id,
                                                 @RequestBody String password) {
        Optional<User> _user = repository.findById(id);
        if(_user.isPresent()) {
            User saveMe = _user.get();
            saveMe.setPass(password);
            repository.save(saveMe);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        if(user.canBeAdded()) {
            return new ResponseEntity<>(repository.save(user),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/roles")
    public String[] getRoles() {
        Roles[] types = Roles.values();
        String[] names = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }
        return names;
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")long id){
        repository.deleteById(id);
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }
}
