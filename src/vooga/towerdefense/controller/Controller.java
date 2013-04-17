package vooga.towerdefense.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import vooga.towerdefense.controller.modes.BuildMode;
import vooga.towerdefense.controller.modes.ControlMode;
import vooga.towerdefense.controller.modes.SelectMode;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Tower;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.GameModel;
import vooga.towerdefense.model.Shop;
import vooga.towerdefense.model.Tile;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.view.TDView;


/**
 * As part of a MVC framework, the Controller controls how the view interacts
 * with the model.
 * 
 * @author Jimmy Longley
 * @author Erick Gonzalez
 * @author Angelica Schwartz
 */
public class Controller {
    private GameModel myModel;
    private TDView myView;
    private ControlMode myControlMode;

    // TODO: controller constructor should take waves & map in order to initialize GameModel?
    // TODO: fix where the parameters come from
    public Controller () {
        myModel = new GameModel(this, null, new GameMap(null, 800, 600, null), new Shop());
        myView = new TDView(this);
        myControlMode = new SelectMode();
    }

    /**
     * displays information about the GameElement on the tile.
     * 
     * @param p is the point that was clicked.
     */
    public void displayElementInformation (GameElement e) {
        if (e != null) {
            // TODO: update this to reflect actual properties
            myView.getTowerInfoScreen().displayInformation("Stuff about my clicked tower");
            // myView.getTowerInfoScreen().displayInformation(e.getAttributes().toString());
            if (e instanceof Tower) {
                myView.getTowerInfoScreen().displayUpgradesAndButton(((Tower) e).getUpgrades());
            }
        }
        else {
            myView.getTowerInfoScreen().clearScreen();
        }
    }

    // //testing method to check if displaying the correct info
    // public void displayTileCoordinates (Point p) {
    // Tile t = myModel.getTile(p);
    // Point center = t.getCenter();
    // System.out.println(center);
    // myView.getTowerInfoScreen().displayInformation(center.toString());
    // }

    // //testing method to check if displaying the correct info
    // public void displayTileCoordinates (Point p) {
    // Tile t = myModel.getTile(p);
    // Point center = t.getCenter();
    // System.out.println(center);
    // myView.getTowerInfoScreen().displayInformation(center.toString());
    // }

    /**
     * updates the display on the MapScreen.
     */
    public void displayMap () {
        myView.getMapScreen().update();
    }

    /**
     * places the new item onto the map & changes the mode
     * back to SelectMode.
     * 
     * @param item
     * @param p
     */
    public void fixItemOnMap (GameElement item, Point p) {
        Tile myTile = myModel.getTile(p);
        myTile.setTower(item);
        myModel.getMap().addToMap(item, myTile);
        displayMap();
        myControlMode = new SelectMode();
    }

    /**
     * gets the associated game element at a point.
     * 
     * @param p
     * @return the game element
     */
    public GameElement getItemAt (Point p) {
        Tile tile = myModel.getTile(p);
        if (tile.containsElement()) { return tile.getElement(); }
        return null;
    }

    /**
     * handles a click to the map appropriately depending
     * on the mode.
     * 
     * @param p is the location of the click
     */
    public void handleMapMouseDrag (Point p) {
        myControlMode.handleMapMouseDrag(p, this);
    }

    /**
     * handles a mouse drag on the map appropriately depending
     * on the mode.
     * 
     * @param p is the location of the mouse
     */
    public void handleMapClick (Point p) {
        myControlMode.handleMapClick(p, this);
    }

    /**
     * changes the mode to BuildMode and gets the item the user
     * wants to build from the Shop.
     * 
     * @param itemName is the name of the item the user wants to
     *        buy
     */
    public void handleShopClickOnItem (String itemName) {
        GameElement itemToBuy = myModel.getShop().getShopItem(itemName);
        BuildMode myNewMode = new BuildMode();
        myNewMode.setItemToBuild(itemToBuy);
        myControlMode = myNewMode;
    }

    // //testing method to check if displaying the correct info
    // public void displayTileCoordinates (Point p) {
    // Tile t = myModel.getTile(p);
    // Point center = t.getCenter();
    // System.out.println(center);
    // myView.getTowerInfoScreen().displayInformation(center.toString());
    // }

    // //testing method to check if displaying the correct info
    // public void displayTileCoordinates (Point p) {
    // Tile t = myModel.getTile(p);
    // Point center = t.getCenter();
    // System.out.println(center);
    // myView.getTowerInfoScreen().displayInformation(center.toString());
    // }

    // //testing method to check if displaying the correct info
    // public void displayTileCoordinates (Point p) {
    // Tile t = myModel.getTile(p);
    // Point center = t.getCenter();
    // System.out.println(center);
    // myView.getTowerInfoScreen().displayInformation(center.toString());
    // }
    
    /**
     * starts the next wave in the model.
     */
    public void startNextWave() {
        //TODO: implement next wave
        System.out.println("Wave Started");
    }

    /**
     * paints the ghost image of the item on the MapScreen
     * on the mouse's location.
     * 
     * @param p is the mouselocation
     * @param itemImage is the image
     */
    public void paintGhostImage (Point p, Pixmap itemImage) {
        displayMap();
        myView.getMapScreen().paintGhostImage(p, itemImage);
    }

    /**
     * paints the map.
     * 
     * @param pen
     */
    public void paintMap (Graphics pen) {
        myModel.paintMap((Graphics2D) pen);
    }

    /**
     * updates the model.
     * 
     * @param elapsedTime
     */
    public void update (double elapsedTime) {
        myModel.update(elapsedTime);
    }

    /**
     * upgrades the item to the new type.
     * 
     * @param upgradeName
     */
    public void upgradeSelectedItemTo (String upgradeName) {
        Tower t = (Tower) ((SelectMode) myControlMode).getCurrentlySelectedItem();
        t.upgrade(upgradeName);
        // TODO: implement upgrade stuff on backend (ask unit team for tower upgrade info!)
    }

    // //testing method to check if displaying the correct info
    // public void displayTileCoordinates (Point p) {
    // Tile t = myModel.getTile(p);
    // Point center = t.getCenter();
    // System.out.println(center);
    // myView.getTowerInfoScreen().displayInformation(center.toString());
    // }

}
