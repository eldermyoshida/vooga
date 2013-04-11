package vooga.fighter.controller;

import java.awt.Dimension;
import vooga.fighter.game.*;

public abstract class Controller implements ControlDelegate {
    
    private GameInstance myModel;
    private String myID;
    
    public Controller (GameInstance model) {
        myModel = model;
    }
    
    public Controller (GameInstance model, String id) {
        myModel = model;
        myID = id;
    }
    
    public Controller (String id) {
        myID = id;
    }
    
    public void update (double elapsedTime, Dimension bounds) {
        myModel.update(elapsedTime, bounds);
    }
    
    
    
    

}
