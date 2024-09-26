package com.example.easymemo.repository;

import com.example.easymemo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erfan
 * @since 2/19/23
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
