/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import com.btm.budget.ihm.MainFrame;

/**
 *
 * @author STEL
 */
public class Budget {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Core core;
        
        core = Core.getInstance();
        core.loadAllAccount();
        
        Constants constants = new Constants(); 
        constants.init();
        
        MainFrame frame = new MainFrame(); 
        frame.setVisible(true);
    }
    
}
