package com.example.testproject.controller;

import com.example.testproject.dto.ProductDto;
import com.example.testproject.dto.UserForm;
import com.example.testproject.entity.Role;
import com.example.testproject.entity.User;
import com.example.testproject.helper.Message;
import com.example.testproject.service.RoleService;
import com.example.testproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class AuthenticationController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userServ;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String showRegForm(Model theModel){
        theModel.addAttribute("registration", new UserForm());
        return "registration";
    }
    @GetMapping("/product")
    public String showProduct(Model theModel){
        theModel.addAttribute("product", new ProductDto());
        return "create";
    }
    @PostMapping("/product")
    public String saveProduct(@ModelAttribute("product") @Valid ProductDto form, BindingResult result)
    {
        if(result.hasErrors()){
            System.out.println(result);
            return "/create";
        }
        return "/create";
    }

    @GetMapping("/login")
    public String LoginForm(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/admin/test";
        }
        return "login";

    }

    @PostMapping("/registration")
    public String saveRegistration(@ModelAttribute("registration") @Valid UserForm form,
                                   BindingResult result, Model theModel
    )
    {
        try {
            if(result.hasErrors()){
               // theModel.addAttribute("registration", new UserForm());
                System.out.println(result);
                return "/registration";
            }
            Role role = roleService.findById(1);
            User user = modelMapper.map(form, User.class);
            user.setRoles(Arrays.asList(role));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userServ.save(user);

            theModel.addAttribute("registration", new UserForm());
            theModel.addAttribute("message", new Message("User saved successfully", "alert-success"));

            System.out.println(user);

            return "registration";
        } catch (Exception ex){
            ex.printStackTrace();
            theModel.addAttribute("message", new Message("Error: "+ex.getMessage(), "alert-danger"));
            return "registration";
        }
    }
}
