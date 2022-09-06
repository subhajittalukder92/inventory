package com.example.testproject.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    private Double totalAmt;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceDetail> invoiceDetail = new ArrayList<>();

    public Invoice(){

    }
    public Invoice(Long id, Client client, Double totalAmt, Date date, List<InvoiceDetail> invoiceDetail) {
        this.id = id;
        this.client = client;
        this.totalAmt = totalAmt;
        this.date = date;
        this.invoiceDetail = invoiceDetail;
    }
    public void addInvoiceDetail(InvoiceDetail invoiceDetail){
        this.invoiceDetail.add(invoiceDetail);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client=" + client +
                ", totalAmt=" + totalAmt +
                ", date=" + date +
                ", invoiceDetail=" + invoiceDetail +
                '}';
    }
}
