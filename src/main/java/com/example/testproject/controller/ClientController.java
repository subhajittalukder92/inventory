package com.example.testproject.controller;

import com.example.testproject.dao.ClientRepository;
import com.example.testproject.dto.ClientDto;
import com.example.testproject.entity.Client;
import com.example.testproject.entity.Product;
import com.example.testproject.response.ResponseHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RequestMapping("/admin/client")
@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> saveClient(@RequestBody ClientDto clientDto){
        Client client = modelMapper.map(clientDto, Client.class);
        clientRepository.save(client);
        System.out.println(clientDto.getClientName());
        return ResponseHandler.showResponse(true,client,"Client save", HttpStatus.CREATED);

    }
}
