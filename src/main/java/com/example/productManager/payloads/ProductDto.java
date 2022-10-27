package com.example.productManager.payloads;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private String name;

    private String brand;

    private String madein;

    private float price;
}
