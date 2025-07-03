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
public class DefaultTheme implements ThemeFactory{

    @Override
    public String StyleSheet() {
        return App.class.getResource("Style.css").toExternalForm(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
