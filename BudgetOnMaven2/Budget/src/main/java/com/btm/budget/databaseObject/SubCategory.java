/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.databaseObject;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author STEL
 */
@Entity
@Table(name = "subCategory",
        uniqueConstraints = 
                {   @UniqueConstraint(columnNames = {"id"}), 
                    @UniqueConstraint(columnNames = {"value"})})
public class SubCategory {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id; 
    
    @Column(name = "value", nullable = false, unique = true, length = 20)
    private String subCategory;

    public SubCategory() {
    }
    
    public SubCategory(int id, String category) {
        this.id = id;
        this.subCategory = category;
    }

    public SubCategory(String category) {
        this.id = -1;
        this.subCategory = category;
    }

    public boolean isSetDB() {
        return (id != -1);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String category) {
        this.subCategory = category;
    }

    @Override
    public String toString() {
        return "SubCategory{" + "id=" + id + ", subCategory=" + subCategory + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubCategory other = (SubCategory) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.subCategory, other.subCategory)) {
            return false;
        }
        return true;
    }
}
