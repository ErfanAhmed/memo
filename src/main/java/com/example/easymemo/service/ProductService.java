package com.example.easymemo.service;

import com.example.easymemo.domain.Product;
import com.example.easymemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * @author erfan
 * @since 1/30/23
 */
@Service
public class ProductService {

    //todo: JPA data repository
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageSourceAccessor msa;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        msa.getMessage("product.not.found", new Object[]{id})));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product updatedProduct) {
        Product sourceProduct = findById(updatedProduct.getId());

        ofNullable(updatedProduct.getName()).ifPresent(sourceProduct::setName);
        ofNullable(updatedProduct.getQuantity()).ifPresent(sourceProduct::setQuantity);
        ofNullable(updatedProduct.getDescription()).ifPresent(sourceProduct::setDescription);

        return productRepository.save(sourceProduct);
    }

    public void delete(Product product) {
        product = findById(product.getId());

        productRepository.delete(product);
    }
}
