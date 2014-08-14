/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.database;

import java.io.File;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author sdalens
 */
public class HibernateUtil {      
    //Annotation based configuration
    private static SessionFactory sessionAnnotationFactory;
 
    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            File cfgFile = new File("D:\\Users\\sdalens\\Documents\\NetBeansProjects\\BudgetOnMaven2\\Budget\\src\\main\\resources\\hibernate\\hibernate.cfg.xml");
            
            configuration.configure(cfgFile);
            System.out.println("Hibernate Annotation Configuration loaded");
             
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Annotation serviceRegistry created");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    public static SessionFactory getSessionAnnotationFactory() {
        if(sessionAnnotationFactory == null) 
            sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    } 
}