package vooga.towerdefense.levelEditor;

import vooga.towerdefense.levelEditor.controller.LEController;


/**
 * This main class loads the Level Editor, which will help the game
 * developer to create a Tower Defense game.
 * 
 * @author Yoshida
 * 
 */

public class Main {
    public static void main (String[] args) {
        @SuppressWarnings("unused")
        LEController myController = new LEController("English");
    }
}
