package com.example.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private Double price;
    private Double gstRate;

    public Product() {
    }

    public Product(int id, String productName, Double price, Double gstRate) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.gstRate = gstRate;
    }

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
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", gstRate=" + gstRate +
                '}';
    }
}
