/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.databaseObject.Account;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sdalens
 */
public class AccountTableModel extends AbstractTableModel{
    public final List<Account> accountList = new ArrayList<Account>(); 
    
    public final String[] header = {"Compte",
                                    "Solde"};

    public AccountTableModel(){
        super(); 
    }
    
    @Override
    public int getRowCount() {
        return accountList.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    @Override 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : 
                return accountList.get(rowIndex).getName();
            case 1 :
                return accountList.get(rowIndex).getSolde();
            default : 
                return null;
        }
    }     
}
