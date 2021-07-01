package com.example.how_to_use_many_to_many_in_jpa.domain.repository;

import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
