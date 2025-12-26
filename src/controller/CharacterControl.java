/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.GameCharacter;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
    
public class CharacterControl {

    private ArrayList<GameCharacter> characters;

    public CharacterControl(ArrayList<GameCharacter> characters) {
        this.characters = characters;
        preloadCharacters();
    }

    private void preloadCharacters() {
        characters.add(new GameCharacter("Dokja"));
        characters.add(new GameCharacter("Joonghyuk"));
        characters.add(new GameCharacter("Sooyoung"));
    }

    public void addCharacter(String name) {
        addCharacter(name, "Warrior"); 
    }
    
    public void addCharacter(String name, String clazz) {
        GameCharacter character = new GameCharacter(name);
        character.setClazz(clazz);
        characters.add(character);
    }

    public ArrayList<GameCharacter> getCharacters() {
        return characters;
    }
    
    public void deleteCharacter(int index) {
        if (index >= 0 && index < characters.size()) {
            characters.remove(index);
        }
    }
}

