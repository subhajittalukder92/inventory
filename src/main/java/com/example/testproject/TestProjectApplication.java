package com.example.testproject;

import com.example.testproject.handler.CustomLogOutHandler;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestProjectApplication {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
    @Bean
    public LayoutDialect layoutDialect() { return new LayoutDialect();}
//    public CustomLogOutHandler customLogOutHandler(){
//       return  new CustomLogOutHandler();
//    }
    public static void main(String[] args) {
        SpringApplication.run(TestProjectApplication.class, args);
    }

}
