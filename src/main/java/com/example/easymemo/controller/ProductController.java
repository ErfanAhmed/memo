package com.example.easymemo.controller;

import com.example.easymemo.domain.Product;
import com.example.easymemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author erfan
 * @since 1/12/23
 */
@RestController
@RequestMapping(value = "/test")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Product> test() {
        List<Product> products = productService.getProducts();

        return new ResponseEntity(products, HttpStatus.OK);
    }
}
