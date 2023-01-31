package com.phone.service.controller;

import com.phone.service.business.ClientService;
import com.phone.service.business.CompanyService;
import com.phone.service.business.PhoneService;
import com.phone.service.business.PlanService;
import com.phone.service.dto.Client;
import com.phone.service.dto.Company;
import com.phone.service.dto.PhoneServiceDTO;
import com.phone.service.dto.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone-service")
public class PhoneServiceController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PlanService planService;

    @Autowired
    private PhoneService phoneService;

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

    @RequestMapping(value = "/company/create", method = RequestMethod.POST)
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        this.companyService.create(company);

        return new ResponseEntity<>("Company created", HttpStatus.OK);
    }

    @RequestMapping(value = "/company/update", method = RequestMethod.PUT)
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        this.companyService.update(company);

        return this.buildCompanyResponse(company.getId());
    }

    @RequestMapping(value = "/company/{id}")
    public ResponseEntity<Company> getById(@PathVariable("id") Long id) {
        return this.buildCompanyResponse(id);
    }

    @RequestMapping(value = "/plan/create", method = RequestMethod.POST)
    public ResponseEntity<String> createPlan(@RequestBody Plan plan) {
        this.planService.create(plan);

        return new ResponseEntity<>("Plan created.", HttpStatus.OK);
    }

    @RequestMapping(value = "/plan/update", method = RequestMethod.PUT)
    public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan) {
        this.planService.update(plan);

        return this.buildPlanResponse(plan.getId());
    }

    @RequestMapping(value = "/plan/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        this.planService.delete(id);

        return new ResponseEntity<>(
            "Plan deleted"
            , HttpStatus.OK);
    }

    @RequestMapping(value = "/plan/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long id) {
        return this.buildPlanResponse(id);
    }

    @RequestMapping(value = "/service/create", method = RequestMethod.POST)
    public ResponseEntity<PhoneServiceDTO> createPhoneService(@RequestBody PhoneServiceDTO phoneServiceDto) {
        this.phoneService.create(phoneServiceDto);

        return this.buildPhoneServiceResponse(phoneServiceDto);
    }

    @RequestMapping(value = "/service/update", method = RequestMethod.PUT)
    public ResponseEntity<PhoneServiceDTO> updatePhoneService(@RequestBody PhoneServiceDTO phoneServiceDto) {
        this.phoneService.update(phoneServiceDto);

        return this.buildPhoneServiceResponse(phoneServiceDto);
    }

    @RequestMapping(value = "/service/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePhoneService(PhoneServiceDTO phoneServiceDto) {
        this.phoneService.delete(phoneServiceDto);

        return new ResponseEntity<>("Phone service detached", HttpStatus.OK);
    }

    @RequestMapping(value = "/service/client/{clientId}")
    public ResponseEntity<List<PhoneServiceDTO>> getByClient(@PathVariable Long clientId) {
        return new ResponseEntity<>(
            this.phoneService.getByClient(clientId)
            , HttpStatus.OK
        );
    }

    @RequestMapping(value = "/service/client/{clientId}/{phoneNumber}")
    public ResponseEntity<PhoneServiceDTO> getByClientAndPhoneNumber(
        @PathVariable Long clientId, @PathVariable Integer phoneNumber) {
        return new ResponseEntity<>(
            this.phoneService.getByClientAndPhoneNumber(clientId, phoneNumber)
            , HttpStatus.OK
        );
    }

    private ResponseEntity<Client> buildClientResponse(Client client) {
        return new ResponseEntity<>(
            this.clientService.getBySecurityCode(client.getSecurityCode())
            , HttpStatus.OK);
    }

    private ResponseEntity<Company> buildCompanyResponse(Long id) {
        return new ResponseEntity<>(
            this.companyService.getById(id)
            , HttpStatus.OK);
    }

    private ResponseEntity<Plan> buildPlanResponse(Long id) {
        return new ResponseEntity<>(
            this.planService.getById(id)
            , HttpStatus.OK);
    }

    private ResponseEntity<PhoneServiceDTO> buildPhoneServiceResponse(PhoneServiceDTO phoneServiceDto) {
        return new ResponseEntity<>(
            this.phoneService.getByClientAndPhoneNumber(
                phoneServiceDto.getClient().getId()
                , phoneServiceDto.getPhoneNumber())
            , HttpStatus.OK
        );
    }
}
