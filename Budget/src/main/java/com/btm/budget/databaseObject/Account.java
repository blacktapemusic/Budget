/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.databaseObject;

import com.btm.budget.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transaction;

/**
 *
 * @author STEL
 */
@Entity
@Table(name = "account")
public class Account {  
//    private double lastMonthSolde; 
//    private SmallDate date; 
//    int firstDayOfMonth = 1; 
    
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
//    @OrderBy("date")
//    private List<Operation> operationList; 
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    @OrderBy("date")
    private List<Deal> dealList; 
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name="operation_id", referencedColumnName="account_id")
    @OrderBy("date")
    private List<ForecastDeal> forecastDealList; 
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    @OrderBy("date")
    private List<Solde> soldeList; 
    
    public Account() {
//        operationList = new ArrayList<Operation>();
//        dealList = new ArrayList<Deal>();
        soldeList = new ArrayList<Solde>();
    }
    
    public Account(String name) {
//        dealList = new ArrayList<Deal>();
//        operationList = new ArrayList<Operation>();
        soldeList = new ArrayList<Solde>();
        
        id = -1; 
        this.name = name;
    }
    
    public Account(int id, String name) {
//        dealList = new ArrayList<Deal>();
//        operationList = new ArrayList<Operation>();
        soldeList = new ArrayList<Solde>();
        
        this.id = id;
    }
    
    public Solde getMonthSolde() {
        soldeList.sort(new Solde.CompareSoldeByDate());
        return soldeList.get(soldeList.size() - 1);
    }

    public void setMonthSolde(Solde thisMonthSolde) {
        soldeList.sort(new Solde.CompareSoldeByDate());
        if(soldeList.get(soldeList.size() - 1).getDate() == Calendar.getInstance())
        {
            soldeList.get(soldeList.size() - 1).setValue(thisMonthSolde.getValue());
        }
        else 
        {
            soldeList.add(thisMonthSolde);
        }
    }

//    public List<Operation> getOperationList() {
//        return operationList;
//    }
//
//    public void setOperationList(List<Operation> operationList) {
//        this.operationList = operationList;
//    }
    
//    public void addOperation(Operation operation)
//    {
//        operationList.add(operation); 
//    }
//    
//    public boolean deleteOperation(Operation operation)
//    {
//        return operationList.remove(operation); 
//    }
//    
//    public boolean deleteOperation(int id)
//    {
//        Iterator it = operationList.iterator();
//        Operation operation; 
//        
//        while(it.hasNext())
//        {
//            operation = (Operation) it.next();
//            
//            if(operation.getId() == id)
//                return deleteOperation(operation); 
//        }
//        
//        return false; 
//    }
//    
//    public boolean containOperation(int id)
//    {
//        Iterator it = operationList.iterator();
//        Operation operation; 
//        
//        while(it.hasNext())
//        {
//            operation = (Operation) it.next();
//            
//            if(operation.getId() != id) 
//            {
//                return true;
//            }
//        }
//        return false; 
//    }
//    
//    public void deleteAllOperations()
//    {
//        operationList.clear();
//    }
//    
//    public double getSolde()
//    {
//        double solde = 0;
//        Iterator it = operationList.iterator();
//        Operation operation; 
//        
//        
//        while(it.hasNext())
//        {
//            operation = (Operation) it.next();
//            
//            solde += operation.getValue()*(operation.isInOrOut() == true ? 1 : -1);
//        }
//        
//        return solde; 
//    }
    
//    public double getSoldePeriod(SmallDate date)
//    {
//        double solde = lastMonthSolde;
//        Iterator it = operationList.iterator();
//        Operation operation; 
//        
//        
//        
//        
//        if(date.after(new Date()))
//        {
//            while(it.hasNext())
//            {
//                operation = (Operation) it.next();
//
//                solde += operation.getValue()*(operation.isInOrOut() == true ? 1 : -1);
//            }
//
//            return solde; 
//        }
//        return 0; 
//    }
//    
//        
//    public void update(SmallDate date)
//    {
//        
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isSetDB() {
        return (id != -1);
    }
    
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + /*", operationList=" + operationList +*/ ", soldeList=" + soldeList + '}';
    }
    
    public List<Solde> getSoldeList() {
        return soldeList;
    }

    public void setSoldeList(List<Solde> soldeList) {
        this.soldeList = soldeList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
//        if (!Objects.equals(this.operationList, other.operationList)) {
//            return false;
//        }
        if (!Objects.equals(this.soldeList, other.soldeList)) {
            return false;
        }
        return true;
    }

    public List<Deal> getDealList() {
        return dealList;
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList = dealList;
    }

    public List<ForecastDeal> getForecastDealList() {
        return forecastDealList;
    }

    public void setForecastDealList(List<ForecastDeal> forecastDealList) {
        this.forecastDealList = forecastDealList;
    }

    public double getSoldeAtFirstOfMonth(Calendar date)
    {
        Iterator it = soldeList.iterator();
        Solde solde;
        Calendar firstOfTheMonthDate = date; 
        firstOfTheMonthDate.set(Calendar.DAY_OF_MONTH, 1);
        
        System.out.println("firstOfTheMonthDate"+Constants.date_format.format(firstOfTheMonthDate.getTime()));
        
        while(it.hasNext())
        {
            solde = (Solde) it.next();
            
            System.out.println("getSoldeAtFirstOfMonth" + solde);
            if(solde.getDate().equals(firstOfTheMonthDate))
                return solde.getValue();
        }
        
        System.out.println("getSoldeAtFirstOfMonth no value found");
        
        // TODO Gerer erreur de non presence du solde
        return 0;
    }
    
    public double getSolde() {
        // TODO gerer l'erreur = 0
        Calendar firstOfTheMonthDate = Calendar.getInstance(); 
        firstOfTheMonthDate.set(Calendar.DAY_OF_MONTH, 1);
        
        return getSoldePeriod(firstOfTheMonthDate); 
    }
    
    public double getSoldePeriod(Calendar date)
    {
        double solde = getSoldeAtFirstOfMonth(date);
//        Iterator it = dealList.iterator();
//        Operation operation; 
//        
//        if(date.after(new Date()))
//        {
//            while(it.hasNext())
//            {
//                operation = (Operation) it.next();
//
//                solde += operation.getValue()*(operation.isInOrOut() == true ? 1 : -1);
//            }
//
//            return solde; 
//        }
        return solde; 
    }
}
