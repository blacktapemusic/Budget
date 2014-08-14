/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.databaseObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author STEL
 */
public class Project {
    private List<Operation> operationList; 
    private Calendar date; 
    private double budgetNeedForProject;
    private double budgetAlreadySaveForProject;
    private String name;

    public Project(Calendar date, double budgetNeedForProject, String name) {
        this.date = date;
        this.budgetNeedForProject = budgetNeedForProject;
        this.name = name; 
        operationList = new ArrayList<Operation>();
    }
    
    private double getBudgetForAllOperation()
    {
        Iterator it = operationList.iterator();
        double budget = 0; 
        Operation operation;
        
        while(it.hasNext())
        {
            operation = (Operation) it.next();
            budget += operation.getValue(); 
        }
        
        return budget; 
    }
    
    public boolean addOperation(Operation operation)
    {
        if(budgetNeedForProject - getBudgetForAllOperation() <= operation.getValue())
            return false;
        
        operationList.add(operation); 
        return true; 
    }
    
    public boolean addAndUpdateBudget(Operation operation, double budget)
    {
        if(budget - getBudgetForAllOperation() <= operation.getValue())
            return false;
        
        this.budgetNeedForProject = budget;
        operationList.add(operation); 
        
        return true;
    }
    
    public void addAndUpdateBudget(Operation operation)
    {   
        this.budgetNeedForProject += operation.getValue();
        operationList.add(operation); 
    }
    
    // calcul de somme moyenne a mettre
    public void saveMoney(double inCome)
    {
        budgetAlreadySaveForProject = inCome; 
    }
    
    public double getMoneyNeedToSaveByMonth()
    {
        double monthRemining = date.get(Calendar.MONTH) - Calendar.getInstance().get(Calendar.MONTH);
        
        return (budgetNeedForProject - budgetAlreadySaveForProject) / monthRemining;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public double getBudgetNeedForProject() {
        return budgetNeedForProject;
    }

    public void setBudgetNeedForProject(double budgetNeedForProject) {
        this.budgetNeedForProject = budgetNeedForProject;
    }

    public double getBudgetAlreadySaveForProject() {
        return budgetAlreadySaveForProject;
    }

    public void setBudgetAlreadySaveForProject(double budgetAlreadySaveForProject) {
        this.budgetAlreadySaveForProject = budgetAlreadySaveForProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
