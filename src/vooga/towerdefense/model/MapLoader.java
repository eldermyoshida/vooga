package vooga.towerdefense.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import vooga.towerdefense.util.Location;

public class MapLoader {
    public static String MAPTILES_FILENAME = "/vooga/towerdefense/resources/map.txt";
    
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
                grid[j][i] = new Tile(Tile.getTileImage(tileId), new Location(xCenter, yCenter), Tile.TILE_DIMENSIONS);
            }
        }
        return grid;
    }
    
    public Scanner getScanner() {
        String path = getClass().getResource(MAPTILES_FILENAME).getFile();
        
        Scanner s = null;
        path.replace("%20", " " );
        try {
            s = new Scanner(new File(path));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }
}
