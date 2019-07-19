package com.example.shop.repo;

import com.example.shop.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    //Działanie analogiczne jak w UserRepository
}
