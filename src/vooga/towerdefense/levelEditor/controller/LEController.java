package vooga.towerdefense.levelEditor.controller;

import vooga.towerdefense.levelEditor.model.LEModel;
import vooga.towerdefense.levelEditor.view.LEView;


/**
 * The controller for the Level Editor listens to input events in the
 * View hierarchy and calls mutators on the Model and View.
 * 
 * @author Yoshida
 * 
 */
public class LEController {
    private LEView myView;
    private LEModel myModel;
    
    /**
     * This is the constructor of the Level Editor.
     * It starts the View and the Model.
     */
    public LEController () {
        myView = new LEView(this);
        myModel = new LEModel(this);
        myView.setVisible(true);
    }
}
