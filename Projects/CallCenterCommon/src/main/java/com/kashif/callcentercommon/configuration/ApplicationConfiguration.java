/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercommon.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author mostafa.kashif
 */
@Configuration
@ComponentScan(basePackages = "com.kashif.callcentercommon")
@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class ApplicationConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public HikariDataSource dataSource() {

        HikariConfig dataSource = new HikariConfig();
        dataSource.setDriverClassName(env.getProperty("databaseDrive"));
        dataSource.setJdbcUrl(env.getProperty("databaseUrl"));
        dataSource.setUsername(env.getProperty("databaseUsername"));
        dataSource.setPassword(env.getProperty("databasePassword"));
        HikariDataSource hikariDS = new HikariDataSource(dataSource);
        return hikariDS;
    }

    @Bean()
    public LocalSessionFactoryBean getEntityManagerFactoryBean() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.kashif.callcentercommon.entities");
        factoryBean.setHibernateProperties(additionalProperties());
        return factoryBean;
    }

    @Bean()
    public PlatformTransactionManager txManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getEntityManagerFactoryBean().getObject());
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");

        return properties;
    }
}
