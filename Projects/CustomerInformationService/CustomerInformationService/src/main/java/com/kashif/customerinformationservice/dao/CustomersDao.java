/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.customerinformationservice.dao;

import com.kashif.callcentercommon.entities.Customers;

/**
 *
 * @author mostafa.kashif
 */
public interface CustomersDao {
    public Customers getCustomerById(int id);
}
