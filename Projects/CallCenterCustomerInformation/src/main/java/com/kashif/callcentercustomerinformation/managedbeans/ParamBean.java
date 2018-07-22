/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercustomerinformation.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mostafa.kashif
 */
@ManagedBean(name ="paramBean" )
@SessionScoped
public class ParamBean {

    public String getContextParameter(String parameterName) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String parameterValue = ctx.getExternalContext().getInitParameter(parameterName);
        return parameterValue;
    }
}
