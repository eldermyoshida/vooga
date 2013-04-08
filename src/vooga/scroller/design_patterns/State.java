package vooga.scroller.design_patterns;

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

    public void draw (Graphics2D pen);   
    public void update(); 
      
}
