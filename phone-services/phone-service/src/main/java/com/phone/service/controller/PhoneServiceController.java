package com.phone.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.service.dto.PhoneService;

@RestController
@RequestMapping("/phone-service")
public class PhoneServiceController {

    @RequestMapping(value = "/products")
    public ResponseEntity<List<PhoneService>> getAll() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }
}
