package com.example.testproject.service;

import com.example.testproject.dao.InvoiceRepository;
import com.example.testproject.entity.Invoice;
import com.example.testproject.entity.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        Optional<Invoice> result = invoiceRepository.findById(id);
        Invoice invoice =null;
        if(result.isPresent()){
            invoice = result.get();
        }
        return  invoice;
    }

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void deleteById(Long id) {
       invoiceRepository.deleteById(id);
    }

    @Override
    public Double getTotalAmount(List<InvoiceDetail> invoiceDetails) {
        Double totalAmount = 0.0;
        for (int i=0 ; i< invoiceDetails.size();i++){
            Double amount = invoiceDetails.get(i).getQuantity() * invoiceDetails.get(i).getPrice() ;
            Double taxable = amount * (100 - invoiceDetails.get(i).getDiscount())/100 ;
            Double total = taxable * (100 + invoiceDetails.get(i).getGstRate())/100;
            totalAmount += total ;
          //  System.out.println(taxable);
        }
        return totalAmount;
    }
}
