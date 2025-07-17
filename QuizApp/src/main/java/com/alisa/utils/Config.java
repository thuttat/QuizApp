/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alisa.utils;

import com.alisa.services.CategoriesServices;
import com.alisa.services.LevelServices;
import com.alisa.services.QuestionServices;

/**
 *
 * @author admin
 */
public class Config {

    public static final LevelServices levelServices = new LevelServices();
    public static final CategoriesServices cateServices = new CategoriesServices();
    public static final QuestionServices questionServices = new QuestionServices();
    
}
