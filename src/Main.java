import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.util.*;

/**
 * The one class that starts the entire project.
 * 
 * @author ADD YOUR NAME HERE
 */
public class Main {
    private Main () {
        // does not make sense to construct this class
    }

    /**
     * main --- where the program starts
     * 
     * @param args anything passed in from the command-line
     */
    public static void main (String[] args) {

            
            
        Pixmap p = new Pixmap("soldier.png");
        Location l = new Location();
        Dimension s = new Dimension();
        Sound soun = new Sound("pikachu.wav");
    
        Interactive a = new Soldier(p,l,s,soun,20,20);
        Interactive b = new Soldier(p,l,s,soun,20,20);
        
        a.visit(b);
        	
    }
}
