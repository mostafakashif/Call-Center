/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.submitcomplaintservice.dao.impl;

import com.kashif.callcentercommon.entities.Complaint;
import com.kashif.submitcomplaintservice.dao.ComplaintsDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mostafa.kashif
 */
@Repository
public class ComplaintsDaoImpl implements ComplaintsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addComplaint(Complaint complaint) {
       
        sessionFactory.getCurrentSession().save(complaint);
    }
}
