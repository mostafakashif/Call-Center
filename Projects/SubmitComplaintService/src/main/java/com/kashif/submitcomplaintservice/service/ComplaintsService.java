/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.submitcomplaintservice.service;

import com.kashif.callcentercommondtos.ComplaintDto;

/**
 *
 * @author mostafa.kashif
 */
public interface ComplaintsService {
    public void addComplaint (ComplaintDto complaintDto);
}
