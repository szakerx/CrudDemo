package com.example.shop.repo;

import com.example.shop.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
