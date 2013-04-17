package vooga.towerdefense.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.util.Location;


/**
 * 
 * 
 * @author Erick Gonzalez
 */
public class GameMap {
    // a normal computer screen will have
    private static final int TILE_SIZE = 25;

    private Image myBackgroundImage;
    private List<Unit> myUnits;
    private List<GameElement> myGameElements;
    private Tile[][] myGrid;
    private Location myDestination;
    private Dimension myDimension;
    private Path myPath;
    
    /**
     * 
     * @param background a background image
     * @param width the width of the map, in pixels
     * @param height the height of the map, in pixels
     * @param destination the destination point of all units
     */
    public GameMap (Image background, int width, int height, Location destination) {
        myBackgroundImage = background;
        myUnits = new ArrayList<Unit>();
        myGameElements = new ArrayList<GameElement>();
        myDestination = destination;
        myDimension = new Dimension(width, height);        
        initializeGrid();
    }

    /*
     * Initializes the grid so that each element in myGrid is a Tile object
     * containing it's center coordinates. Every tile is both walkable and
     * buildable. 
     */
    private void initializeGrid () {
        int horizontalTileCount = (int)(myDimension.getWidth() / TILE_SIZE);
        int verticalTileCount = (int)(myDimension.getHeight() / TILE_SIZE);
        
        myGrid = new Tile[horizontalTileCount][verticalTileCount];
        
        for (int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[i].length; j++) {
                int xCenter = (int) (i * TILE_SIZE + TILE_SIZE / 2);
                int yCenter = (int) (j * TILE_SIZE + TILE_SIZE / 2);
                // TODO: replace booleans with parsed values from file
                myGrid[i][j] = new Tile(new Point(xCenter, yCenter),
                                        true, true);
            }        
        }
    }

    /**
     * 
     * @param elapsedTime time elapsed since last game clock tick.
     */
    public void update (double elapsedTime) {
        updateUnits(elapsedTime);
        updateTiles(elapsedTime);
    }


    private void updateUnits (double elapsedTime) {
        for (Unit unit : myUnits) {
            unit.update(elapsedTime, null);
        }
    }

    private void updateTiles (double elapsedTime) {
        for (int i = 0; i < myGrid.length; ++i) {
            for (int j = 0; j < myGrid[i].length; ++j) {
                myGrid[i][j].update(elapsedTime);
            }
        }
    }

    public void spawnUnit (Unit u) {
        myUnits.add(u);
    }
    
    
    public void addToMap (GameElement e, Tile t) {
        e.setCenter(t.getCenter().getX(), t.getCenter().getY());
        myGameElements.add(e);
    }

    /**
     * Given a point on the map, returns the Tile enclosing that point.
     * 
     * @param point a point (x, y) on the game map, where x and y are measured in pixels.
     * @return a Tile object containing this point (x, y)
     */
    public Tile getTile (Point point) {
        return myGrid[(int) (point.getX() / TILE_SIZE)][(int) (point.getY() / TILE_SIZE)];
    }

    /**
     * 
     * @param pen a pen used to draw elements on this map.
     */
    public void paint (Graphics2D pen) {
        //TODO: draw background image on mapscreen
        for (Unit u : myUnits) {
            u.paint(pen);
        }
        for (GameElement e : myGameElements) {
            e.paint(pen);
        }
    }
}
