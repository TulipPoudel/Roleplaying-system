/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */


public class GameCharacter {

    private String name;
    private String clazz;
    private int score;
    private int level;
    

    public GameCharacter(String name, String clazz, int level) {
        this.name = name;
        this.clazz = clazz;
        this.score = 0;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public int getScore() {
        return score;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    
    
    @Override
    public String toString() {
        return name + " (" + clazz + ") - Score: " + score;
    }
}

