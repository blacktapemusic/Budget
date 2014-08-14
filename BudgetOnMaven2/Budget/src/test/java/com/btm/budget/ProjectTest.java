/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import java.awt.Color;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author STEL
 */
public class ProjectTest {
    
    public ProjectTest() {
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
     * Test of addOperation method, of class Project.
     */
    @Test
    public void testAddOperation() {
//        System.out.println("addOperation");
//        
//        SmallDate date = new SmallDate();
//        Category category = new Category("Vacances");
//        SubCategory subcategory = new SubCategory("Voyage");
//        Account account = new Account("CPP");
//        
//        Operation operation1 = new Operation(200, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        Operation operation2 = new Operation(700, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        Operation operation3 = new Operation(2000, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        
//        double budgetNeedForProject = 1000; 
//        SmallDate budgetDate = new SmallDate();
//        Project instance = new Project(budgetDate, budgetNeedForProject, "Vacances");
//        
//        assertFalse(instance.addOperation(operation3));
//        assertTrue(instance.addOperation(operation1));
//        assertTrue(instance.addOperation(operation2));
//        assertFalse(instance.addOperation(operation1));
//        assertFalse(instance.addOperation(operation3));
    }

    /**
     * Test of addAndUpdateBudget method, of class Project.
     */
    @Test
    public void testAddAndUpdateBudget_Operation_double() {
//        System.out.println("addAndUpdateBudget");
//        
//        SmallDate date = new SmallDate();
//        
//        Category category = new Category("Vacances");
//        SubCategory subcategory = new SubCategory("Voyage");
//        Account account = new Account("CPP");
//        
//        Operation operation1 = new Operation(2000, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        Operation operation2 = new Operation(3000, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        
//        double budgetNeedForProject1 = 1000; 
//        SmallDate budgetDate = new SmallDate();
//        Project instance = new Project(budgetDate, budgetNeedForProject1, "Vacances");
//        
//        double budgetNeedForProject2 = 1500; 
//        double budgetNeedForProject3 = 2500; 
//        double budgetNeedForProject4 = 4000; 
//        
//        assertFalse(instance.addAndUpdateBudget(operation1, budgetNeedForProject2)); 
//        assertTrue(instance.addAndUpdateBudget(operation1, budgetNeedForProject3)); 
//        assertFalse(instance.addAndUpdateBudget(operation2, budgetNeedForProject3)); 
//        assertFalse(instance.addAndUpdateBudget(operation2, budgetNeedForProject4)); 
    }

    /**
     * Test of addAndUpdateBudget method, of class Project.
     */
    @Test
    public void testAddAndUpdateBudget_Operation() {
//        System.out.println("addAndUpdateBudget");
//
//        SmallDate date = new SmallDate();
//        
//        Category category = new Category("Vacances");
//        SubCategory subcategory = new SubCategory("Voyage");
//        Account account = new Account("CPP");
//        
//        Operation operation1 = new Operation(2000, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        Operation operation2 = new Operation(3000, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        
//        double budgetNeedForProject1 = 1000; 
//        SmallDate budgetDate = new SmallDate();
//        Project instance = new Project(budgetDate, budgetNeedForProject1, "Vacances");
//        
//        instance.addAndUpdateBudget(operation1);
//        assertTrue(budgetNeedForProject1+2000 == instance.getBudgetNeedForProject()); 
//
//        instance.addAndUpdateBudget(operation2); 
//        
//        assertTrue(budgetNeedForProject1+5000 == instance.getBudgetNeedForProject()); 
    }

    /**
     * Test of getMoneyNeedToSaveByMonth method, of class Project.
     */
    @Test
    public void testGetMoneyNeedToSaveByMonth() {
//        System.out.println("getMoneyNeedToSaveByMonth");
//        
//                SmallDate date = new SmallDate();
//        
//        Category category = new Category("Vacances");
//        SubCategory subcategory = new SubCategory("Voyage");
//        Account account = new Account("CPP");
//        
//        Operation operation1 = new Operation(2000, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        Operation operation2 = new Operation(3000, true, false, false, date, null, category, subcategory, Color.yellow, account.getId());
//        
//        double budgetNeedForProject1 = 1000; 
//        SmallDate budgetDate = new SmallDate();
//        budgetDate.setMonth(budgetDate.getMonth()+5);
//        Project instance = new Project(budgetDate, budgetNeedForProject1, "Vacances");
//        
//        assertTrue(instance.getMoneyNeedToSaveByMonth() == budgetNeedForProject1/5);
//
//        double saveMoney = 200; 
//        instance.saveMoney(saveMoney); 
//        
//        assertTrue(instance.getMoneyNeedToSaveByMonth() == (budgetNeedForProject1-200)/5);
    }

    /**
     * Test of getBudgetNeedForProject method, of class Project.
     */
    @Test
    public void testGetBudgetNeedForProject() {
//        System.out.println("getBudgetNeedForProject");
//        Project instance = null;
//        double expResult = 0.0;
//        double result = instance.getBudgetNeedForProject();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setBudgetNeedForProject method, of class Project.
     */
    @Test
    public void testSetBudgetNeedForProject() {
//        System.out.println("setBudgetNeedForProject");
//        double budgetNeedForProject = 0.0;
//        Project instance = null;
//        instance.setBudgetNeedForProject(budgetNeedForProject);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getBudgetAlreadySaveForProject method, of class Project.
     */
    @Test
    public void testGetBudgetAlreadySaveForProject() {
//        System.out.println("getBudgetAlreadySaveForProject");
//        Project instance = null;
//        double expResult = 0.0;
//        double result = instance.getBudgetAlreadySaveForProject();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setBudgetAlreadySaveForProject method, of class Project.
     */
    @Test
    public void testSetBudgetAlreadySaveForProject() {
//        System.out.println("setBudgetAlreadySaveForProject");
//        double budgetAlreadySaveForProject = 0.0;
//        Project instance = null;
//        instance.setBudgetAlreadySaveForProject(budgetAlreadySaveForProject);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }  
}
