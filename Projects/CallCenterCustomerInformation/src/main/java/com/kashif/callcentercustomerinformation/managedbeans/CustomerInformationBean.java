/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercustomerinformation.managedbeans;

import com.kashif.callcentercommondtos.CustomerInformationDto;
import com.kashif.callcentercustomerinformation.service.RetrieveCustomerService;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author mostafa.kashif
 */
@ManagedBean
@RequestScoped
public class CustomerInformationBean {

    private static final Logger logger = Logger.getLogger(CustomerInformationBean.class);
    private CustomerInformationDto customer;
    private String complaintServiceURL;
    private RetrieveCustomerService retrieveCustomerService = new RetrieveCustomerService();
    @ManagedProperty(value = "#{paramBean}")
    private ParamBean paramBean;

    public ParamBean getParamBean() {
        return paramBean;
    }

    public void setParamBean(ParamBean paramBean) {
        this.paramBean = paramBean;
    }

    public String getComplaintServiceURL() {
        return complaintServiceURL;
    }

    public void setComplaintServiceURL(String complaintServiceURL) {
        this.complaintServiceURL = complaintServiceURL;
    }

    public CustomerInformationDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInformationDto customer) {
        this.customer = customer;
    }

    @PostConstruct
    public void init() {
        setComplaintServiceURL(getParamBean().getContextParameter("ComplaintHomePageURL"));
        customer = new CustomerInformationDto();
    }

    public void retrieveCustomerData() {
        try {
            this.customer = this.retrieveCustomerService.retrieveCustomerData(this.customer.getCustomerId());
            this.complaintServiceURL = getParamBean().getContextParameter("ComplaintSubmitPageURL") + this.customer.getCustomerId();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Customer retrieved successfully", "Customer retrieved successfully"));
        } catch (Exception ex) {
            logger.debug("Exception in retrieveCustomerData for id:" + this.customer.getCustomerId() + ",e:" + ex,ex);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  ex.getMessage(), ex.getMessage()));
        }
    }
}
