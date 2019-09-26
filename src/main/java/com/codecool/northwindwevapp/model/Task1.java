package com.codecool.northwindwevapp.model;

public class Task1 {
    private String product;
    private String company;

    public Task1(String product, String company) {
        this.product = product;
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}