/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.customerinformationservice.controllers;


import com.kashif.callcentercommondtos.CustomerInformationDto;
import com.kashif.callcentercommondtos.CustomerServicesDto;
import com.kashif.customerinformationservice.service.CustomersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mostafa.kashif
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomersController {

    private static final Logger logger = Logger.getLogger(CustomersController.class);
  
    @Autowired
    private CustomersService customersService;

    @RequestMapping(value = "/retrieveCustomerInformation", method = RequestMethod.GET)
    public ResponseEntity<CustomerInformationDto> retrieveCustomerInformation(@RequestParam Integer customerId) {
        try {
            logger.debug("Starting retrieveCustomerInformation controller");
            CustomerInformationDto customer = customersService.getCustomerById(customerId);
            return new ResponseEntity<> (customer,HttpStatus.OK);
        } catch (Exception ex) {
            if(ex.getMessage().contains("No customer exist with id:"))
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
           logger.error("Exception while retrieveCustomerInformation for id:"+customerId+"," + ex,ex);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/retrieveCustomerServices", method = RequestMethod.GET)
    public ResponseEntity<CustomerServicesDto> retrieveCustomerServices(@RequestParam Integer customerId) {
        try {
            logger.debug("Starting retrieveCustomerServices controller");
            CustomerServicesDto customerServices = customersService.getCustomerServicesById(customerId);
            return new ResponseEntity<> (customerServices,HttpStatus.OK);
        } catch (Exception ex) {
          logger.error("Exception while retrieveCustomerServices for id:"+customerId+"," + ex,ex);
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
