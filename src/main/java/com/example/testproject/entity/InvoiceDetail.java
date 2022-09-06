package com.example.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Product product;
    private int quantity;
    private Double price;
    private Double gstRate;

    private Double discount;

    private Double total;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Long id, Product product, int quantity, Double price, Double gstRate, Double discount, Double total) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.gstRate = gstRate;
        this.discount = discount;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", gstRate=" + gstRate +
                ", discount=" + discount +
                ", total=" + total +
                '}';
    }
}
