/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Story {
    private String title;
    private String intro;
    private String difficulty;
    private ArrayList<StoryChoice> choices;

    public Story(String title, String intro, String difficulty) {
        this.title = title;
        this.intro = intro;
        this.difficulty = difficulty;
        this.choices = new ArrayList<>();
        addDefaultChoices();
    }
    
    public void addChoice(StoryChoice choice) {
        choices.add(choice);
    }

    public ArrayList<StoryChoice> getChoices() {
        return choices;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public String getDifficulty() {
        return difficulty;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public void addDefaultChoices() {
        addChoice(new StoryChoice("Fight", 30));
        addChoice(new StoryChoice("Hide", 10));
        addChoice(new StoryChoice("Negotiate", 20));
    }
}
