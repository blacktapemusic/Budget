/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.Core;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author sdalens
 */
public class AccountTablePanel extends JPanel{
    JTable tab;
    Core core; 
    private AccountTableModel model = new AccountTableModel(); 
    
    public AccountTablePanel() {
        super();
         
        init(); 
    }

    private void init() {
        core = Core.getInstance();
        
//        core.loadAllAccount();
//        core.getOperationTableFromAccount(1);
        
        model.accountList.addAll(core.getAccountList());  
     
        tab = new JTable(model);
        
//        setLayout(new BorderLayout());

        add(tab.getTableHeader());
        add(tab); 
    }
}
