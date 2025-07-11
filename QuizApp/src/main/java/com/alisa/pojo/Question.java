/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alisa.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Phuong Uyen
 */
public class Question {

    private int id;
    private String content;
    private String hint;
    private String image;
    private Categories categories;
    private Level level;
    private List<Choice> choices;

    private Question(Builder b) {
        this.id = b.id;
        this.content = b.content;
        this.hint = b.hint;
        this.image = b.image;
        this.categories = b.categories;
        this.level = b.level;
        this.choices = b.choices;

    }

    public static class Builder {

        private int id;
        private String content;
        private String hint;
        private String image;
        private Categories categories;
        private Level level;
        private List<Choice> choices = new ArrayList<>();

        public Builder(String c, Categories ca, Level l) throws Exception {
            if(c.isEmpty()||ca==null||l==null){
                throw new Exception("troi oi");
            }
            this.content = c;
            this.categories = ca;
            this.level = l;
        }

        public Builder addHint(String h) {
            this.hint = h;
            return this;
        }

        public Builder addImage(String h) {
            this.image = h;
            return this;
        }

        public Builder addChoice(Choice c) {
            this.choices.add(c);
            return this;
        }
        public Question build(){
            return new Question(this);
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * @param hint the hint to set
     */
    public void setHint(String hint) {
        this.hint = hint;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * @return the choices
     */
    public List<Choice> getChoices() {
        return choices;
    }

    /**
     * @param choices the choices to set
     */
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

}
