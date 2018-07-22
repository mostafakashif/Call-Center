/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommondtos;

import java.io.Serializable;

/**
 *
 * @author mostafa.kashif
 */
public class ComplaintDto implements Serializable{
    private int customerId;
    private int serviceId;
    private String description;

    @Override
    public String toString() {
        return "ComplaintDto{" + "customerId=" + customerId + ", serviceId=" + serviceId + ", description=" + description + '}';
    }

    
    public ComplaintDto() {}
    public ComplaintDto(int customerId, int serviceId, String description) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.description = description;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
