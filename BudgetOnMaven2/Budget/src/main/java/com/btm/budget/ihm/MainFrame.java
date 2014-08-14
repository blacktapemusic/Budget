/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.Core;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sdalens
 */
public class MainFrame extends JFrame implements MouseListener{
    Core core; 
    OperationTablePanel operationTable; 
    AccountTablePanel accountTablePanel; 
    JPanel panel;
    
    public MainFrame()
    {
        super();
        
        core = Core.getInstance(); 
        
        init();
    }

    private void init() { 
        setTitle("Budget"); //On donne un titre à l'application
        setSize(1000,1000); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(false); //On interdit la redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setContentPane(buildContentPane());
    }

    private Container buildContentPane() {
//        JPanel panel = new TablePanel();
        //Le conteneur principal
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 1000));
        //On définit le layout manager
        panel.setLayout(new GridBagLayout());
//        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        
        accountTablePanel = new AccountTablePanel(); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 0.2; 
        
        panel.add(accountTablePanel, gbc); 
        
        
        operationTable = new OperationTablePanel();
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
//        gbc.weighty = 0.7;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(operationTable, gbc); 
        
        accountTablePanel.tab.addMouseListener(this);
        
//        //L'objet servant à positionner les composants
//        BorderLayout layout = new BorderLayout(); 
        
//        operationTable = new OperationTablePanel();
//        panel.add(operationTable, BorderLayout.CENTER);
//        
//        accountTablePanel = new AccountTablePanel(); 
//        panel.add(accountTablePanel, BorderLayout.WEST); 
//        core.loadAllAccount();
        
        return panel;
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
        // change acount table print in panel
        if(accountTablePanel.tab == e.getComponent())
        {
            operationTable.changeAccount(accountTablePanel.tab.getSelectedRow());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
