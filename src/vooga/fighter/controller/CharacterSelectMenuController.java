package vooga.fighter.controller;

import util.Location;
import util.input.AlertObject;
import util.input.Input;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import util.input.PositionObject;
import vooga.fighter.controller.Controller;
import vooga.fighter.controller.ControllerDelegate;
import vooga.fighter.controller.GameInfo;
import vooga.fighter.controller.OneVOneController;
import vooga.fighter.model.*;
import vooga.fighter.model.objects.MouseClickObject;
import vooga.fighter.util.Paintable;
import vooga.fighter.view.Canvas;

import java.awt.Dimension;
import java.util.List;
import java.util.ResourceBundle;


/**
 * 
 * @author Jack Matteucci & Jerry Li
 * 
 */

@InputClassTarget
public class CharacterSelectMenuController extends MenuController {
	
    private ResourceBundle myResources;
    private GameInfo myGameInfo;
    
    public CharacterSelectMenuController (String name, Canvas frame) {
        super(name, frame);
    }
        
    public CharacterSelectMenuController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
        myInput = manager.setInput();
        myInput.addListenerTo(this);
        myGameInfo = gameinfo;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "LevelConfig");
    }
    
    public void notifyCharacterSelection(String character) {
        myGameInfo.addCharacters(character);
    }
    /**
     * Checks this controller's end conditions
     */
    public void notifyEndCondition(String choice) {
    		getManager().notifyEndCondition(BACK);
    }


    
    @InputMethodTarget(name = "continue")
    public void mouseclick(PositionObject pos)  {
        super.getMode().addObject(new MouseClickObject(pos.getPoint2D()));
        notifyEndCondition("asdfdf");
    }

    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new CharacterSelectMenuController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

}
