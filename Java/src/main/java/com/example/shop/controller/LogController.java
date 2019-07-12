package com.example.shop.controller;
import com.example.shop.model.Log;
import com.example.shop.repo.LogRepository;
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
public class LogController {

    //Kontroler służy do ustawiania endpointów tak, aby aplikacja z angulara mogła pobierać dane z bazy

    //Wstrzyknięcie repozytorium
    @Autowired
    LogRepository repository;

    public LogController(LogRepository repository){
        this.repository = repository;
    }

    //Pobierz wszystkie logi
    @GetMapping("/logs")
    public List<Log> getAllLogs(){
        System.out.println("Get all logs");
        List<Log> logs = new ArrayList<>();
        repository.findAll().forEach(logs::add);
        return  logs;
    }
}
