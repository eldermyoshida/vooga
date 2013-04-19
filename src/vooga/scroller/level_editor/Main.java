
package vooga.scroller.level_editor;

import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.util.Sprite;


public class Main {

    /**
     * @param args
     */
    public static void main (String[] args) {
        
        LEController con = new LEController(new MarioLib());
        con.start(); 
    }
}
