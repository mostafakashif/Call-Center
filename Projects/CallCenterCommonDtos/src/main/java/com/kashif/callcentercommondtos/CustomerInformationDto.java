/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommondtos;

/**
 *
 * @author mostafa.kashif
 */
public class CustomerInformationDto {
    
    private Integer customerId;
    private String customerName;
    private String customerSegment;
    private Double customerBalance;

     public CustomerInformationDto(){};
    
    public CustomerInformationDto(Integer customerId, String customerName, String customerSegment, Double customerBalance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSegment = customerSegment;
        this.customerBalance = customerBalance;
    }

    
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public Double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(Double customerBalance) {
        this.customerBalance = customerBalance;
    }

    @Override
    public String toString() {
        return "CustomerInformationDto{" + "customerId=" + customerId + ", customerName=" + customerName + ", customerSegment=" + customerSegment + ", customerBalance=" + customerBalance + '}';
    }
    
    
    
}
