package vooga.towerdefense.model.tiles;

import java.awt.Dimension;
import java.awt.Point;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Sprite;

/**
 * This class represents a Tile object.
 * 
 * @author Erick Gonzalez
 */
public class Tile extends Sprite {
    
    /**
     * Image for a grass tile
     */
    public static final Pixmap GRASS_TILE_IMAGE = new Pixmap("map/grass_tile.png");
    /**
     * Image for a path tile
     */
    public static final Pixmap PATH_TILE_IMAGE = new Pixmap("map/path_tile.png");
    /**
     * The size of a tile
     */
    public static final Dimension TILE_DIMENSIONS = new Dimension(50, 50);
    
    private Point myCenter;
    private GameElement myElement;

    /**
     * 
     * @param image an image
     * @param center the center of this tile
     * @param size the size of the tile
     */
    public Tile (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }
    
    public static Pixmap getTileImage(int tileId) {
        if (tileId == 0) {
            return GRASS_TILE_IMAGE;
        } else if (tileId == 1) {
            return PATH_TILE_IMAGE;
        }
        return null;
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
