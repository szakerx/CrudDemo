package com.example.shop.repo;

import com.example.shop.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
    //Działanie analogiczne jak w UserRepository
}
