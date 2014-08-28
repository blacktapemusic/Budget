/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget.ihm;

import com.btm.budget.Constants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author sdalens
 */
public class TimelinePanel extends JPanel{
    Calendar dateSelect;
    JTextArea yearText;

    public TimelinePanel(Calendar dateSelect) {
        super(); 
        
        this.dateSelect = dateSelect; 
        
        init();
    }

    private void init() {
        setLayout(new GridBagLayout()); 
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER; 
        
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.weightx = 0.2;
//        gbc.weighty = 0.2; 
        
        
//        add(new JTextArea(dateSelect.get(Calendar.YEAR))); 
        JLabel leftImage = new JLabel(Constants.leftIcon); 
        leftImage.setSize(Constants.smallSizeIcon);
        add(leftImage, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
//        gbc.weightx = 0.2;
//        gbc.weighty = 0.2;
        yearText = new JTextArea(""+dateSelect.get(Calendar.YEAR));
        yearText.setEditable(false);
        
        add(yearText, gbc); 
        
        gbc.gridx = 2;
        gbc.gridy = 0;
//        gbc.weightx = 0.2;
//        gbc.weighty = 0.2;
        JLabel rightImage = new JLabel(Constants.rightIcon); 
        rightImage.setSize(Constants.smallSizeIcon);
        add(rightImage, gbc); 
        
        
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        JList monthList = new JList(Constants.monthList); 
        monthList.setVisibleRowCount(1);
        monthList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        monthList.setSelectedIndex(dateSelect.get(Calendar.MONTH));
        add(monthList, gbc); 
        
    }
    
    public void test()
    {
        System.out.println("PARENT : " + getParent());
    }
}
