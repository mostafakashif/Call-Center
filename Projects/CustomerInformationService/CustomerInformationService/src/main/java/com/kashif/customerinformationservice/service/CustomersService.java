/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.customerinformationservice.service;

import com.kashif.callcentercommondtos.CustomerInformationDto;
import com.kashif.callcentercommondtos.CustomerServicesDto;

/**
 *
 * @author mostafa.kashif
 */
public interface CustomersService {

    public CustomerInformationDto getCustomerById(int id) throws Exception;
    
    public CustomerServicesDto getCustomerServicesById(int id) throws Exception;
}
