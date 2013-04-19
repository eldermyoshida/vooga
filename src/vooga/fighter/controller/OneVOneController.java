package vooga.fighter.controller;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import util.Location;
import util.input.*;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.util.Paintable;
import vooga.fighter.view.Canvas;


/**
 * 
 * @author Jerry Li
 * 
 * @Modified by Jack Matteucci
 * 
 */
@InputClassTarget

public class OneVOneController extends LevelController {
    private static final String INPUT_PATHWAY = "vooga.fighter.config.leveldefault";
    private List<CharacterObject> myInputObjects;

    public OneVOneController (String name, Canvas frame) {
        super(name, frame);
        
    }
	
    public OneVOneController(String name, Canvas frame, ControllerDelegate manager, 
    		GameInfo gameinfo) {
    	super(name, frame, manager, gameinfo);
    }

    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new OneVOneController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

    @Override
    public void notifyEndCondition (String endCondition) {
    	getInput().removeListener(this);
    	getManager().notifyEndCondition(NEXT);
    }
    
    
    
}