package com.example.easymemo.service;

import com.example.easymemo.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static com.example.easymemo.utils.Utils.isValidIdentifier;
import static java.util.Optional.ofNullable;

/**
 * @author erfan
 * @since 1/30/23
 */
@Service
public class ProductService {

    //todo: JPA data repository

    @PersistenceContext
    private EntityManager em;

    public List<Product> getProducts() {
        return em.createNamedQuery("product.getAll", Product.class)
                .getResultList();
    }

    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    @Transactional
    public Product save(Product product) {
        if (isValidIdentifier(product.getId())) {
            em.persist(product);
        } else {
            product = em.merge(product);
        }

        return product;
    }

    @Transactional
    public Product update(Product updatedProduct) {
        Product productToUpdate = findById(updatedProduct.getId());

        ofNullable(updatedProduct.getName()).ifPresent(productToUpdate::setName);
        ofNullable(updatedProduct.getQuantity()).ifPresent(productToUpdate::setQuantity);
        ofNullable(updatedProduct.getDescription()).ifPresent(productToUpdate::setDescription);

        return em.merge(productToUpdate);
    }
}
