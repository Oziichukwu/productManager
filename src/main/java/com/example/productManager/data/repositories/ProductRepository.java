package com.example.productManager.data.repositories;

import com.example.productManager.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findById(Long id);

    Boolean existsByName(String name);
}
