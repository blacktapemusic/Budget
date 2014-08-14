/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.Core;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author sdalens
 */
public class OperationTablePanel extends JPanel{
    JTable tab;
    Core core; 
    private OperationTableModel model = new OperationTableModel(); 
    public int accountOnFocus; 
    
    public OperationTablePanel() {
        super();
         
        init(); 
    }

    private void init() {
        accountOnFocus = 0; 
        
        core = Core.getInstance();
        

//        core.getOperationTableFromAccount(1);
        
        model.operationList.addAll(core.getAccountList().get(accountOnFocus).getDealList());  
        model.operationList.addAll(core.getAccountList().get(accountOnFocus).getForecastDealList());
     
        tab = new JTable(model);
        
        add(tab.getTableHeader());
        add(tab); 
    }
    
    public void changeAccount(int index) {
        if(index != accountOnFocus)
        {
            accountOnFocus = index; 
            
            model.operationList.clear();
            
            model.operationList.addAll(core.getAccountList().get(accountOnFocus).getDealList());  
            model.operationList.addAll(core.getAccountList().get(accountOnFocus).getForecastDealList());
            
            repaint();
        }
    }
}
