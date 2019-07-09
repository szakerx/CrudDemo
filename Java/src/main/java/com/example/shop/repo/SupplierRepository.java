package com.example.shop.repo;

import com.example.shop.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
