package vooga.towerdefense.model;

import java.util.Scanner;
import vooga.towerdefense.util.Location;

public class MapLoader {
    public static String MAPTILES_FILENAME = "";
    
    public static Tile[][] loadTiles(int mapWidth, int mapHeight) {
        Scanner s = new Scanner(MAPTILES_FILENAME);
        int horizontalTileCount = (int) (mapWidth / Tile.TILE_SIZE);
        int verticalTileCount = (int) (mapHeight / Tile.TILE_SIZE);

        Tile[][] grid = new Tile[horizontalTileCount][verticalTileCount];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int xCenter = (int) (i * Tile.TILE_SIZE + Tile.TILE_SIZE / 2);
                int yCenter = (int) (j * Tile.TILE_SIZE + Tile.TILE_SIZE / 2);
                // TODO: replace booleans with parsed values from file
                grid[i][j] = new Tile(Tile.TILE_IMAGE, new Location(xCenter, yCenter), Tile.TILE_DIMENSIONS);
            }
        }
        
        return grid;
    }
}
