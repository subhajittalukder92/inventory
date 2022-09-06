package com.example.testproject.controller;

import com.example.testproject.dto.ClientDto;
import com.example.testproject.dto.InvoiceDetailDto;
import com.example.testproject.dto.InvoiceDto;
import com.example.testproject.entity.Client;
import com.example.testproject.entity.Invoice;
import com.example.testproject.entity.InvoiceDetail;
import com.example.testproject.entity.Product;
import com.example.testproject.helper.Helper;
import com.example.testproject.helper.Message;
import com.example.testproject.service.ClientService;
import com.example.testproject.service.InvoiceService;
import com.example.testproject.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin/invoice")
public class InvoiceController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;
    private List<Product> products;
    private List<Client> clients;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("")
    public String showInvoices(Model theModel){
        theModel.addAttribute("invoices", invoiceService.findAll());
        return "admin/pages/invoice/index";
    }
    @GetMapping("/create")
    public String createInvoiceForm(Model theModel){
        System.out.println("Test");
        InvoiceDto invoice = new InvoiceDto();
        ClientDto clientDto = new ClientDto();
        invoice.addInvoiceDetail(new InvoiceDetailDto());
        System.out.println(products);

        products = productService.findAll();
        clients  = clientService.findAll() ;

        theModel.addAttribute("invoice", invoice);
        theModel.addAttribute("clients", clients);
        theModel.addAttribute("products", products);
        theModel.addAttribute("newClient", clientDto);

        return  "admin/pages/invoice/create";

    }
    @GetMapping("/edit/{id}")
    public String editInvoiceForm(@PathVariable Long id,  Model theModel, RedirectAttributes redirectAttr) throws ParseException {

            try{
                Invoice invoice =  invoiceService.findById(id);
                if(invoice == null){
                    redirectAttr.addFlashAttribute("message", new Message( "Invoice not found", "alert-danger"));
                    return "redirect:/admin/invoice";
                }
                invoice.setDate(Helper.formatDate(invoice.getDate()));
                System.out.println(invoice);

                products = productService.findAll();
                clients  = clientService.findAll() ;

                theModel.addAttribute("invoice", invoice);
                theModel.addAttribute("clients", clients);
                theModel.addAttribute("products", products);
                return  "admin/pages/invoice/create";
            }catch (Exception ex){
                redirectAttr.addFlashAttribute("message", new Message( "Invoice not found", "alert-danger"));
                return "redirect:/admin/invoice";
            }


    }
    @PostMapping("/create")
    public String saveInvoice(@Valid  @ModelAttribute("invoice") InvoiceDto invoiceDto, BindingResult result, Model theModel,
                              RedirectAttributes redirectAttr){

        products = productService.findAll();
        clients  = clientService.findAll() ;

        if(result.hasErrors()){
         theModel.addAttribute("clients", clients);
         theModel.addAttribute("products", products);
         System.out.println(result);
         return  "admin/pages/invoice/create";
        }
     Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);
     List<InvoiceDetailDto> invoiceDetailsDto = invoiceDto.getInvoiceDetail();
     List<InvoiceDetail> invoiceDetails = invoiceDetailsDto.stream().map(invoiceDetail -> new InvoiceDetail
                    (invoiceDetail.getId(),
                     invoiceDetail.getProduct(),
                     invoiceDetail.getQuantity(),
                     invoiceDetail.getPrice(),
                     invoiceDetail.getGstRate(),
                     invoiceDetail.getDiscount(),
                     invoiceDetail.getTotal()
                    )
     ).collect(Collectors.toList());
     invoice.setTotalAmt(invoiceService.getTotalAmount(invoiceDetails));
     invoice.setInvoiceDetail(invoiceDetails);
     invoiceService.save(invoice);
     System.out.println(invoice);
     redirectAttr.addFlashAttribute("message",
             new Message("Invoice saved successfully.", "alert-success"));
     return  "redirect:/admin/invoice";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Long id, RedirectAttributes redirectAttr){
        Invoice invoice =  invoiceService.findById(id);
        if(invoice == null){
            redirectAttr.addFlashAttribute("message", new Message("Invoice Not found", "alert-danger"));
            return "redirect:/admin/invoice";
        }
        invoiceService.deleteById(id);
        redirectAttr.addFlashAttribute("message", new Message( "Invoice deleted successfully", "alert-success"));
        return "redirect:/admin/invoice";

    }


}
