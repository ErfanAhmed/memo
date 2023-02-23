package com.example.easymemo.service;

import com.example.easymemo.domain.Product;
import com.example.easymemo.repository.ProductRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("Should get all products")
    void getProducts() {
        //when
        productService.getProducts();

        //then
        verify(productRepository).findAll();
    }

    @Test
    @DisplayName("Should find a single Product by id")
    void findById() {
        //given
        Product product = Product.builder()
                .name("Test_1")
                .description("description")
                .build();

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        //when
        productService.findById(anyLong());

        //then
        verify(productRepository).findById(anyLong());
    }

    @Test
    @DisplayName("Should save Product")
    void save() {
        //given
        Product product = Product.builder()
                .name("Test_1")
                .description("description")
                .build();

        //when
        productService.save(product);

        //then
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productArgumentCaptor.capture());

        Product captureBook = productArgumentCaptor.getValue();
        assertThat(captureBook).isEqualTo(product);
    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    @Disabled
    void delete() {
    }
}