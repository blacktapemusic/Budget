/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.databaseObject;

import com.btm.budget.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author sdalens
 */
@Entity
@Table(name = "solde",
        uniqueConstraints = 
                {   @UniqueConstraint(columnNames = {"id"}), 
                    @UniqueConstraint(columnNames = {"value"})})
public class Solde {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id; 
    
    @Column(name = "value", nullable = false)
    private double value;
//    private SmallDate date;
    
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account; 
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar date;

    public Solde() {
    }

    public Solde(double value, Calendar date, Account account) {
        this.value = value;
        this.date = date;
        this.account = account;        
        
        this.id = -1;
    }
    
    public Solde(int id, double value, Calendar date, Account account) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Solde other = (Solde) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
//        if (!Objects.equals(this.account, other.account)) {
//            return false;
//        }
        return true;
    }
    
    public boolean isSetDB() {
        return (id != -1);
    }

    @Override
    public String toString() {
        SimpleDateFormat date_format = Constants.date_format;
        return "Solde{" + "id=" + id + ", value=" + value + ", date="  + date_format.format(date.getTime()) + '}';
    } 
    
    static public class CompareSoldeByDate implements Comparator<Solde>
    {
        @Override
        public int compare(Solde o1, Solde o2) {
            return o1.getDate().compareTo(o2.getDate()); 
        }
    }
}

