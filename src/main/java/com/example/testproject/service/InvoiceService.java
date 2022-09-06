package com.example.testproject.service;

import com.example.testproject.entity.Invoice;
import com.example.testproject.entity.InvoiceDetail;

import java.util.List;

public interface InvoiceService {
    public List<Invoice> findAll();
    public Invoice findById(Long id);
    public void save(Invoice invoice);
    public void deleteById(Long id);
    public Double getTotalAmount(List<InvoiceDetail> invoiceDetail);
}
