package design_patterns;


import test_sprites.Coin;
import test_sprites.Koopa;
import test_sprites.Mario;
import test_sprites.Platform;
import test_sprites.Turtle;

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
    public void visit (Coin coin);
    public void visit (Koopa koopa);
    public void visit (Platform platform);
    public void visit (Turtle turtle);
    

}
