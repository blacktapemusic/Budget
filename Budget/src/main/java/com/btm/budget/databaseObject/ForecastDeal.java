/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.databaseObject;

import com.btm.budget.database.DBColor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;

/**
 *
 * @author sdalens
 */
@Entity
@Table(name = "ForecastDeal")
//@DiscriminatorValue("1")
public class ForecastDeal extends Operation{
    public ForecastDeal() {
        super();
    }  
    
    public ForecastDeal(double value, boolean factChecker, int periodic, boolean inOrOut, Calendar date, String memo, Category category, SubCategory subCategory, DBColor color, int id, Account account) {
        super(value, factChecker, periodic, inOrOut, date, memo, category, subCategory, color, id, account);
    }
    
    public ForecastDeal(double value, boolean factChecker, int periodic, boolean inOrOut, Calendar date, String memo, Category category, SubCategory subCategory, DBColor color, Account account) {
        super(value, factChecker, periodic, inOrOut, date, memo, category, subCategory, color, account);
    }
}
