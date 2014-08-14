/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.Constants;
import com.btm.budget.databaseObject.Operation;
import com.btm.budget.databaseObject.Solde;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sdalens
 */
public class SoldeTableModel  extends AbstractTableModel {
    public final List<Solde> soldeList = new ArrayList<Solde>();
    
    public final String[] header = {"Compte"}; 

    public SoldeTableModel() {
        super();
    }
    
    @Override
    public int getRowCount() {
        return soldeList.size();
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
            case 0:
                return soldeList.get(rowIndex).getValue();
            default:
                return null; 
        }
    } 
}