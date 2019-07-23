package com.example.shop.repo;
import com.example.shop.model.Product;
import com.example.shop.repo.Custom.implementations.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>, ProductRepositoryCustom {
    //Działanie analogiczne jak w UserRepository
}
