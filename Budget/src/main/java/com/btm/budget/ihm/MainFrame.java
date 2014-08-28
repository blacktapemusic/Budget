/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.Constants;
import com.btm.budget.Core;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author sdalens
 */
public class MainFrame extends JFrame implements MouseListener{
    Core core; 
    OperationTablePanel operationTablePanel; 
    AccountTablePanel accountTablePanel; 
    TimelinePanel timelinePanel; 
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
        setIconImage(Constants.appIcon.getImage()); // On donne a la fenetre l'icone de l'appli
    }

    private Container buildContentPane() {
//        JPanel panel = new TablePanel();
        //Le conteneur principal
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 1000));
        //On définit le layout manager
        panel.setLayout(new GridBagLayout());   
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        
        accountTablePanel = new AccountTablePanel(); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 0.2; 
        
        panel.add(accountTablePanel, gbc); 
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1; 
        panel.add(new JSeparator(JSeparator.VERTICAL), gbc);
        
        accountTablePanel.tab.addMouseListener(this);
        
        
        timelinePanel = new TimelinePanel(Calendar.getInstance()); // TODO mettre une date qui s'addapte  
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        gbc.weighty = 0.1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(timelinePanel, gbc); 
        
        
        operationTablePanel = new OperationTablePanel();
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.8;
        gbc.weighty = 0.9;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(operationTablePanel, gbc); 
        
//        //L'objet servant à positionner les composants
//        BorderLayout layout = new BorderLayout(); 
        
//        operationTable = new OperationTablePanel();
//        panel.add(operationTable, BorderLayout.CENTER);
//        
//        accountTablePanel = new AccountTablePanel(); 
//        panel.add(accountTablePanel, BorderLayout.WEST); 
//        core.loadAllAccount();
        
        timelinePanel.test();
        
        return panel;
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
        // change acount table print in panel
        if(accountTablePanel.tab == e.getComponent())
        {
            operationTablePanel.changeAccount(accountTablePanel.tab.getSelectedRow());
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
