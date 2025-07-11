/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alisa.services;

import com.alisa.pojo.Question;
import java.sql.Connection;
import com.alisa.utils.JdbcConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tran Phuong Uyen
 */
public class QuestionServices {

    public void addQuestion(Question q) throws SQLException {
        Connection conn = JdbcConnection.getInstance().connect();
        conn.setAutoCommit(false);
        String sql = "INSERT INTO (question, hint, image, category_id, level_id) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareCall(sql);
        stm.setString(1, q.getContent());
        stm.setString(2, q.getHint());
        stm.setString(3, q.getImage());
        stm.setInt(4, q.getCategories().getId());
        stm.setInt(5, q.getLevel().getId());

        if (stm.executeUpdate() > 0) {
            int questionId = -1;
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                questionId = rs.getInt(1);
            }
            sql = "INSERT INTO choice(content, is_correct, question_id) VALUES(?, ?, ?)";
            for (var c : q.getChoices()) {
                stm.setString(1, c.getContent());
                stm.setBoolean(2, c.isCorrect());
                stm.setInt(3, questionId);

                stm.executeUpdate();
            }
            conn.commit();
        } else {
            conn.rollback();
        }

    }

}
