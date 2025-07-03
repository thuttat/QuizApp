/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alisa.utils.theme;

import alisa.quizapp.App;

/**
 *
 * @author admin
 */
public class LightTheme implements ThemeFactory{

    @Override
    public String StyleSheet() {
       return App.class.getResource("light.css").toExternalForm(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
