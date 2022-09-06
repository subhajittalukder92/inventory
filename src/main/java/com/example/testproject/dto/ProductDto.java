package com.example.testproject.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDto {
    private int id;
    @NotEmpty(message = "Product name is required")
    private String productName;
    @NotNull(message = "Product price is required")
    private Double price;
    @NotNull(message = "Gst rate is required")
    private Double gstRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getGstRate() {
        return gstRate;
    }

    public void setGstRate(Double gstRate) {
        this.gstRate = gstRate;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", gstRate=" + gstRate +
                '}';
    }
}
