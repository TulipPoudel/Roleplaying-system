/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */

public class StoryChoice {
// The text describing what this choice does (e.g., "Fight the dragon")
    private String text;
    private int points; // Points awarded to the player for selecting this choice

    public StoryChoice(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }
}

