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

    //Kontroler służy do ustawiania endpointów tak, aby aplikacja z angulara mogła pobierać dane z bazy

    //Wstrzyknięci repozytorium
    @Autowired
    UserRepository repository;

    public UserController(UserRepository repo){
        this.repository = repo;
    }

    //Wybierz z bazy wszystkich userów
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    //Wybierz z bazy userów o danym firstname
    @GetMapping("users/{firstname}")
    public List<User> getUserByFirstname(@PathVariable("firstname")String firstname){
        return repository.findByFirstname(firstname);
    }

    //Sprawdź w bazie czy istnieje uzytkownik o danym loginie i hasle
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
