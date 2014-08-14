///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.btm.budget;
//
//import java.util.List;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author STEL
// */
//public class DatabaseHTest {
//    
//    public DatabaseHTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getSessionFactory method, of class DatabaseH.
//     */
//    @Test
//    public void testGetSessionFactory() {
//        System.out.println("getSessionFactory");
//        
//        SessionFactory sessionFactory = DatabaseH.getSessionFactory();
//        
//        Session session = sessionFactory.openSession(); 
//        Transaction tx = session.beginTransaction(); 
//        
//        Category category1 = new Category("Journalière"); 
//        Category category2 = new Category("Journalière"); 
//        
//        session.save(category1);
//        session.save(category2);
//        
//        session.flush();
//        tx.commit();
//        
//        List<Category> categoryList = session.createQuery("from Category").list();
//        
//        for(Category category : categoryList)
//        {
//            System.out.println(category);
//        }
//        
//        session.close();
//    }
//}
