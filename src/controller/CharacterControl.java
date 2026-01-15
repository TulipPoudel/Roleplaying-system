/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.GameCharacter;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
    
public class CharacterControl {
    
    private Queue<GameCharacter> characterQueue;
    public CharacterControl() {
        characterQueue = new LinkedList<>();
        preloadCharacters();
    }

    
    private void preloadCharacters() {
        characterQueue.offer(new GameCharacter("Kim Dokja","Reader", 13));
        characterQueue.offer(new GameCharacter("Yoo Joonghyuk", "Protag", 13));
        characterQueue.offer(new GameCharacter("Han Sooyoung", "Writer", 13));
    }

    
    public void addCharacter(String name, String clazz, int level) {
        GameCharacter character = new GameCharacter(name, clazz, level);
        character.setClazz(clazz);
        characterQueue.offer(character);
    }

    
    public void deleteCharacter(int index) {
        if (index < 0 || index >= characterQueue.size()) return;

        Queue<GameCharacter> temp = new LinkedList<>();
        int i = 0;

        while (!characterQueue.isEmpty()) {
            GameCharacter c = characterQueue.poll();
            if (i != index) {
                temp.offer(c);
            }
            i++;
        }

        characterQueue = temp;
    }

    public void sortByLevel() {
        GameCharacter[] arr = characterQueue.toArray(new GameCharacter[0]);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].getLevel() > arr[j + 1].getLevel()) {
                    GameCharacter temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        characterQueue.clear();
        for (GameCharacter c : arr) {
            characterQueue.offer(c);
        }
    }
    public Queue<GameCharacter> getCharacters() {
        return characterQueue;
    }
}

