/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercustomerinformation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kashif.callcentercommondtos.CustomerInformationDto;
import com.kashif.callcentercustomerinformation.httpclients.HTTPGetClient;
import com.kashif.callcentercustomerinformation.managedbeans.ParamBean;
import com.kashif.callcentercustomerinformation.models.HTTPGetClientOutput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;



/**
 *
 * @author mostafa.kashif
 */

public class RetrieveCustomerService {

    private static final Logger logger = Logger.getLogger(RetrieveCustomerService.class);
   public ParamBean getParamBean() {
        HttpSession session = (HttpSession)  FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object bean = session.getAttribute("paramBean");
        return (ParamBean) bean;
    }

   
    public CustomerInformationDto retrieveCustomerData(int customerId) throws Exception {
        HTTPGetClientOutput clientOutput = null;
        ObjectMapper mapper = new ObjectMapper();
        try {

            clientOutput = HTTPGetClient.callHTTPGet(getParamBean().getContextParameter("CustomerInformationServicURL") + customerId);
        } catch (Exception ex) {
            logger.debug("Exception while retrieveCustomerData for id:" + customerId + ",e:" + ex,ex);
            throw new Exception("General Error!Please try again later");
        }
        switch (clientOutput.getHttpResponseCode()) {
            case 200:
                try {
                    CustomerInformationDto customerInformation = mapper.readValue(clientOutput.getOutput(), CustomerInformationDto.class);
                    return customerInformation;
                } catch (Exception ex) {
                    logger.debug("Exception while retrieveCustomerData for id:" + customerId + ",e:" + ex,ex);
                    throw new Exception("General Error!Please try again later");
                }
            case 404:
                throw new Exception("Customer id:" + customerId + " does not exist");
            case 500:
                throw new Exception("General Error!Please try again later");
            default:
                throw new Exception("General Error!Please try again later");
        }

    }
}
