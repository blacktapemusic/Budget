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
@Table(name = "category",
        uniqueConstraints = 
                {   @UniqueConstraint(columnNames = {"id"}), 
                    @UniqueConstraint(columnNames = {"value"})})
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id; 
    
    @Column(name = "value", nullable = false, unique = true, length = 20)
    private String category;

    public Category() {
    }

    public Category(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category(String category) {
        this.id = -1;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", category=" + category + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }
}
