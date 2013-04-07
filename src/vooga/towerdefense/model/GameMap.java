package model;
import gameElements.Tower;
import gameElements.Unit;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.Location;
import view.Tile;

public class GameMap {
    private List<Unit> myUnits;
    private Tile[][] myGrid;
    private Location myDestination;
    
    public GameMap(int height, int width, Location destination) {
        myUnits = new ArrayList<Unit>();
        myGrid = new Tile[height][width];
        myDestination = destination;
    }
    
    public void update(double elapsedTime) {
        updateUnits(elapsedTime);
        updateTiles(elapsedTime);
    }
    
    private void updateUnits(double elapsedTime) {
        for (Unit unit : myUnits) {
            unit.update(elapsedTime);
        }
    }
    
    private void updateTiles(double elapsedTime) {
        for (int i = 0; i < myGrid.length; ++i) {
            for (int j = 0; j < myGrid[i].length; ++j) {
                myGrid[i][j].update(elapsedTime);
            }
        }
    }
    
    public void spawnUnit(Unit u) {
        myUnits.add(u);
    }
    
    public void buildTower(int i, int j, Tower t) {
        myGrid[i][j].setTower(t);
    }
    
    public void sellTower(int i, int j) {
        myGrid[i][j].deleteTower();
    }
}
