package com.example.testproject.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/admin/test")
    public String showForm(Model model){
        model.addAttribute("title", "Home Page");
        return "admin/pages/home";
       // return "test";

    }
}
