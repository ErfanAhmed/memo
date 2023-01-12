package com.example.easymemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author erfan
 * @since 1/12/23
 */
@RestController
@RequestMapping(value = "/test")
public class ProductController {

    @GetMapping
    public String test() {
        System.out.println("\n\n\nhello");
        return "test";
    }
}
