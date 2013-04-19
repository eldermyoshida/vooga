package vooga.scroller.level_management;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.scroller.sprites.state.State;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.View;

public class SpriteManager {

    private List<Sprite> mySprites;
    private List<Sprite> myFrameOfActionSprites;
    private List<Sprite> myFrameOfReferenceSprites;
    private Player myPlayer;
    
    //private List<State> myLevelStates;
    
    
    
    public SpriteManager(){
        
        mySprites = new ArrayList<Sprite>();
//        initStates();
        initFrames();
    }
    
//    private void initStates () {
//        myLevelStates = new ArrayList<State>();
//        
//    }

    private void initFrames () {
        myFrameOfActionSprites = new ArrayList<Sprite>();
        myFrameOfReferenceSprites = new ArrayList<Sprite>();
    }
    
    public void removeSprite (Sprite s) {
        mySprites.remove(s);
    }

    public void addSprite (Sprite s) {
        mySprites.add(s);
    }
    
    public void addPlayer(Player player){
        myPlayer = player;
    }
    
    public Player getPlayer(Player player){
        return myPlayer;
    }
    
    public void updateSprites(double elapsedTime, Dimension bounds, View view) {

        if (myPlayer != null) {
            updateFrames(view);
            myPlayer.update(elapsedTime, bounds);
            checkPlayerOutOfBounds();
            if (myPlayer.getHealth() <= 0) {
                myPlayer.handleDeath();
            }

            for (Sprite s : myFrameOfActionSprites) {
                s.update(elapsedTime, bounds);
                if (s.getHealth() <= 0) {
                    this.removeSprite(s);
                }
            }

            if (myPlayer.getHealth() <= 0) {
                myPlayer.handleDeath();

            }

            intersectingSprites();
        }
    }

    
    
    
}
