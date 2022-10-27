package com.example.productManager.service;

import com.example.productManager.data.models.Product;
import com.example.productManager.payloads.ProductDto;
import com.example.productManager.web.exceptions.ProductNotFoundException;
import com.example.productManager.web.exceptions.RunTimeExceptionPlaceHolder;

import java.util.List;

public interface ProductService {


    ProductDto saveProduct (ProductDto productDto) throws RunTimeExceptionPlaceHolder, ProductNotFoundException;

    List<Product> getAllProducts();

    Product findProductById(Long productId) throws ProductNotFoundException;

    void deleteProduct(Long productId) throws ProductNotFoundException;
}
