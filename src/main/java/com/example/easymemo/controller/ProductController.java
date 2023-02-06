package com.example.easymemo.controller;

import com.example.easymemo.domain.Product;
import com.example.easymemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author erfan
 * @since 1/12/23
 */
@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Product> list() {
        List<Product> products = productService.getProducts();

        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable long id) {
        Product product = productService.findById(id);

        return new ResponseEntity(product.getProductDetails(), HttpStatus.OK);
    }
}
