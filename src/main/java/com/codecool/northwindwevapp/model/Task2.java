package com.codecool.northwindwevapp.model;

public class Task2 {
    public String productName;
    public Integer products;


    public String getProductName() {
        return productName;
    }

    public Integer getProducts() {
        return products;
    }

    public Task2(String productName, Integer products) {
        this.productName = productName;
        this.products = products;
    }
}
