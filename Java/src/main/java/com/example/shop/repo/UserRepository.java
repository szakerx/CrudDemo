package com.example.shop.repo;

import com.example.shop.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findByName(String name);
}
