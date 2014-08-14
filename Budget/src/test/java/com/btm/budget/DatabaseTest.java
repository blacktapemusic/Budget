/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import java.awt.Color;
import static java.awt.Color.black;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
    }
    
    @Before
    public void setUp() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Database instance = new Database();
        instance.dropAllTable();
        instance.initDB();
    }
    
    @After
    public void tearDown() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Database instance = new Database();
        instance.closeConnexion();
    }

    /**
     * Test of insertOperation method, of class Database.
     * @throws java.lang.Exception
     */
    @Test
    public void testDB() throws Exception {
//        System.out.println("insertOperation" + new Date());
//        
//        SmallDate date = new SmallDate(new Date());
//        Color color = black; 
//        Category category1 = new Category("Mensuel"); 
//        SubCategory subCategory1 = new SubCategory("Loyer"); 
//        Category category2 = new Category("Exceptionnel"); 
//        SubCategory subCategory2 = new SubCategory("Voyage"); 
//        double value1 = 50.1; 
//        double value2 = 1111; 
//        
//        Account account = new Account("CCP");
//        
//        Database instance = new Database();
//        
//        // test account 
//        instance.insertAccount(account);
//        assertTrue(account.isSetDB());
//        
//        Solde solde1 = new Solde(value1, date, account.getId());
//        Solde solde2 = new Solde(value2, date, account.getId());
//        
//        Operation operation1 = new Operation(value1, true, true, true, date, "Test", category1, subCategory1, color, account.getId());
//        Operation operation2 = new Operation(value1, true, true, false, date, "Test", category2, subCategory2, color, account.getId());
//        Operation operation3 = new Operation(value2, true, true, false, date, "Test", category1, subCategory2, color, account.getId());
//        
//        List<Operation> operationList = new ArrayList<Operation>();
//        
//        // test 
//        instance.insertSubCategory(subCategory1);
//        instance.insertSubCategory(subCategory2);
//        
//        assertTrue(subCategory1.isSetDB());
//        assertTrue(subCategory2.isSetDB());
//        
//        
//        // test
//        instance.insertCategory(category1);
//        instance.insertCategory(category2);
//        
//        assertTrue(category1.isSetDB());
//        assertTrue(category2.isSetDB());
//        
//        // test
//        instance.insertOperation(operation1);
//        instance.insertOperation(operation2);
//        instance.insertOperation(operation3);
//        
//        assertTrue(operation1.isSetDB());
//        assertTrue(operation2.isSetDB());
//        assertTrue(operation3.isSetDB());
//        
//        //test
//        SubCategory subCategory3 = new SubCategory("Loisir");
//        instance.insertSubCategory(subCategory3);
//        
//        Category category3 = new Category("Semestrielle"); 
//        instance.insertCategory(category3);
//        
//        operation3.setCategory(category3);
//        operation3.setSubCategory(subCategory3);
//        
//        instance.updateOperation(operation3);
//        
//        // test getSubCategory
//        assertTrue(subCategory1.equals(instance.getSubCategory(subCategory1.getId())));
//        
//        // test
//        subCategory1.setSubCategory("Vitale");
//        instance.updateSubCategory(subCategory1);
//        
//        // test getSubCategory
//        assertTrue(subCategory1.equals(instance.getSubCategory(subCategory1.getId())));
//        
//        // test getCategory
//        assertTrue(category1.equals(instance.getCategory(category1.getId())));
//        
//        // test
//        category1.setCategory("Prevision");
//        instance.updateCategory(category1);
//        
//        // test getCategory
//        assertTrue(category1.equals(instance.getCategory(category1.getId())));
//        
//        //test
//        instance.deleteOperation(operation2);
//        
//        assertFalse(operation2.isSetDB());
//        
//        //test
//        instance.deleteCategory(category2);
//        
//        assertFalse(category2.isSetDB());
//        
//        //test
//        instance.deleteSubCategory(subCategory2);
//        
//        assertFalse(subCategory2.isSetDB());
//        
//        // test getOperation 
//        operationList = instance.getOperationList(date);
//        
//        assertTrue(operationList.contains(operation1));
//        assertFalse(operationList.contains(operation2));
//        assertTrue(operationList.contains(operation3));
//        
//        
//        // test solde 
//        instance.insertSolde(solde1);
//        instance.insertSolde(solde2);
//        
//        assertTrue(solde1.isSetDB());
//        assertTrue(solde2.isSetDB());
//        
//        // test 
//        solde1.setValue(value2);
//        instance.updateSolde(solde1);
//        
//        System.out.println("Solde " + solde1);
//        System.out.println("instance.getSolde(date) " + instance.getSolde(date));
//        assertTrue(solde1.equals(instance.getSolde(date)));
//        
//        instance.deleteSolde(solde2);
//        
//        assertFalse(solde2.isSetDB());
    }
    
}
