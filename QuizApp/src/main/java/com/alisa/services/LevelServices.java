/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alisa.services;

import com.alisa.pojo.Categories;
import com.alisa.pojo.Level;
import com.alisa.utils.JdbcConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tran Phuong Uyen
 */
public class LevelServices {
     public List<Level> getLevels() throws SQLException {
        // Mở kết nối
        Connection conn = JdbcConnection.getInstance().connect();

        // Truy vấn
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM level");

        List<Level> levels = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String note = rs.getString("note");

            Level c = new Level(id, name,note);
            levels.add(c);
        }
        
        return levels;
    }
}
