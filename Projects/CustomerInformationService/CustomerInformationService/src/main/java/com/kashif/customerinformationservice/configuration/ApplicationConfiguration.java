/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.customerinformationservice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author mostafa.kashif
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kashif.customerinformationservice")
@Import(com.kashif.callcentercommon.configuration.ApplicationConfiguration.class)
public class ApplicationConfiguration {
    
}
