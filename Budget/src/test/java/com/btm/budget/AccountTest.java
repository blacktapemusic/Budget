/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import java.awt.Color;
import static java.awt.Color.black;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author STEL
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOperation method, of class Account.
     */
//    @Test
//    public void testAddOperation() {
//        System.out.println("addOperation");
//        
//        SmallDate date = new SmallDate(new Date());
//        Color color = black; 
//        Category category = null;
//        SubCategory subCategory = null;  
//        double value = 50.1; 
//        
//        Account account = new Account("CPP");
//        
//        Operation operation = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 0, account.getId());
//        
//        assertFalse(account.getOperationList().contains(operation));
//        
//        account.addOperation(operation);
//        
//        assertTrue(account.getOperationList().contains(operation));
//    }
//
//    /**
//     * Test of deleteOperation method, of class Account.
//     */
//    @Test
//    public void testDeleteOperation_Operation() {
//        System.out.println("testDeleteOperation_Operation");
//        
//        SmallDate date = new SmallDate(new Date());
//        Color color = black; 
//        Category category = null; 
//        SubCategory subCategory = null; 
//        double value = 50.1; 
//        
//        Account account = new Account("CPP");
//        
//        Operation operation1 = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 0, account.getId());
//        Operation operation2 = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 2, account.getId());
//        
//        account.addOperation(operation1);
//        
//        assertTrue(account.getOperationList().contains(operation1));
//        
//        assertFalse(account.deleteOperation(operation2));
//        
//        account.addOperation(operation2);
//        
//        assertTrue(account.getOperationList().contains(operation2));
//        assertTrue(account.deleteOperation(operation2));
//        
//        assertTrue(account.getOperationList().contains(operation1));
//        assertFalse(account.getOperationList().contains(operation2));
//        
//        assertTrue(account.deleteOperation(operation1));
//        
//        assertFalse(account.getOperationList().contains(operation1));
//        assertFalse(account.getOperationList().contains(operation2));
//    }
//
//    /**
//     * Test of deleteOperation method, of class Account.
//     */
//    @Test
//    public void testDeleteOperation_int() {
//        System.out.println("deleteOperation");
//        
//        SmallDate date = new SmallDate(new Date());
//        Color color = black; 
//        Category category = null; 
//        SubCategory subCategory = null; 
//        double value = 50.1; 
//        
//        Account account = new Account("CPP");
//        
//        Operation operation = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 0, account.getId());
//        
//        account.addOperation(operation);
//        
//        assertTrue(account.getOperationList().contains(operation));
//        
//        assertFalse(account.deleteOperation(1));
//        
//        assertTrue(account.getOperationList().contains(operation));
//        
//        assertTrue(account.deleteOperation(0));
//        
//        assertFalse(account.getOperationList().contains(operation));
//    }
//
//    /**
//     * Test of deleteAllOperation method, of class Account.
//     */
//    @Test
//    public void testDeleteAllOperation() {
//        System.out.println("deleteAllOperation");
//        
//        SmallDate date = new SmallDate(new Date());
//        Color color = black; 
//        Category category = null; 
//        SubCategory subCategory = null; 
//        double value = 50.1; 
//        
//        Account account = new Account("CPP");
//        
//        Operation operation1 = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 0, account.getId());
//        Operation operation2 = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 2, account.getId());
//        
//        account.addOperation(operation1);
//        
//        assertTrue(account.getOperationList().contains(operation1));
//        
//        assertFalse(account.deleteOperation(operation2));
//        
//        account.addOperation(operation2);
//        
//        assertTrue(account.getOperationList().contains(operation2));
//        assertTrue(account.deleteOperation(operation2));
//        
//        assertTrue(account.getOperationList().contains(operation1));
//        assertFalse(account.getOperationList().contains(operation2));
//        
//        assertTrue(account.deleteOperation(operation1));
//        
//        assertFalse(account.getOperationList().contains(operation1));
//        assertFalse(account.getOperationList().contains(operation2));
//    }
//    
//    /**
//     * Test of deleteAllOperation method, of class Account.
//     */
//    @Test
//    public void testContainOperation()
//    {
//        System.out.println("containOperation");
//        
//        SmallDate date = new SmallDate(new Date());
//        Color color = black; 
//        Category category = null; 
//        SubCategory subCategory = null; 
//        double value = 50.1; 
//        
//        Account account = new Account("CPP"); 
//        
//        Operation operation1 = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 0, account.getId());
//        Operation operation2 = new Operation(value, true, true, true, date, "Test", category, subCategory, color, 2, account.getId());
//        
//        account.addOperation(operation1);
//        
//        assertEquals(1, account.getOperationList().size());
//        
//        account.deleteAllOperations();
//        
//        assertEquals(0, account.getOperationList().size());
//        
//        account.addOperation(operation1);
//        account.addOperation(operation2);
//        
//        assertEquals(2, account.getOperationList().size());
//        
//        account.deleteAllOperations();
//        
//        assertEquals(0, account.getOperationList().size());
//    }
//    
//    @Test
//    public void testGetSolde()
//    {
//        System.out.println("getSolde");
//        
//        SmallDate date = new SmallDate(new Date());
//        Color color = black; 
//        Category category = null; 
//        SubCategory subCategory = null; 
//        double value1 = 50.1; 
//        double value2 = 1111; 
//        
//        Account account = new Account("CPP"); 
//        
//        Operation operation1 = new Operation(value1, true, true, true, date, "Test", category, subCategory, color, 0, account.getId());
//        Operation operation2 = new Operation(value1, true, true, false, date, "Test", category, subCategory, color, 2, account.getId());
//        Operation operation3 = new Operation(value2, true, true, false, date, "Test", category, subCategory, color, 4, account.getId());
//        
//        account.addOperation(operation1);
//        
//        assertEquals(value1, account.getSolde(), 0);
//        
//        account.addOperation(operation2);
//        
//        assertEquals(0, account.getSolde(), 0);
//        
//        account.addOperation(operation3);
//        
//        assertEquals(-value2, account.getSolde(), 0);
//    }
}
