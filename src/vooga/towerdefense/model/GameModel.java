package vooga.towerdefense.model;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.gameElements.Wave;


/**
 * GameModel holds all of the state and behavior for a particular game of
 * towerdefense
 * 
 * @author Jimmy Longley
 * @author Erick Gonzalez
 */
public class GameModel {    
    private Controller myController;
    private List<Wave> myWaves;
    private GameMap myGameMap;
    private double myWaveTimeElapsed;
    private Wave myCurrentWave;
    private Shop myShop;

    public GameModel(Controller controller, List<Wave> waves, GameMap gameMap, Shop shop) {
        myController = controller;
        myWaves = waves;
        myGameMap = gameMap;
        myWaveTimeElapsed = 0;
        myShop = shop;
        // startNextWave();
    }
    
    public Tile getTile(Point p) {
        return myGameMap.getTile(p);
    }
    
    public Shop getShop() {
        return myShop;
    }

    public void update (double elapsedTime) {
        updateWave(elapsedTime);
        myGameMap.update(elapsedTime);
    }

    public void updateWave (double elapsedTime) {
        myWaveTimeElapsed += elapsedTime;
        if (myWaveTimeElapsed > myCurrentWave.getDuration()) {
            myWaveTimeElapsed = 0;
            startNextWave();
        }
    }

    private void startNextWave () {
        if (myWaves.iterator().hasNext()) {
            myCurrentWave = myWaves.iterator().next();
        }
        else {
            // TODO: add win behavior
            System.out.println("you win!");
        }
    }
    
    public void paintMap(Graphics2D pen) {
        myGameMap.paint(pen);
    }

    public GameMap getMap () {
        return myGameMap;
    }
}
