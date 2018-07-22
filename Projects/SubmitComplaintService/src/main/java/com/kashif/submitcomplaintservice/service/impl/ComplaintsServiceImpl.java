/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.submitcomplaintservice.service.impl;

import com.kashif.callcentercommondtos.ComplaintDto;
import com.kashif.callcentercommon.entities.Complaint;
import com.kashif.callcentercommon.entities.Customers;
import com.kashif.callcentercommon.entities.Services;
import com.kashif.submitcomplaintservice.dao.ComplaintsDao;
import com.kashif.submitcomplaintservice.service.ComplaintsService;
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
public class ComplaintsServiceImpl implements ComplaintsService {

    @Autowired
    private ComplaintsDao complaintsDao;

    private static final Logger logger = Logger.getLogger(ComplaintsServiceImpl.class);

    @Override
    public void addComplaint(ComplaintDto complaintDto) {
        try {
            logger.debug("Starting adding " + complaintDto);
            Complaint complaintEntity = new Complaint();
            complaintEntity.setDescription(complaintDto.getDescription());
            complaintEntity.setCustomerId(new Customers(complaintDto.getCustomerId()));
            complaintEntity.setServiceId(new Services(complaintDto.getServiceId()));
            complaintsDao.addComplaint(complaintEntity);
            logger.debug("Complaint added with id:" + complaintEntity.getComplaintId());
        } catch (Exception ex) {
            logger.error("Exception while adding complaintDto:" + ex,ex);
            throw ex;
        }
    }

}
