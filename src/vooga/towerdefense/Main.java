package vooga.towerdefense;

import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.model.Game;

public class Main {
    
    private Main() {
        // prevent instantiation of this class
    }
    
    public static void main(String[] args) {
        Controller controller = new Controller();        
        Game game = new Game(controller);
//        game.start();
    }
}
