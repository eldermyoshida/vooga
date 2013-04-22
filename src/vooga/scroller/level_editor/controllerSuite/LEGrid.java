package vooga.scroller.level_editor.controllerSuite;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.Scrollable;
import util.Location;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_editor.StartPoint;
import vooga.scroller.level_editor.model.SpriteBox;
import vooga.scroller.level_editor.view.LEGridView;
import vooga.scroller.level_management.IDoor;
import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.scrollingmanager.OmniScrollingManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.util.Editable;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.Sprite;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.SimpleView;
import vooga.scroller.view.GameView;


public class LEGrid implements Editable, Renderable<LEGridView>, Scrollable {

    public static final int DEFAULT_SPRITE_SIZE = 32;
    private static final Location DEFAULT_START_LOC = new Location(0,0);
    private static final Location DEFAULT_END_LOC = new Location(100,100);
    private int mySpriteSize;
    private SpriteBox[][] myGrid;
    private Dimension mySize;
    private Set<SpriteBox> myPaintableBoxes;
    private StartPoint myStartPoint;
    private LevelPortal myMainDoor; //TODO - eventually support multiple doors
    private Image myBackground;

    public LEGrid (int numWidthBlocks, int numHeightBlocks) {
        mySpriteSize = DEFAULT_SPRITE_SIZE;
        mySize = new Dimension(numWidthBlocks, numHeightBlocks);
        myGrid = new SpriteBox[numWidthBlocks][numHeightBlocks];
        initializeGrid();
        myPaintableBoxes = new HashSet<SpriteBox>();
    }

    public int getSpriteSize () {
        return mySpriteSize;
    }

    @Override
    public Object getState () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void paint (Graphics2D pen) {
        for(int i = 0; i < mySize.width; i++){
            for( int j = 0; j < mySize.height; j++){
                myGrid[i][j].paint(pen);
            }
        }
    }

    @Override
    public void addSprite (Sprite spr, int x, int y) {
        SpriteBox currentBox = getBox(x, y);
        addToBox(spr, currentBox);
    }

    public void addSpriteToBox(int xcoor, int ycoor, Sprite sprite){
        addToBox(sprite,getBoxFromCoor(xcoor,ycoor));
    }

    /**
     * @param spr
     * @param currentBox
     */
    private void addToBox (Sprite spr, SpriteBox currentBox) {
        if (checkAvailable(currentBox, spr.getWidth(), spr.getHeight())) {
            currentBox.addSprite(spr);
            myPaintableBoxes.add(currentBox);
            combineBoxes(currentBox, currentBox, spr.getWidth(), spr.getHeight());
        }
        else {
            // TODO send Unavailable feedback
        }
    }

    @Override
    public void deleteSprite (int x, int y) {
        SpriteBox currentBox = getBox(x, y);
        currentBox.deleteSprite();
        myPaintableBoxes.remove(currentBox);
    }
    
    public Set<SpriteBox> getBoxes() {
        return myPaintableBoxes;
    }
    
    /**
     * TODO - Moving this responsibility to Level
     * @param id
     * @param sm
     * @param v
     * @return
     */
    public Level createLevel (int id, 
                              ScrollingManager sm) {
        //TODO need to refactor. Editable Level.
        Level lev = new Level(id, sm);
        for (SpriteBox box : getBoxes()) {
            lev.addSprite(box.getSprite());
        }
        return lev;
    }
    
    public SpriteBox getBoxFromCoor(int xcoor, int ycoor){
        return myGrid[xcoor][ycoor];
    }
    
    public Sprite getSprite(int xcoor, int ycoor){
        return getBoxFromCoor(xcoor,ycoor).getSprite();
    }
    
    public Dimension getSize(){
        return mySize;
    }

    private boolean checkAvailable (SpriteBox current, double width, double height) {
        if (!current.isAvailable()) { return false; }
        boolean bool1 = true;
        boolean bool2 = true;
        if (width > mySpriteSize) {
            SpriteBox next = getBox(current.getX() + mySpriteSize, current.getY());
            bool1 = checkAvailable(next, width - mySpriteSize, height);
        }
        if (height > mySpriteSize && bool1) {
            SpriteBox nextBox = getBox(current.getX(), current.getY() + mySpriteSize);
            bool2 = checkAvailable(nextBox, width, height - mySpriteSize);
        }
        return bool1 && bool2;
    }

    private void combineBoxes (SpriteBox initial, SpriteBox current, double width, double height) {
        if (width > mySpriteSize) {
            SpriteBox next = getBox(current.getX() + mySpriteSize, current.getY());
            initial.combineWith(next);
            combineBoxes(initial, next, width - mySpriteSize, height);
        }
        if (height > mySpriteSize) {
            SpriteBox next = getBox(current.getX(), current.getY() + mySpriteSize);
            initial.combineWith(next);
            combineBoxes(initial, next, width, height - mySpriteSize);
        }
    }

    private SpriteBox getBox (double x, double y) {
        int xCoord = (int) Math.floor(x / mySpriteSize);
        int yCoord = (int) Math.floor(y / mySpriteSize);
        return myGrid[xCoord][yCoord];
    }

    private void initializeGrid () {
        for (int x = 0; x < mySize.getWidth(); x++) {
            for (int y = 0; y < mySize.getHeight(); y++) {
                myGrid[x][y] = new SpriteBox(this, x, y);
            }
        }
    }

    @Override
    public Dimension getPreferredScrollableViewportSize () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getScrollableUnitIncrement (Rectangle visibleRect, int orientation, int direction) {
        return DEFAULT_SPRITE_SIZE;
    }

    @Override
    public int getScrollableBlockIncrement (Rectangle visibleRect, int orientation, int direction) {
        return DEFAULT_SPRITE_SIZE;
    }

    @Override
    public boolean getScrollableTracksViewportWidth () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight () {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Get the overall pixels size of this LEGrid.
     * @return
     */
    public Dimension getPixelSize () {
        Dimension res= new Dimension(
                                     mySize.width*DEFAULT_SPRITE_SIZE,
                                     mySize.height*DEFAULT_SPRITE_SIZE);
        
        return res;
    }

    public boolean isValidForSimulation () {
        // TODO Check for valid starting and exit points.
        return (myStartPoint!=null && myMainDoor!=null);
    }

    @Override
    public void addStartPoint (int x, int y) {
        if(myStartPoint == null){
            myStartPoint = new StartPoint();
        }
        else{
            deleteSprite((int) myStartPoint.getX(),(int) myStartPoint.getY());
        }
        addSprite(myStartPoint, x, y);
    }
    
    public Location removeStartPoint(){
        if(myStartPoint == null){
            return DEFAULT_START_LOC;
        }
        Location center = myStartPoint.getCenter();
        deleteSprite((int) center.getX(),(int) center.getY());
        return center;
    }

    @Override
    public void addDoor (int x, int y) {
        // TODO Auto-generated method stub
        if(myMainDoor == null){
            myMainDoor = new LevelPortal();
        }
        else{
            deleteSprite((int) myMainDoor.getX(),(int) myMainDoor.getY());
        }
        addSprite(myMainDoor, x, y);
    }

    public Location removePortal () {
        if(myMainDoor == null){
            return DEFAULT_END_LOC;
        }
        Location center = myMainDoor.getCenter();
        deleteSprite((int) center.getX(),(int) center.getY());
        return center;
    }

    @Override
    public LEGridView initializeRenderer (IView parent) {
        return new LEGridView(parent, this);
    }

    @Override
    public void changeBackground (Image i) {
        myBackground = i;
    }

    public Image getBackground () {
        return myBackground;
    }

    public void simulate () {
    //        // TODO Auto-generated method stub
    //        ScrollingManager sm = new OmniScrollingManager();
    //        GameView display = new GameView(PlatformerConstants.DEFAULT_WINDOW_SIZE, sm);
            IView simContainer = new SimpleView("Level Simulation");
            ScrollingManager sm = new OmniScrollingManager();
            Level sim = new Level(1, sm, this);
            GameView display = sim.initializeRenderer(simContainer);
            // container that will work with user's OS
            JFrame frame = new JFrame("Level Simulation");
            // add our user interface components
            frame.getContentPane().add(display, BorderLayout.CENTER);
            // display them
            frame.pack();
            frame.setVisible(true);
            // start animation
            display.start();
        }

}
