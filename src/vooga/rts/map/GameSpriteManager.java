package vooga.rts.map;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import vooga.rts.IGameLoop;
import vooga.rts.gamedesign.sprite.gamesprites.GameSprite;
import vooga.rts.gamedesign.sprite.map.Terrain;
import vooga.rts.util.Location3D;


/**
 * This class is a basic manager for Game Sprites that will go on the map.
 * These will be things such as Terrains and Resources.
 * 
 * Extensions of this class will be what is used to store the actual information.
 * 
 * @author Jonathan Schmidt
 * 
 */
public class GameSpriteManager<T extends GameSprite> extends Observable implements IGameLoop {

    private List<T> myGameSprites;

    public GameSpriteManager () {
        myGameSprites = new ArrayList<T>();
    }

    @Override
    public void update (double elapsedTime) {
        for (T t : myGameSprites) {
            t.update(elapsedTime);
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        for (T t : myGameSprites) {
            t.paint(pen);
        }
    }

    /**
     * Adds terrain to the terrain map
     * 
     * @param gs The Terrain to add
     */
    public void add (T gs) {
        myGameSprites.add(gs);
    }

    /**
     * Removes a Terrain from the TerrainManager if it exists
     * 
     * @param gs The Terrain to remove
     */
    public void remove (T gs) {
        myGameSprites.remove(gs);
    }

    /**
     * Returns the first Game Sprite at the certain world position
     * 
     * @param world The world position to look at
     * @return The Game Sprite at that position
     */
    public T getGameSprite (Location3D world) {
        for (T t : myGameSprites) {
            if (t.intersects(world)) {
                return t;
            }
        }
        return null;
    }

    public List<T> getInArea (Location3D center, double radius) {
        List<T> items = new ArrayList<T>();
        for (T single : myGameSprites) {
            // Do basic test first
            if (single.getWorldLocation().getManhattanDistance(center) < radius) {
                // Do accurate test second
                if (single.getWorldLocation().getDistance(center) < radius) {
                    items.add(single);
                }
            }
        }
        return items;
    }

}
