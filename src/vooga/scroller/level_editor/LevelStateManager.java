package vooga.scroller.level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import vooga.scroller.level_editor.level_state.DefaultState;
import vooga.scroller.level_editor.level_state.PausedState;
import vooga.scroller.level_management.SpriteManager;
import vooga.scroller.sprites.state.State;
import vooga.scroller.view.GameView;

public class LevelStateManager {

    public static final int PAUSED_ID = 1;
    public static final int DEFAULT_ID = 0;
    
    private Map<Integer,State> myLevelStates;
    private State myCurrentState;
    
    
    public LevelStateManager(GameView gameView, SpriteManager spriteManager) {
        initLevelStates(gameView, spriteManager);
        myCurrentState = myLevelStates.get(DEFAULT_ID);
    }

    private void initLevelStates (GameView gameView, SpriteManager spriteManager) {
        myLevelStates = new HashMap<Integer, State>();
        
        PausedState paused = new PausedState(gameView);
        DefaultState normal = new DefaultState(spriteManager, gameView);
        
        myLevelStates.put(PAUSED_ID, paused);
        myLevelStates.put(DEFAULT_ID, normal);       
    }
    
    public void changeState(int stateID) {
        myCurrentState = myLevelStates.get(stateID);
    }
    
    public void update (double elapsedTime, Dimension bounds) {
        myCurrentState.update(elapsedTime, bounds);
    }
    
    public void paint(Graphics2D pen){
        myCurrentState.paint(pen);
    }
}
