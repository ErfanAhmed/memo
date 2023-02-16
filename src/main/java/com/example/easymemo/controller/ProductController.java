package com.example.easymemo.controller;

import com.example.easymemo.domain.Product;
import com.example.easymemo.exceptionHandler.ExceptionHandlerUtil;
import com.example.easymemo.model.CustomFieldError;
import com.example.easymemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erfan
 * @since 1/12/23
 */
@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ExceptionHandlerUtil exceptionHandlerUtil;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public ResponseEntity<Product> list() {
        //todo: add shop constraint, role check
        List<Product> products = productService.getProducts();

        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable long id) {
        //todo: add shop constraint, role check
        Product product = productService.findById(id);

        return new ResponseEntity(product.getProductDetails(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Product product, BindingResult bindingResult) {
        //todo: auth check - add shop constraint, role check

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(exceptionHandlerUtil.handleCustomFieldErrors(bindingResult), HttpStatus.BAD_REQUEST);
        }

        productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody Product updatedProduct) {
        //todo: auth check, validation
        updatedProduct = productService.update(updatedProduct);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
