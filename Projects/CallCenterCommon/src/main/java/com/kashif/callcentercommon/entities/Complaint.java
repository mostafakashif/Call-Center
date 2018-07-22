/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mostafa.kashif
 */
@Entity
@Table(name = "COMPLAINT")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COMPLAINT_ID", insertable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "columnId_generator")
    @SequenceGenerator(name = "columnId_generator", sequenceName = "complaint_seq", allocationSize = 0)
    private Long complaintId;
    @Basic(optional = false)
    @Column(name = "ENTRY_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date entryDate;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Customers customerId;
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Services serviceId;

    public Complaint() {
    }

    public Complaint(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Complaint(Long complaintId, Date entryDate, String description) {
        this.complaintId = complaintId;
        this.entryDate = entryDate;
        this.description = description;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public Services getServiceId() {
        return serviceId;
    }

    public void setServiceId(Services serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "com.kashif.callcentercommon.entitiesnew.Complaint[ complaintId=" + complaintId + " ]";
    }

}
