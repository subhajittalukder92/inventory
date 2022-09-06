package com.example.testproject.controller;

import com.example.testproject.dto.ProductDto;
import com.example.testproject.entity.Product;
import com.example.testproject.helper.Message;
import com.example.testproject.response.ResponseHandler;
import com.example.testproject.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin/product")
public class ProductController {
    private String page = "admin/pages/product/";
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String getAll(Model theModel){
        List<Product> products = productService.findAll();
        theModel.addAttribute("products", products);
        return page + "index";

    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new ProductDto());
        return page + "create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        if(product == null){
            return page + "index";
        }
        model.addAttribute("product", product);
        return page + "create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("product") ProductDto productDto,
                        BindingResult result, RedirectAttributes reAttr){
        try {
            if(result.hasErrors()){
                System.out.println(result);
                return page + "create";
            }

            Product product = modelMapper.map(productDto, Product.class);
            productService.save(product);
            reAttr.addFlashAttribute("message", new Message("Product saved successfully", "alert-success"));

            return "redirect:/admin/product/" ;

        }catch (Exception ex){
            ex.printStackTrace();
            reAttr.addFlashAttribute("message", new Message(ex.getMessage(), "alert-danger"));

            return "redirect:/admin/product/" ;

        }
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("productId") int id, RedirectAttributes redirectAttributes){
        try{
            Product product = productService.findById(id);
            if(product == null){
                throw new Exception("Product not found");
            }
            productService.deleteById(id);
            redirectAttributes.addFlashAttribute("message",
                    new Message("Product deleted successfully", "alert-success"));

            return "redirect:/admin/product/" ;
        }catch (Exception ex){
           // ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message",
                    new Message(ex.getMessage(), "alert-danger"));
            return "redirect:/admin/product/" ;
        }

    }
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> getProductById(@PathVariable int id){
        try {
            Product product = productService.findById(id);
            if(product == null){
               return ResponseHandler.showResponse(false, null, "Product not found.", HttpStatus.NOT_FOUND);
            }
            return ResponseHandler.showResponse(true, Arrays.asList(product), "Product found.", HttpStatus.OK);
        } catch (Exception ex){
            return ResponseHandler.showResponse(false, null, ex.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
}
