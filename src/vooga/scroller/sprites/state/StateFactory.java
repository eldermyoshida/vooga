package vooga.scroller.sprites.state;

import java.util.HashMap;
import java.util.Map;
import vooga.scroller.marioGame.spritesDefinitions.players.resources.InvisibleState;
import vooga.scroller.sprites.Sprite;

public class StateFactory {

    private Sprite mySprite;
    
    public StateFactory(Sprite sprite) {
        mySprite = sprite;
    }

    public Map<Integer, SpriteState> createStateMap () {
        // TODO: read in states from files and use reflection to create
        
        Map<Integer, SpriteState> states = new HashMap<Integer, SpriteState>();
        
        InvisibleState invisibleMario= new InvisibleState(mySprite);
        
        states.put(1, invisibleMario);
       
        return states;
    }
    
    
    
}
