package vooga.towerdefense.levelEditor.model;

import vooga.towerdefense.levelEditor.controller.LEController;
import vooga.towerdefense.util.XMLBuilder;


/**
 * The model of the Tower Defense Level Editor has the purpose of processing
 * the information from the <code>LEView</code>.
 * 
 * @author Yoshida
 * 
 */
public class LEModel {
    private LEController myController;
    private XMLBuilder myFile;
    
    public LEModel (LEController controller) {
        myController = controller;
    }
    
}
