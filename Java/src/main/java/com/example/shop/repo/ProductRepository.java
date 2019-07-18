package com.example.shop.repo;
import com.example.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //Działanie analogiczne jak w UserRepository
}
