package com.example.testproject.dto;

import com.example.testproject.entity.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InvoiceDetailDto {

    private Long id;
    @NotNull(message = "Product is required")
    private Product product;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Minimum quantity is 1.")
    private Integer quantity;

    @NotNull(message = "Price is required")
    private  Double price;
    private  Double discount;
    private Double gstRate;
    private Double total;

    public InvoiceDetailDto() {
    }

    public InvoiceDetailDto(Long id, Product product, Integer quantity, Double price, Double discount, Double gstRate, Double total) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.gstRate = gstRate;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getGstRate() {
        return gstRate;
    }

    public void setGstRate(Double gstRate) {
        this.gstRate = gstRate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "InvoiceDetailDto{" +
                "id=" + id +
                "product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                ", gstRate=" + gstRate +
                ", total=" + total +
                '}';
    }
}
