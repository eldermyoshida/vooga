
package vooga.scroller.sprites.state;

import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * This is our implementation of the State design pattern. This 
 * pattern is made to elegantly handle the multitude of states a 
 * sprite may be in. 
 * 
 * If you are feeling ambitious, please read up on this design pattern - 
 * http://www.cs.duke.edu/courses/compsci308/current/readings/a2-gestwicki.pdf.
 * 
 * For example: Mario may be in a number of states - 
 *      1. Invisible 
 *      2. Invincible  
 *      3. Dead 
 *      4. Huge 
 *   
 * Most sprites will not implement such a rich variety of states. 
 *   
 * @author Jay Wang
 *
 */


public interface State {

    /**
     * Updates the current state.
     * @param elapsedTime since the last update.
     * @param bounds of the current view.
     */
    public void update (double elapsedTime, Dimension bounds);
    
    /**
     * Activates this state
     */
    public void activate (); 
    
    /**
     * Deactivates this state.
     */
    public void deactivate();
    
    /**
     * Paints the state.
     * 
     * @param pen is the Graphics2D which paints.
     */
    public void paint(Graphics2D pen);
      
}
