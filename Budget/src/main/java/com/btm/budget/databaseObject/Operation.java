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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author STEL
 */
//@Entity
@MappedSuperclass
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(
//    name="periodic",
//    discriminatorType=DiscriminatorType.INTEGER)
//@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "value", nullable = false)
    private double value;
    
    @Column(name = "factChecker", nullable = false)
    private boolean factChecker; 
    
//    @Column(name = "periodic", nullable = false)
//    private int periodic; 
    
    @Column(name = "inOrOut", nullable = false)
    private boolean inOrOut; // true for in false for out
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar date;
    
    @Column(name = "memo", length = 20)
    private String memo; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;
    
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinTable(name = "account_operation")
    @JoinColumn(name = "account_id")
    public Account account; 
    
    @Type(type="com.btm.budget.database.ColorUserType")
    @Column(name = "color")
    private DBColor color; 

    public Operation() {
    }

    public Operation(double value, boolean factChecker, int periodic, boolean inOrOut, Calendar date, String memo, Category category, SubCategory subCategory, DBColor color, int id, Account account) {
        this.value = value;
        this.factChecker = factChecker;
//        this.periodic = periodic;
        this.date = date;
        this.memo = memo;
        this.category = category;
        this.subCategory = subCategory;
        this.color = color;
        this.id = id;
        this.inOrOut = inOrOut; 
        this.account = account;
    }
    
    public Operation(double value, boolean factChecker, int periodic, boolean inOrOut, Calendar date, String memo, Category category, SubCategory subCategory, DBColor color, Account account) {
        this.value = value;
        this.factChecker = factChecker;
//        this.periodic = periodic;
        this.date = date;
        this.memo = memo;
        this.category = category;
        this.subCategory = subCategory;
        this.color = color;
        this.id = -1;
        this.inOrOut = inOrOut; 
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
        final Operation other = (Operation) obj;
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        if (this.factChecker != other.factChecker) {
            return false;
        }
//        if (this.periodic != other.periodic) {
//            return false;
//        }
        if (this.inOrOut != other.inOrOut) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.memo, other.memo)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.subCategory, other.subCategory)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public boolean isSetDB() {
        return (id != -1);
    }
    
    public boolean isInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(boolean inOrOut) {
        this.inOrOut = inOrOut;
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

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isfactChecker() {
        return factChecker;
    }

    public void setfactChecker(boolean factChecker) {
        this.factChecker = factChecker;
    }

//    public int getPeriodic() {
//        return periodic;
//    }
//
//    public void setPeriodic(int periodic) {
//        this.periodic = periodic;
//    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DBColor getColor() {
        return color;
    }

    public void setColor(DBColor color) {
        this.color = color;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    } 

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isFactChecker() {
        return factChecker;
    }

    public void setFactChecker(boolean factChecker) {
        this.factChecker = factChecker;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        return "Operation{" 
                + "value=" + value 
                + ", check=" + factChecker 
//                + ", periodic=" + periodic 
                + ", inOrOut=" + inOrOut 
                + ", date=" + date_format.format(date.getTime()) 
                + ", memo=" + memo 
                + ", category=" + category 
                + ", subCategory=" + subCategory 
                + ", color=" + color 
                + ", id=" + id 
                + '}';
    }
}
