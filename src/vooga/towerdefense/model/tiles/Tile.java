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
public abstract class Tile extends Sprite {
    
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

    private boolean myIsWalkable;
    private boolean myIsBuildable;
    private int myId;

    /**
     * 
     * @param id a tile id
     * @param image an image
     * @param center the center of this tile
     * @param size the size of the tile
     */
    public Tile (int id, Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        myId = id;
    }
    
    
    
    public static Pixmap getTileImage(int tileId) {
        if (tileId == 0) {
            return GRASS_TILE_IMAGE;
        } else if (tileId == 1) {
            return PATH_TILE_IMAGE;
        }
        return null;
    }

    /**
     * 
     * @return true if you can build things on this tile.
     */
    public boolean isBuildable() {
        return myIsBuildable;
    }
    
    /**
     * 
     * @return the tile id
     */
    public int getTileId() {
        return myId;
    }
    
    /**
     * 
     * @return true if units can walk on this tile
     */
    public boolean isWalkable() {
        return myIsWalkable;
    }
    
    protected void setBuildable(boolean isBuildable) {
        myIsBuildable = isBuildable;
    }
    
    protected void setWalkable(boolean isWalkable) {
        myIsWalkable = isWalkable;
    }
}
