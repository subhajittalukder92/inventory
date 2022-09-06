package com.example.testproject.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> showResponse(Boolean status, Object responseObj, String message, HttpStatus httpStatus){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", status);
        map.put("data", responseObj);
        map.put("message", message);
        return new ResponseEntity<Object>(map, httpStatus);
    }
}
