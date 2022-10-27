package com.example.productManager.service;


import com.example.productManager.data.models.Product;
import com.example.productManager.data.repositories.ProductRepository;
import com.example.productManager.payloads.ProductDto;
import com.example.productManager.web.exceptions.ProductNotFoundException;
import com.example.productManager.web.exceptions.RunTimeExceptionPlaceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto productDto) throws RunTimeExceptionPlaceHolder, ProductNotFoundException {

        validateProduct(productDto);

        Product savedProduct = getProductToSave(productDto);

        saveProduct(savedProduct);

        return getProductInfo(savedProduct);
    }

    private ProductDto getProductInfo(Product savedProduct) {

        return ProductDto.builder()
                .name(savedProduct.getName())
                .build();
    }

    private Product getProductToSave(ProductDto productDto) {

        Product productToSave = Product.builder()
                .name(productDto.getName())
                .brand(productDto.getBrand())
                .madein(productDto.getMadein())
                .price(productDto.getPrice())
                .build();

        return productToSave;
    }

    private Product saveProduct(Product product) throws ProductNotFoundException {

        if(product == null){
            throw new ProductNotFoundException("Product cannot be null");
        }
        return productRepository.save(product);
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long productId) throws ProductNotFoundException {

        Optional<Product> product = productRepository.findById(productId);

        return product.orElseThrow(()->
                new ProductNotFoundException("Product does not exist"));
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {

        Product productToDelete = findProductById(productId);
        productRepository.delete(productToDelete);
    }
    private void validateProduct(ProductDto productDto) throws RunTimeExceptionPlaceHolder {

        if (productDto == null){
            throw new IllegalArgumentException("Field cannot be null");
        }
    }
}
