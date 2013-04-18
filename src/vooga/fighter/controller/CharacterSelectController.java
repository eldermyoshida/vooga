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
 * @author Jerry Li  
 */

@InputClassTarget
public class CharacterSelectController extends MenuController {

    private static final String INPUT_PATHWAY = "vooga.fighter.config.menudefault";
    private static final String INPUT_SETTING = "vooga.fighter.config.Settings";
    private static final String TEST = "Test";
    private GameInfo myGameInfo;
    private LoopInfo myLoopInfo;

    public CharacterSelectController (String name, Canvas frame) {
        super(name, frame);
    }
        
    public CharacterSelectController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);

    }

    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new CharacterSelectController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

    /**
     * Checks this controller's end conditions
     */
    public void notifyEndCondition(String choice) {
    	if(BACK.equals(choice)) getManager().notifyEndCondition(BACK);
    	else if (getMode().getMenuNames().contains(choice)){
    		getGameInfo().setMapName(choice);
    		getManager().notifyEndCondition(NEXT);
    		}
    	}

}

