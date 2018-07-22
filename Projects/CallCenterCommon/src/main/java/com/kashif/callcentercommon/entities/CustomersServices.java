/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mostafa.kashif
 */
@Entity
@Table(name = "CUSTOMERS_SERVICES")
@NamedQueries({
    @NamedQuery(name = "CustomersServices.findAll", query = "SELECT c FROM CustomersServices c")})
public class CustomersServices implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomersServicesPK customersServicesPK;
    @Basic(optional = false)
    @Column(name = "USAGE")
    private BigInteger usage;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Customers customers;
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Services services;

    public CustomersServices() {
    }

    public CustomersServices(CustomersServicesPK customersServicesPK) {
        this.customersServicesPK = customersServicesPK;
    }

    public CustomersServices(CustomersServicesPK customersServicesPK, BigInteger usage) {
        this.customersServicesPK = customersServicesPK;
        this.usage = usage;
    }

    public CustomersServices(BigInteger customerId, BigInteger serviceId) {
        this.customersServicesPK = new CustomersServicesPK(customerId, serviceId);
    }

    public CustomersServicesPK getCustomersServicesPK() {
        return customersServicesPK;
    }

    public void setCustomersServicesPK(CustomersServicesPK customersServicesPK) {
        this.customersServicesPK = customersServicesPK;
    }

    public BigInteger getUsage() {
        return usage;
    }

    public void setUsage(BigInteger usage) {
        this.usage = usage;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customersServicesPK != null ? customersServicesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomersServices)) {
            return false;
        }
        CustomersServices other = (CustomersServices) object;
        if ((this.customersServicesPK == null && other.customersServicesPK != null) || (this.customersServicesPK != null && !this.customersServicesPK.equals(other.customersServicesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kashif.callcentercommon.entities.CustomersServices[ customersServicesPK=" + customersServicesPK + " ]";
    }

}
