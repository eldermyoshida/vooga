package vooga.towerdefense.model;

import java.awt.Dimension;
import java.awt.Point;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Sprite;

public class Tile extends Sprite {
    public static final int TILE_SIZE = 50;
    public static final Pixmap TILE_IMAGE = new Pixmap("map/grass_tile.png");
    public static final Dimension TILE_DIMENSIONS = new Dimension(TILE_SIZE, TILE_SIZE);
    
    private Point myCenter;
    private GameElement myElement;

    
    public Tile (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }
    
    public boolean containsElement() {
        return myElement != null;
    }
    
    public GameElement getElement() {
        return myElement;
    }

    public void setTower (GameElement t) {
        myElement = t;
    }

    public void deleteTower () {
        myElement = null;
    }
    
    
    
    public String toString() {
        return "(" + myCenter.getX() + ", " + myCenter.getY() + ")";
    }

}
