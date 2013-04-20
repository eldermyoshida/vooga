package vooga.towerdefense.model;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.factories.ExampleUnitFactory;
import vooga.towerdefense.factories.TrollUnitDefinition;
import vooga.towerdefense.factories.WaveFactory;
import vooga.towerdefense.gameElements.Wave;
import vooga.towerdefense.shop.Shop;
import vooga.towerdefense.shop.ShopItem;


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
    private Wave myCurrentWave;
    private Shop myShop;

    public GameModel(Controller controller, List<Wave> waves, GameMap gameMap, Shop shop) {
        myController = controller;
        myWaves = waves;
        myGameMap = gameMap;
        myShop = shop;
		myCurrentWave = waves.get(0);
    }
    
    public Tile getTile(Point p) {
        return myGameMap.getTile(p);
    }

    public void update (double elapsedTime) {
        updateWave(elapsedTime);
        myGameMap.update(elapsedTime);
    }

    public void updateWave (double elapsedTime) {
		myCurrentWave.update(elapsedTime);
		if (myCurrentWave.waveCompleted())
			startNextWave();
    }

    public void startNextWave () {
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
    
    public void paintShop(Graphics2D pen) { 
        myShop.paint(pen);
    }
    
    public ShopItem getShopItem(Point p) {
        return myShop.getShopItem(p);
    }
}
