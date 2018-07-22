/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.customerinformationservice.dao.impl;

import com.kashif.callcentercommon.entities.Customers;
import com.kashif.customerinformationservice.dao.CustomersDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mostafa.kashif
 */
@Repository
public class CustomersDaoImpl implements CustomersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Customers getCustomerById(int id) {
        return sessionFactory.getCurrentSession().get(Customers.class, id);
    }

}
