
package vooga.scroller.design_patterns;


import vooga.scroller.example.sprites.Mario;
import vooga.scroller.example.sprites.MarioLib;

/** 
 * This is how we are going to handle collisions - through the Visitor 
 * design pattern. This interface is merely an extremely overloaded 
 * visit method. For every new sprite you have, you need a new visit 
 * method. Essentially, the visit method details how you will interact 
 * with the Type parameter.   
 *   
 *   
 * @author Jay Wang
 *
 */
public interface Visitor {
    
    public void visit (Mario mario); 
    public void visit (MarioLib.Coin coin);
    public void visit (MarioLib.Koopa koopa);
    public void visit (MarioLib.Platform platform);
    public void visit (MarioLib.Turtle turtle);
    

}
