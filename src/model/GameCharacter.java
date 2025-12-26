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

    public GameCharacter(String name) {
        this.name = name;
        this.clazz = "Warrior";
        this.score = 0;
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

