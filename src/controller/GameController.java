/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import model.GameCharacter;
import model.Story;
import model.StoryChoice;
/**
 *
 * @author Lenovo
 */
    

public class GameController {

    private GameCharacter currentCharacter;
    private Queue<StoryChoice> choiceQueue = new LinkedList<>();

    private int currentScore = 0; 

    public void startGame(GameCharacter character, Story story) {
        this.currentCharacter = character;
        this.currentScore = character.getScore(); 
        choiceQueue.clear();

        
        for (StoryChoice c : story.getChoices()) {
            choiceQueue.offer(c);
        }
    }

    public StoryChoice nextChoice() {
        if (choiceQueue.isEmpty()) {
            return null;
        }
        return choiceQueue.poll(); 
    }

    public void applyChoice(StoryChoice choice) {
        currentScore += choice.getPoints(); 
        currentCharacter.addScore(choice.getPoints()); 
    }

    public int getScore() {
        return currentScore;
    }
    
    public void addScore(int points) {
        currentScore += points;
        if (currentCharacter != null) {
            currentCharacter.addScore(points);
        }
    }

    public void finishGame() {
        int score = getScore();
        String message;

        if (score >= 80) {
            message = "GOOD ENDING!";
        } else if (score >= 50) {
            message = "NORMAL ENDING";
        } else {
            message = "BAD ENDING";
        }
        
        message += "\nFinal Score: " + score;
        JOptionPane.showMessageDialog(null, message);
    }
    
    public GameCharacter getCurrentCharacter() {
        return currentCharacter;
    }
}


