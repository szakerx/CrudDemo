package com.example.shop.repo;

import com.example.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserRepository extends JpaRepository<User,Long> {
    //Klasa służąca do pobrania Userów z bazy danych, wszystkie podstawowe metody zawiera JpaRepostiroy więc nie trzeba ich pisać.
    List<User> findByFirstname(String firstname);
    List<User> findByLoginAndPass(String login, String pass);
}
