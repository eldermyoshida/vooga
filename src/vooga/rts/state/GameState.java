package vooga.rts.state;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import vooga.rts.controller.Command;
import vooga.rts.controller.Player;
import vooga.rts.manager.Manager;
import vooga.rts.map.GameMap;

//TODO: implement the game state with all unit managers that there needs to be. Muy importante.
//TODO: think of how decisions are going to be made with the controllers.

public class GameState extends SubState {
    
    private final static int DEFAULT_NODE_SIZE = 8;
    private GameMap myMap;
    private Player myPlayer;
    private Manager myManager;
    
    public GameState (Observer observer, Dimension gameSize) {
        super(observer);
        myMap = new GameMap(DEFAULT_NODE_SIZE, gameSize);
        myPlayer = new Player(this);
        myManager = null;
    }

    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub  
    }

    @Override
    public void paint (Graphics2D pen) {
        pen.drawString("Game is Loaded", 200, 300);
        
    }

    @Override
    public void receiveCommand (Command command) {
        // TODO Auto-generated method stub
        
    }
    
    
}
