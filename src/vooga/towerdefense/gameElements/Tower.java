package vooga.towerdefense.gameElements;

import java.awt.Dimension;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Sprite;



public abstract class Tower extends Sprite {
    private Tile myTile;
    
    public Tower (Pixmap image, Location center, Dimension size,
                  Tile tile) {
        super(image, center, size);
        myTile = tile;
    }
    
    public void update(double elapsedTime) {
        
    }

}
