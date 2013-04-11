package vooga.fighter.controller;

import java.awt.Dimension;
import vooga.fighter.game.*;

/**
 * 
 * @author Jerry Li
 *
 */
public abstract class Controller implements ControlDelegate {
    
    protected Model myModel;
    protected final Dimension DEFAULT_BOUNDS = new Dimension(800, 800);
    private ManagerDelegate myManager;
    private String myID;
    
    
    public Controller (Model model, ManagerDelegate manager) {
        myModel = model;
        myManager = manager;
        myID = null;
    }
    
    public Controller (Model model, String id, ManagerDelegate manager) {
        myModel = model;
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
        myModel.update(elapsedTime, bounds);
    }
    
    
    
    

}
