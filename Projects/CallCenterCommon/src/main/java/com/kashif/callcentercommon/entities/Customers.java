/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommon.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mostafa.kashif
 */
@Entity
@Table(name = "CUSTOMERS")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "BALANCE")
    private Double balance;
    @JoinColumn(name = "SEGMENT", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private SegmentsLk segment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers",fetch = FetchType.EAGER)
    private Set<CustomersServices> customersServicesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId",fetch = FetchType.EAGER)
    private Set<Complaint> customersComplaintsSet;

    public Customers() {
    }

    public Customers(Integer id) {
        this.id = id;
    }

    public Customers(Integer id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public SegmentsLk getSegment() {
        return segment;
    }

    public void setSegment(SegmentsLk segment) {
        this.segment = segment;
    }

    public Set<CustomersServices> getCustomersServicesSet() {
        return customersServicesSet;
    }

    public void setCustomersServicesSet(Set<CustomersServices> customersServicesSet) {
        this.customersServicesSet = customersServicesSet;
    }
    public Set<Complaint> getCustomersComplaintsSet() {
        return customersComplaintsSet;
    }

    public void setCustomersComplaintsSet(Set<Complaint> customersComplaintsSet) {
        this.customersComplaintsSet = customersComplaintsSet;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kashif.callcentercommon.entities.Customers[ id=" + id + " ]";
    }
    
}
