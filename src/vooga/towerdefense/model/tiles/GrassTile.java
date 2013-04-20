package vooga.towerdefense.model.tiles;

import java.awt.Dimension;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * A grass tile.
 * 
 * @author Erick Gonzalez
 */
public class GrassTile extends Tile {
    private int myId;

    /**
     * 
     * @param id tile id
     * @param image an image 
     * @param center the center of the tile
     * @param size the size of the tile
     */
    public GrassTile (int id, Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        setBuildable(true);
        setWalkable(false);
        myId = id;
    }

    @Override
    public boolean isBuildable () {
        return super.isBuildable();
    }

    @Override
    public boolean isWalkable () {
        return super.isWalkable();
    }

    @Override
    public int getTileId () {
        return myId;
    }
}
