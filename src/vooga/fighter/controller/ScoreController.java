package vooga.fighter.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
import util.Location;
import util.input.AlertObject;
import util.input.Input;
import util.input.InputMethodTarget;

import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.util.Paintable;
import vooga.fighter.view.Canvas;

/**
 * 
 * @author Jerry Li
 *
 */
public class ScoreController extends Controller {
    private static final String INPUT_PATHWAY = "vooga.fighter.config.leveldefault";
    
    private Mode myMode;
    private Canvas myCanvas;

    public ScoreController (String name, Canvas frame) {
        super(name, frame);
    }

    public ScoreController (String name, Canvas frame, ControllerDelegate manager,
                            GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
    }
    
    //BUG BUG this is just copied from the Level Controller
    public void loadMode() {
        List<String> characterNames = getGameInfo().getCharacters();
        String mapID = getGameInfo().getMapName();
        LevelMode temp = new LevelMode(this, characterNames, mapID);
        setMode(temp);
    }

    
    /**
     * Exits program.
     */
    public void exit () {
        System.exit(0);
    }

   
    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new ScoreController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

    @Override
    protected Input makeInput () {
        Input input = new Input(INPUT_PATHWAY, super.getView());
        input.addListenerTo(this);
        return input;
    }
    
    @InputMethodTarget(name = "Exit_Game")
    public void playerOneJumpInput (AlertObject alObj)  {
        System.exit(0);
    }
    
    @InputMethodTarget(name = "Restart")
    public void playerOneLeftInput (AlertObject alObj) {
        System.out.println("restarting");
        notifyEndCondition(NEXT);
        
    }

	@Override
	public void notifyEndCondition(String endCondition) {
		myManager.notifyEndCondition(endCondition);
		
	}

   

}
