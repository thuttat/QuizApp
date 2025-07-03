package com.alisa.utils.theme;


import alisa.quizapp.App;
import com.alisa.utils.theme.ThemeFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class DarkTheme implements ThemeFactory{

    @Override
    public String StyleSheet() {
        return App.class.getResource("dark.css").toExternalForm();
    }
   
}
