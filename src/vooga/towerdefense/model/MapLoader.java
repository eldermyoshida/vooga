package vooga.towerdefense.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import vooga.towerdefense.util.Location;

/**
 * A class responsible from loading a map from a text file.
 * 
 * The text file is formatted as follows:
 * 
 * Ex: 
 * 
 * 0 0 0 0
 * 1 1 0 0
 * 0 1 1 1
 * 0 0 0 0
 * 
 * In this text file, there will be a grid of numbers. Each number
 * corresponds to a tile id. In order to create a new map, all you need
 * to do is create this text file, and make tiles with appropriate ids.
 * 
 * @author Erick Gonzalez
 */
public class MapLoader {
    /**
     * Relative path to the map file.
     */
    public static final String MAPTILES_FILENAME = "/vooga/towerdefense/resources/map.txt";
    
    /**
     * 
     * @param mapWidth width of the map
     * @param mapHeight height of the map
     * @return two dimensional array of tiles
     */
    public Tile[][] loadTiles(int mapWidth, int mapHeight) {
        Scanner reader = getScanner();
        
        int horizontalTileCount = (int) (mapWidth / Tile.TILE_SIZE);
        int verticalTileCount = (int) (mapHeight / Tile.TILE_SIZE);

        Tile[][] grid = new Tile[horizontalTileCount][verticalTileCount];

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int xCenter = (int) (j * Tile.TILE_SIZE + Tile.TILE_SIZE / 2);
                int yCenter = (int) (i * Tile.TILE_SIZE + Tile.TILE_SIZE / 2);
                // TODO: replace booleans with parsed values from file
                int tileId = reader.nextInt();
                grid[j][i] = new Tile(Tile.getTileImage(tileId), new Location(xCenter, yCenter), 
                                      Tile.TILE_DIMENSIONS);
            }
        }
        return grid;
    }
    
    
    private Scanner getScanner() {
        String path = getClass().getResource(MAPTILES_FILENAME).getFile();
        
        Scanner s = null;
        path = path.replace("%20", " ");
        try {
            s = new Scanner(new File(path));
        }
        catch (FileNotFoundException e) {
            //TODO: Handle Exception
            e.printStackTrace();
        }
        return s;
    }
}
