package vooga.fighter.controller;

import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;
import vooga.fighter.game.*;

import java.awt.Dimension;




/**
 * 
 * @author Jerry Li
 *
 */
public abstract class Controller implements ModelDelegate {
    
    protected Mode myGame;
    protected final Dimension DEFAULT_BOUNDS = new Dimension(800, 800);
    private ManagerDelegate myManager;
    private String myID;
    
    
    public Controller (Mode model, ManagerDelegate manager) {
        myGame = model;
        myManager = manager;
        myID = null;
    }
    
    public Controller (Mode model, String id, ManagerDelegate manager) {
        myGame = model;
        myID = id;
        myManager = manager;
    }
    
    public Controller (String id, ManagerDelegate manager) {
        myID = id;
        myManager = manager;
    }
    
    public Controller(ManagerDelegate manager) {
        myManager = manager;
    }
    
    public void update (double elapsedTime, Dimension bounds) {
        myGame.update(elapsedTime, bounds);
    }

    
    
}
