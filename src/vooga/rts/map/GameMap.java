package vooga.rts.map;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.TileObserver;
import java.awt.image.WritableRenderedImage;
import vooga.rts.IGameLoop;
import vooga.rts.ai.Path;
import vooga.rts.ai.PathFinder;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.util.Camera;
import vooga.rts.util.Location;


/**
 * The GameMap will be responsible for taking in the location of
 * 
 * @author Challen Herzberg-Brovold
 * 
 */

// Still need to figure how to read in terrain. Also need to figure out how to
// add obstructions to the nodes. Possibly use the GameMap to implement vision.
public class GameMap implements IGameLoop {

    private int myNodeSize;
    private NodeMap myMap;
    private TileMap myTiles;

    /**
     * calculates how many nodes there are
     * 
     * @param mapSize This is the size of the map in pixels
     */
    public GameMap (int node, Dimension size) {
        NodeFactory factory = new NodeFactory();
        myNodeSize = node;
        myMap = factory.makeMap(myNodeSize, size);
        Camera.instance().setMapSize(size);
        randomGenMap();
    }

    public Node getNode (Location location) {
        int x = (int) location.x / myNodeSize;
        int y = (int) location.y / myNodeSize;
        return myMap.get(x, y);
    }

    public Path getPath (PathFinder finder, Location start, Location finish) {
        return finder.calculatePath(getNode(start), getNode(finish), myMap);
    }

    public NodeMap getMap () {
        return myMap;
    }

    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void paint (Graphics2D pen) {
        myTiles.paint(pen);
    }

    private void randomGenMap () {
        int tilesX = 256;
        int tilesY = 256;
        int tileWidthX = 60;
        int tileWidthY = 42;
        myTiles = new TileMap(new Dimension(tileWidthX, tileWidthY), tilesX, tilesY);

        /*
         * BufferedImage banana =
         * ResourceManager.getInstance()
         * .<BufferedImage> getFile("images/tiles/iso-64x64-outside.png",
         * BufferedImage.class);
         * 
         * 
         * myTiles.addTileType(1, banana.getSubimage(0, 0, 64, 64));
         * myTiles.addTileType(2, banana.getSubimage(2 * 64, 0, 64, 64));
         */

        BufferedImage banana =
                ResourceManager
                        .getInstance()
                        .<BufferedImage> getFile("images/tiles/isometric_new_tiles_by_spasquini.png",
                                                 BufferedImage.class);

        myTiles.addTileType(1, banana.getSubimage(6 * tileWidthX, 0, tileWidthX, tileWidthY));
        myTiles.addTileType(2, banana.getSubimage(7 * tileWidthX, 0, tileWidthX, tileWidthY));

        for (int i = 0; i < tilesX; i++) {
            for (int j = 0; j < tilesY; j++) {
                if (Math.random() < 0.1) {
                    myTiles.createTile(2, i, j);
                }
                else {
                    myTiles.createTile(1, i, j);
                }
            }
        }
        System.out.println("Map Made");
        Camera.instance().setMapSize(new  Dimension(tilesX * tileWidthX, tilesY * tileWidthY));
    }
}
