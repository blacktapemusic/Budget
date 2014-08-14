/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.Constants;
import com.btm.budget.databaseObject.Operation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sdalens
 */
public class OperationTableModel extends AbstractTableModel {
    public final List<Operation> operationList = new ArrayList<Operation>();
    
    public final String[] header = {"name",
                                    "value", 
                                    "factChecker",
                                    "inOrOut",
                                    "date",
                                    "memo", 
                                    "category",
                                    "subCategory",
                                    "color",
                                    "periodic"}; 

    public OperationTableModel() {
        super();
    }
    
    @Override
    public int getRowCount() {
        return operationList.size();
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
                return operationList.get(rowIndex).getName();
            case 1:
                return operationList.get(rowIndex).getValue();
            case 2:
                return operationList.get(rowIndex).isFactChecker();
            case 3:
                return operationList.get(rowIndex).isInOrOut();
            case 4:
                return Constants.date_format.format(operationList.get(rowIndex).getDate().getTime());
            case 5:
                return operationList.get(rowIndex).getMemo();
            case 6:
                if(operationList.get(rowIndex).getCategory() != null)
                    return operationList.get(rowIndex).getCategory().getCategory();
                else
                    return null; 
            case 7:
                if(operationList.get(rowIndex).getSubCategory() != null)
                    return operationList.get(rowIndex).getSubCategory().getSubCategory();
                else
                    return null; 
            case 8:
                return operationList.get(rowIndex).getColor().name();
            case 9:
                return false; 
//                return operationList.get(rowIndex).getPeriodic();
            default:
                return null; 
        }
    } 
}
