package vooga.fighter.controller;

/**
 * 
 * @author Jerry Li
 *
 */
public interface ControlDelegate {
    
    public void checkConditions();
    
    public Controller switchMode(Controller controller);
    
    public void exit();
    
   
}
