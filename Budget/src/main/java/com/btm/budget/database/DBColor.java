/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.database;

/**
 *
 * @author sdalens
 */
public enum DBColor implements PersistentEnum{
    black(1),
    blue(2),
    gray(3),
    green(4),
    orange(5),
    pink(6),        
    red(7),
    white(8),
    yellow(9);
    
    private final int id; 
    
    DBColor(int id)
    {
        this.id = id;
    }
    
    @Override
    public int getId() {
        return id; 
    }
    
}
