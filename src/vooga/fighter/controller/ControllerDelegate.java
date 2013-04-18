package vooga.fighter.controller;

/**
 * 
 * @author matthewparides
 *
 */
public interface ControllerDelegate {

    public void notifyEndCondition(String string);
    
    public void exit();

}
