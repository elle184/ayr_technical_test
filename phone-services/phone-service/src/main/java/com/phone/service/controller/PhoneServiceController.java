package com.phone.service.controller;

import java.util.ArrayList;
import java.util.List;

import com.phone.service.business.ClientService;
import com.phone.service.dto.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.phone.service.dto.PhoneService;

@RestController
@RequestMapping("/phone-service")
public class PhoneServiceController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/client/{securityCode}")
    public ResponseEntity<Client> getBySecurityCode(@PathVariable("securityCode") String securityCode) {
        return new ResponseEntity<>(this.clientService.getBySecurityCode(securityCode), HttpStatus.OK);
    }

    @RequestMapping(value = "/client/create", method = RequestMethod.POST)
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        this.clientService.create(client);

        return this.buildClientResponse(client);
    }

    @RequestMapping(value = "/client/update", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        this.clientService.update(client);

        return this.buildClientResponse(client);
    }

    private ResponseEntity<Client> buildClientResponse(Client client) {
        return new ResponseEntity<>(
            this.clientService.getBySecurityCode(client.getSecurityCode())
            , HttpStatus.OK
        );
    }
}
