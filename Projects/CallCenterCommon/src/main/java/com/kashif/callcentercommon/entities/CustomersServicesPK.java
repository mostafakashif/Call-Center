/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommon.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author mostafa.kashif
 */
@Embeddable
public class CustomersServicesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CUSTOMER_ID")
    private BigInteger customerId;
    @Basic(optional = false)
    @Column(name = "SERVICE_ID")
    private BigInteger serviceId;

    public CustomersServicesPK() {
    }

    public CustomersServicesPK(BigInteger customerId, BigInteger serviceId) {
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public void setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomersServicesPK)) {
            return false;
        }
        CustomersServicesPK other = (CustomersServicesPK) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kashif.callcentercommon.entities.CustomersServicesPK[ customerId=" + customerId + ", serviceId=" + serviceId + " ]";
    }
    
}
