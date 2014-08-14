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
public class ColorUserType extends PersistentEnumUserType<DBColor> {
    @Override
    public Class<DBColor> returnedClass() {
        return DBColor.class; 
    }
 
}
