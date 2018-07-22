/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommondtos;

import java.util.ArrayList;

/**
 *
 * @author mostafa.kashif
 */
public class CustomerServicesDto {
    
    private int customerId;
    private ArrayList<ServiceDto> services;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ArrayList<ServiceDto> getServices() {
        return services;
    }

    public void setServices(ArrayList<ServiceDto> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "CustomerServicesDto{" + "customerId=" + customerId + ", services=" + services + '}';
    }
    
    
}
