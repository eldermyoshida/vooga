
package vooga.scroller.level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import vooga.scroller.util.Editable;
import vooga.scroller.util.Location;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.collision_handlers.CollisionManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.view.View;

public class Level implements Editable, Renderable {

    private Dimension mySize;
    private Dimension frameOfReferenceSize;
    private Dimension frameOfActionSize;
    private Player myPlayer;
    private List<Sprite> mySprites;
    private List<Sprite> myFrameOfActionSprites;
    private List<Sprite> myFrameOfReferenceSprites;
    private View myView;
    private ScrollingManager myScrollManager;
    private Image myBackground;
    //TEMPORARY 
    private Image DEFAULT_BACKGROUND = new ImageIcon(getClass().getResource("/vooga/scroller/images/forestbackground.jpg")).getImage();

    public Level(int id, ScrollingManager sm){

        //MIGHT WANT TO INITIALIZE THIS WITH A PLAYER AS WELL
        mySize = PlatformerConstants.DEFAULT_LEVEL_SIZE;
        initFrames();
        myBackground = DEFAULT_BACKGROUND;
    }
    
    public Level(int id){
        //this(id,new DefaultScrollingManager());
    }

    public Level(int id, ScrollingManager sm, View view){
        //MIGHT WANT TO INITIALIZE THIS WITH A PLAYER AS WELL
        mySize = PlatformerConstants.DEFAULT_LEVEL_SIZE;
        initFrames();
        myView = view;
        frameOfReferenceSize = myView.getSize();
        frameOfActionSize = calcActionFrameSize(myView.getSize());
        myScrollManager = sm;
        myBackground = DEFAULT_BACKGROUND;
    }

    private void initFrames() {
        myFrameOfActionSprites = new ArrayList<Sprite>();
        myFrameOfReferenceSprites = new ArrayList<Sprite>();
        mySprites = new ArrayList<Sprite>();       
    }

    public void setSize(Dimension size) {
        mySize = size;
    }
    /**
     * Adds a sprite to the level.
     * @param s the Sprite to be added
     */

    public void addSprite(Sprite s){
            mySprites.add(s);
    }
    
    public void removeSprite(Sprite s) {
        mySprites.remove(s);
    }
    
    public void addPlayer(Player s) {
        myPlayer = s;
        for (Sprite sprite : mySprites) {

            if (sprite instanceof NonStaticEntity) {
                addPlayerToSprite((NonStaticEntity) sprite);
            }
            
        }
    }
    
    public void addPlayerToSprite(NonStaticEntity sprite) {
        sprite.addPlayer(myPlayer);
    }
    
    public void setBackground(Image i) {
        myBackground = i;
    }
    
    public Image getBackground() {
        return myBackground;
    }

    //Methods from Renderable Interface. To be called by View components.  

    @Override
    public Object getState () {
        //TODO auto-generated.
        return null;
    }

    public void update(double elapsedTime, Dimension bounds, View view) {
        if(myPlayer != null) {
            updateFrames(view);
            myPlayer.update(elapsedTime, bounds);
            for(Sprite s: myFrameOfActionSprites) {
                s.update(elapsedTime, bounds);
            }
            intersectingSprites();
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        if(myPlayer != null) {
            for(Sprite s: myFrameOfReferenceSprites) {
                s.paint(pen,myPlayer.getCenter(), myPlayer.getOriginalCenter());
            }
            myPlayer.paint(pen);
        }
    }

    private void updateFrames(View view) {
        myFrameOfActionSprites.clear();
        myFrameOfReferenceSprites.clear();
        frameOfReferenceSize = view.getSize();
        frameOfActionSize = calcActionFrameSize(view.getSize());
        if(mySprites.size() > 0) {
            for(Sprite s: mySprites) {
                if(checkRange(s, frameOfReferenceSize)) {
                    myFrameOfReferenceSprites.add(s);
                    myFrameOfActionSprites.add(s);
                }
                if(!myFrameOfActionSprites.contains(s) & checkRange(s, frameOfActionSize)) {
                    myFrameOfActionSprites.add(s);
                }
            }
        }

    }

    private boolean checkRange(Sprite sprite, Dimension frame) {
        //This is pretty hacky, I am trying to think of a more elegant way
        if(myPlayer == null ||
                getLeftBoundary(frame) > sprite.getX()
                || getRightBoundary(frame) < sprite.getX()
                || getLowerBoundary(frame) < sprite.getY()
                || getUpperBoundary(frame) > sprite.getY()) {
            return false;
        }
        return true;
    }

    private Dimension calcActionFrameSize(Dimension size) {
        Dimension temp = new Dimension((int) size.getWidth() + 100, (int) size.getHeight() + 100);
        return temp;
    }
    
    public double getRightBoundary(Dimension frame) {
        return myScrollManager.getRightBoundary(frame, myPlayer.getCenter());
    }
    
    public double getLeftBoundary(Dimension frame) {
        return myScrollManager.getLeftBoundary(frame, myPlayer.getCenter());
    }
    
    public double getUpperBoundary(Dimension frame) {
        return myScrollManager.getUpperBoundary(frame, myPlayer.getCenter());
    }
    
    public double getLowerBoundary(Dimension frame) { 
        return myScrollManager.getLowerBoundary(frame, myPlayer.getCenter());
    }
    public double getRightBoundary() {
        return myScrollManager.getRightBoundary(frameOfReferenceSize, myPlayer.getCenter());
    }
    
    public double getLeftBoundary() {
        return myScrollManager.getLeftBoundary(frameOfReferenceSize, myPlayer.getCenter());
    }
    
    public double getUpperBoundary() {
        return myScrollManager.getUpperBoundary(frameOfReferenceSize, myPlayer.getCenter());
    }
    
    public double getLowerBoundary() { 
        return myScrollManager.getLowerBoundary(frameOfReferenceSize, myPlayer.getCenter());
    }


    public Dimension getLevelBounds() {
        return mySize;
    }
    
    

    //Methods from Editable Interface. Methods called by LevelEditor.

    @Override
    public void changeBackground () { //params need to be added
        // TODO Auto-generated method stub

    }

    @Override
    public void addNewSprite (Sprite s) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteSprite (int x, int y) {
        // TODO Auto-generated method stub
        
    }
    
    private void intersectingSprites () {
        Sprite obj1;
        Sprite obj2;
        CollisionManager CM = new CollisionManager(this);

       mySprites.add(myPlayer);
        
        for (int i = 0; i < mySprites.size(); i++) {
            for (int j = i + 1; j < mySprites.size(); j++) {     
                obj1 = mySprites.get(i);
                obj2 = mySprites.get(j);
                if (obj1.intersects(obj2)) {
                    CM.handleCollision(obj1, obj2);
                    CM.handleCollision(obj2, obj1);
                }

            }
        }
        
       mySprites.remove(mySprites.size()-1);
    }
    
    public View getView() {
        return myView;
    }
}
