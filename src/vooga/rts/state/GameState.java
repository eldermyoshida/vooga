package vooga.rts.state;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.controller.Player;
import vooga.rts.manager.Manager;
import vooga.rts.map.GameMap;

public class GameState {
    
    private GameMap myMap;
    private List<Player> myPlayers;
    private Map<Player, Manager> myManagers;
    
    public GameState (Dimension gameSize) {
        myMap = new GameMap(8, gameSize);
        myPlayers = new ArrayList<Player>();
        myManagers = new HashMap<Player, Manager>();
    }
    
    
}
