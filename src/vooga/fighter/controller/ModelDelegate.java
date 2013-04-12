package vooga.fighter.controller;



/**
 * 
 * @author Jerry Li
 *
 */
public interface ModelDelegate {
    
    public void checkConditions();
    
    public Controller switchMode(Controller controller);
    
    public void exit();
    
    
    //these shouldn't be called by controller. These are model methods
    //that then call the methods above. Right??
//    public void WonLevel();
//
//    public void LostLevel();
//
//    public void PlayerHealth(int a);
    
   
}
