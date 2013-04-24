package vooga.scroller.sprites.movement;


/**
 * Abstract superclass using the strategy design pattern. Every movement of 
 * a NonStaticEntity will extend Movement. Thus, each NonStaticEntity only needs 
 * an instance of the Movement they want. They can then call execute on their 
 * Movement object to get the vector they need. 
 * <br>
 * <br>
 * If you want to create a new Movement type, extend this class and implement an 
 * execute() method for that specific Movement subclass. If you need parameters that 
 * are not offered here, add the execute method signature you need and override 
 * that execute() method in your subclass. 
 * 
 * @author Jay Wang
 *
 */
public interface Movement {
    
    /**
     * Executes this movement.
     */
    public void execute();

}
