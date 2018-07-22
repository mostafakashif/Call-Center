/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.customerinformationservice.service.impl;

import com.kashif.callcentercommondtos.CustomerInformationDto;
import com.kashif.callcentercommondtos.CustomerServicesDto;
import com.kashif.callcentercommondtos.ServiceDto;
import com.kashif.callcentercommon.entities.Customers;
import com.kashif.callcentercommon.entities.CustomersServices;
import com.kashif.customerinformationservice.dao.CustomersDao;
import com.kashif.customerinformationservice.service.CustomersService;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mostafa.kashif
 */
@Transactional
@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersDao customersDao;
    
    private static final Logger logger = Logger.getLogger(CustomersServiceImpl.class);

    @Override
    public CustomerInformationDto getCustomerById(int id) throws Exception{
        try {
            logger.debug("Starting retrieving customer with id: " + id);
            Customers customerEntity = customersDao.getCustomerById(id);
            if (customerEntity != null) {
                CustomerInformationDto customerInformation = new CustomerInformationDto(customerEntity.getId(), customerEntity.getName(), customerEntity.getSegment().getName(), customerEntity.getBalance());
                logger.debug("Successfully retrieved " + customerInformation);
                return customerInformation;
            }else {
                throw new Exception("No customer exist with id:"+id);
            }
        } catch (Exception ex) {
            logger.error("Exception while retrieving customer with id:" + id + ",ex:" + ex,ex);
            throw ex;
        }
    }

    @Override
    public CustomerServicesDto getCustomerServicesById(int id) throws Exception{
        try {
            logger.debug("Starting retrieving customer services with id: " + id);
            Customers customerEntity = customersDao.getCustomerById(id);
            CustomerServicesDto customerServicesDto = new CustomerServicesDto();
            customerServicesDto.setCustomerId(customerEntity.getId());
            ArrayList<ServiceDto> servicesDto = new ArrayList<>();
            for (CustomersServices customerService : customerEntity.getCustomersServicesSet()) {
                ServiceDto serviceDto = new ServiceDto(customerService.getServices().getId(), customerService.getServices().getCost(), customerService.getUsage().intValue(), customerService.getServices().getName());
                servicesDto.add(serviceDto);
            }
            customerServicesDto.setServices(servicesDto);
            logger.debug("Successfully retrieved " + customerServicesDto);
            return customerServicesDto;
        } catch (Exception ex) {
            logger.error("Exception while retrieving customer services with id:" + id + ",ex:" + ex,ex);
            throw ex;
        }
    }

}
