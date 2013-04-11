package vooga.fighter.controller;

public interface ControlDelegate {
    
    public void checkConditions();
    
    public Controller switchMode(Controller controller);
    
    public void exit();
    
   
}
