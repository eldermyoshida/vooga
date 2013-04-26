package vooga.towerdefense.model.tiles.factories;

import java.awt.Dimension;

import util.Location;
import util.Pixmap;
import vooga.towerdefense.model.tiles.GrassTile;
import vooga.towerdefense.model.tiles.Tile;

/**
 * A tile factory that creates GrassTile objects.
 * 
 * @author Erick Gonzalez
 */
public class GrassTileFactory extends TileFactory {
    /**
     * Image for a grass tile
     */
    public static final Pixmap GRASS_TILE_IMAGE = new Pixmap("/vooga/towerdefense/images/map/grass_tile.png");

    @Override
    public Tile createTile (int id, Location center, Dimension tileSize) {
        return new GrassTile(id, GRASS_TILE_IMAGE, center, tileSize);
    }
    
}
