/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import com.btm.budget.database.HibernateUtil;
import com.btm.budget.databaseObject.Account;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.Session;

/**
 *
 * @author sdalens
 */
public class Core {
    private static List<Account> accountList; 
    private static Core Instance = new Core();
    
    private Core()
    {
        accountList = new ArrayList<Account>();
    }
    
    public static Core getInstance()
    {
        return Instance;
    }
    
    public static void loadAllAccount()
    {
        //Get Session
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        
//        session.load(accountList);
        accountList = session.createCriteria(Account.class).list();
        
        System.out.println("accountList " + accountList);
        
        //Commit transaction
//        session.getTransaction().commit();
        
        
//        session.load(this, session);
        //terminate session factory, otherwise program won't end
        //session.close();
    }

    public static List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
