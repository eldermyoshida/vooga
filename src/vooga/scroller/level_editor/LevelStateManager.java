package vooga.scroller.level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import vooga.scroller.level_editor.level_state.DefaultState;
import vooga.scroller.level_editor.level_state.PausedState;
import vooga.scroller.level_management.SpriteManager;
import vooga.scroller.view.GameView;

public class LevelStateManager {

    public static final int PAUSED_ID = 1;
    public static final int DEFAULT_ID = 0;
    
    private Map<Integer,LevelState> myLevelStates;
    private LevelState myCurrentState;
    
    
    public LevelStateManager(SpriteManager spriteManager) {
        initLevelStates(spriteManager);
        myCurrentState = myLevelStates.get(DEFAULT_ID);
    }

    private void initLevelStates (SpriteManager spriteManager) {
        myLevelStates = new HashMap<Integer, LevelState>();
        
        PausedState paused = new PausedState();
        DefaultState normal = new DefaultState(spriteManager);
        
        myLevelStates.put(PAUSED_ID, paused);
        myLevelStates.put(DEFAULT_ID, normal);       
    }
    
    public void changeState(int stateID) {
        myCurrentState = myLevelStates.get(stateID);
    }
    
    public void update (double elapsedTime, Dimension bounds, GameView gameView) {
        myCurrentState.update(elapsedTime, bounds, gameView);
    }
    
    public void paint(Graphics2D pen){
        myCurrentState.paint(pen);
    }

}
