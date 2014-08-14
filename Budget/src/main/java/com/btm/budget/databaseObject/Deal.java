/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.databaseObject;

import com.btm.budget.database.DBColor;
import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author sdalens
 */
@Entity
@Table(name = "operation")
//@DiscriminatorValue("0")
public class Deal extends Operation{
    public Deal() {
        super(); 
    }  
    
    public Deal(String name, double value, boolean factChecker, int periodic, boolean inOrOut, Calendar date, String memo, Category category, SubCategory subCategory, DBColor color, int id, Account account) {
        super(name, value, factChecker, periodic, inOrOut, date, memo, category, subCategory, color, id, account);
    }
    
    public Deal(String name, double value, boolean factChecker, int periodic, boolean inOrOut, Calendar date, String memo, Category category, SubCategory subCategory, DBColor color, Account account) {
        super(name, value, factChecker, periodic, inOrOut, date, memo, category, subCategory, color, account);
    }
}
