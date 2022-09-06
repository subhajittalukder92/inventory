package com.example.testproject.dto;

import com.example.testproject.entity.Client;
import com.example.testproject.entity.InvoiceDetail;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDto {
    private Long id;
    @NotNull(message = "Client is required")
    private Client client;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @NotNull(message = "Date is required")
    private Date date;
    private Double totalAmt;
    @Valid
    private List<InvoiceDetailDto> invoiceDetail = new ArrayList<>();

    public InvoiceDto() {
    }

    public InvoiceDto(Long id, Client client, Date date, Double totalAmt, List<InvoiceDetailDto> invoiceDetail) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.totalAmt = totalAmt;
        this.invoiceDetail = invoiceDetail;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public List<InvoiceDetailDto> getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(List<InvoiceDetailDto> invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }
    public void addInvoiceDetail(InvoiceDetailDto invoiceDetail){
        this.invoiceDetail.add(invoiceDetail);
    }

    @Override
    public String toString() {
        return "InvoiceDto{" +
                "id=" + id +
                ", client=" + client +
                ", date=" + date +
                ", totalAmt=" + totalAmt +
                ", invoiceDetail=" + invoiceDetail +
                '}';
    }
}
