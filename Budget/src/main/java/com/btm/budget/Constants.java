/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btm.budget;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author sdalens
 */
public final class Constants {
    public static final SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public static URL appIconPath; 
    public static ImageIcon appIcon;
    
    private static URL leftIconPath; 
    public static ImageIcon leftIcon;
    
    private static URL rightIconPath; 
    public static ImageIcon rightIcon;
    
    public static final Dimension smallSizeIcon = new Dimension(10, 10); 
    
    public static final String[] monthList = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};
    
    public void init(){
        appIconPath = this.getClass().getResource("/app/mainIcon.png");
        appIcon = new ImageIcon(appIconPath);
        
        leftIconPath = this.getClass().getResource("/app/leftIcon.png");
        leftIcon = new ImageIcon(leftIconPath);
        leftIcon = new ImageIcon(leftIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)); 
        
        rightIconPath = this.getClass().getResource("/app/rightIcon.png");
        rightIcon = new ImageIcon(rightIconPath);
        rightIcon = new ImageIcon(rightIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)); 
    }
}
