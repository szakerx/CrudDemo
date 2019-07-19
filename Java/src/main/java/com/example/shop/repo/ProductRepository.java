package com.example.shop.repo;
import com.example.shop.model.Product;
import com.example.shop.repo.Custom.interfaces.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,Long>, ProductRepositoryCustom {
    //Działanie analogiczne jak w UserRepository
}
