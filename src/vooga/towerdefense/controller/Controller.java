package vooga.towerdefense.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import vooga.towerdefense.controller.modes.ControlMode;
import vooga.towerdefense.controller.modes.SelectMode;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.GameModel;
import vooga.towerdefense.view.TDView;


/**
 * As part of a MVC framework, the Controller controls how the view interacts
 * with the model.
 * 
 * @author Jimmy Longley
 * @author Erick Gonzalez
 */
public class Controller {
    private GameModel myModel;
    private TDView myView;
	private ControlMode myControlMode;
    
    public Controller() {
        myView = new TDView(this);
        myModel = new GameModel(myView, null, new GameMap(800, 600, null));
		myControlMode = new SelectMode();
    }

    /**
     * handles a click to the map appropriately depending
     * on the mode.
     * 
     * @param p is the location of the click
     */
    public void handleMapClick(Point p) {
		myControlMode.handleMapClick(p, myModel);
    }

    /**
     * paints the map on the view.
     */
	public void paintMap(Graphics pen) {
		myModel.getMap().paint((Graphics2D) pen);
    }

    public static void main (String[] args) {
        Controller c = new Controller();

    }
}
