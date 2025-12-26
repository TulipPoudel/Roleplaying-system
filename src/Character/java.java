/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Character;

/**
 *
 * @author Lenovo
 */
public class java {
    

    public class Character {

        private String name;
        private int level;
        private int score;

        public Character(String name) {
            this.name = name;
            this.level = 1;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public int getScore() {
            return score;
        }

        public void addScore(int points) {
            this.score += points;
        }

        public void levelUp() {
            level++;
        }
    }

}
