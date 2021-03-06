package games.fighter.JerryJackExample.controller.levels;

import games.fighter.JerryJackExample.AdvancedGameInfo;
import vooga.fighter.controller.Controller;
import vooga.fighter.controller.gameinformation.GameInfo;
import vooga.fighter.controller.interfaces.ControllerDelegate;
import vooga.fighter.controller.interfaces.ModeCondition;
import vooga.fighter.controller.levels.MapSelectController;
import vooga.fighter.view.Canvas;



/**
 * Details a map select controller, where you can select maps
 * 
 * 
 * @author Jack Matteucci 
 * @author Jerry Li
 */


public class StockSelect extends MenuController {

    /**
     * Initial constructor
     */
    public StockSelect() {
        super();
    }

    /**
     * Concrete constructor, called when level is switched to by controllermanager
     * @param name      name of controller
     * @param frame     canvas
     * @param manager   ControllerManager
     * @param gameinfo  GameInfo
     */
    public StockSelect(String name, Canvas frame, ControllerDelegate manager, 
                               GameInfo gameinfo, String pathway) {
        super(name, frame, manager, gameinfo, pathway);
    }

    /**
     * Returns concrete controller, used when level is switched to by controllermanager
     */
    @Override
	public Controller getController(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo,
                                    String pathway) {
        return new StockSelect(name, frame, manager, gameinfo, pathway);
    }

    /**
     * Notifies the delegate when controller ends
     */
    @Override
	public void notifyEndCondition(String choice) {
        removeListener();
        getMode().resetChoice();
        getGameInfo().setMaxLives(Integer.parseInt(choice));
        System.out.println(Integer.parseInt(choice));
        System.out.println(getMode().getMenusNext(choice));
        getManager().notifyEndCondition(getMode().getMenusNext(choice));
    }

    /**
     * Removes input
     */
    @Override
	public void removeListener(){
        super.removeListener();
        getInput().removeListener(this);
    }

    /**
     * Checks conditions
     */
    @Override
	public void checkConditions(){
        for(ModeCondition condition: getConditions())
            if(condition.checkCondition(getMode())) notifyEndCondition(getMode().peekChoice());
    }
    
    public AdvancedGameInfo getGameInfo(){
    	return (AdvancedGameInfo) getGameInfo();
    }

}

