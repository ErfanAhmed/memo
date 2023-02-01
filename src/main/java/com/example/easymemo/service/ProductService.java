package com.example.easymemo.service;

import com.example.easymemo.domain.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author erfan
 * @since 1/30/23
 */
@Service
public class ProductService {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getProducts() {
        return em.createNamedQuery("product.getAll", Product.class)
                .getResultList();
    }
}
