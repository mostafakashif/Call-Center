/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.submitcomplaintservice.controllers;

import com.kashif.callcentercommondtos.ComplaintDto;
import com.kashif.submitcomplaintservice.service.ComplaintsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mostafa.kashif
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComplaintsController {

    private static final Logger logger = Logger.getLogger(ComplaintsController.class);
    @Autowired
    private ComplaintsService complaintsService;

    @RequestMapping(value = "/complaints", method = RequestMethod.POST)
    public ResponseEntity addComplaint(@RequestBody ComplaintDto complaint) {
        try {
            logger.debug("Starting addComplaint controller");
            complaintsService.addComplaint(complaint);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Exception while addComplaint:" + ex.getMessage(),ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
