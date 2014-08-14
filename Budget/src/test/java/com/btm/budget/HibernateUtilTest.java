/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import com.btm.budget.database.DBColor;
import com.btm.budget.database.HibernateUtil;
import com.btm.budget.databaseObject.Account;
import com.btm.budget.databaseObject.Category;
import com.btm.budget.databaseObject.Deal;
import com.btm.budget.databaseObject.ForecastDeal;
import com.btm.budget.databaseObject.Operation;
import com.btm.budget.databaseObject.Solde;
import com.btm.budget.databaseObject.SubCategory;
import java.sql.SQLException;
import java.util.Calendar;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sdalens
 */
public class HibernateUtilTest{
    
    public HibernateUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
     * Test of getSessionFactory method, of class HibernateUtil.
     */
    @Test
    public void HibernateUtilsTest() {
        
         
        //Get Session
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        
        Category category1 = new Category("Hebdomadaire");
//        //Save the Model object
        session.save(category1);
//        //Commit transaction
//        session.getTransaction().commit();
        System.out.println("category1 ID="+category1.getId());
        
        Category category2 = new Category("Mensuel");
//        //Save the Model object
        session.save(category2);
//        //Commit transaction
//        session.getTransaction().commit();
        System.out.println("category2 ID="+category2.getId());
         
        SubCategory subCategory1 = new SubCategory("Blabla");
//        //Save the Model object
        session.save(subCategory1);
//        //Commit transaction 
//        session.getTransaction().commit();
        System.out.println("subCategory1 ID="+subCategory1.getId());
        
        SubCategory subCategory2 = new SubCategory("Miaou");
//        //Save the Model object
        session.save(subCategory2);
//        //Commit transaction
//        session.getTransaction().commit();
        System.out.println("subCategory2 ID="+subCategory2.getId());
        
        Account account1 = new Account("CPP"); 
        //Save the Model object
        session.save(account1);
        //Commit transaction
//        session.getTransaction().commit();
        System.out.println("account ID="+account1.getId());

        Account account2 = new Account("Livret A"); 
        //Save the Model object
        session.save(account2);
        //Commit transaction
//        session.getTransaction().commit();
        System.out.println("account ID="+account1.getId());
        
        Calendar date1 = Calendar.getInstance(); 
        
        Calendar date2 = Calendar.getInstance(); 
        date2.add(Calendar.MONTH, 2);
        
        double value1 = 500; 
        double value2 = 1500; 
        double value3 = 400; 
        
        Calendar firstOfTheMonthDate1 = date1; 
        firstOfTheMonthDate1.set(Calendar.DAY_OF_MONTH, 1);
        
        Solde solde1 = new Solde(value1, firstOfTheMonthDate1, account1); 
        //Save the Model object
        session.save(solde1);
        
        System.out.println("solde1 ID="+solde1.getId());
        
        Calendar firstOfTheMonthDate2 = date2; 
        firstOfTheMonthDate2.set(Calendar.DAY_OF_MONTH, 1);
        
        //Commit transaction
//        session.getTransaction().commit();
        Solde solde2 = new Solde(value2, firstOfTheMonthDate2, account1); 
        //Save the Model object
        session.save(solde2);
        
//        Solde solde3 = new Solde(value3, date1, account1); 
//        //Save the Model object
//        session.save(solde3);
        
        Solde solde4 = new Solde(value3, firstOfTheMonthDate1, account2); 
        //Save the Model object
        session.save(solde4);
        
        System.out.println("solde2 ID="+solde2.getId());
        
        
        Deal operation1 = new Deal("operation1", value1, true, 0, true, date1, null, category1, null, DBColor.black, account1);
        Deal operation2 = new Deal("operation2", value2, false, 1, false, date1, "Test", category2, subCategory1, DBColor.green, account1);
        //Save the Model object
        session.save(operation1);
        session.save(operation2);
        
        System.out.println("operation1 ID="+operation1.getId());
        System.out.println("operation2 ID="+operation2.getId());
        
        ForecastDeal operation3 = new ForecastDeal("ForecastDeal1", value3, true, 0, true, date1, null, category1, null, DBColor.red, account1);
//        ForecastDeal operation4 = new ForecastDeal(value2, false, 1, false, date1, "Test", category2, subCategory1, DBColor.green, account1);
        //Save the Model object
        session.save(operation3);
//        session.save(operation4);
        
        System.out.println("operation3 ID="+operation3.getId());
//        System.out.println("operation4 ID="+operation4.getId());
        
        session.flush();
        session.refresh(account1);
        
        Account account3 = (Account) session.load(Account.class, 0);
        
        System.out.println("getOperationList " + account1.getForecastDealList());
        System.out.println("getOperationList " + account3.getForecastDealList());
        
        System.out.println("getSoldeList " + account1.getSoldeList());
        System.out.println("getSoldeList " + account3.getSoldeList());
        
        //Commit transaction
        session.getTransaction().commit();
        
        
//        session.load(this, session);
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionAnnotationFactory().close();
    }
}
