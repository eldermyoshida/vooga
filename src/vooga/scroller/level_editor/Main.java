
package vooga.scroller.level_editor;

import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.util.Sprite;


public class Main {

    /**
     * @param args
     */
    public static void main (String[] args) {
        
        String[] filenames = new String[]{"background_small.png",
                                          "background.png",
                                          "forestbackground.jpg"};
        LEController con = new LEController(new MarioLib(), new BackgroundLib(filenames));
        con.start(); 
    }
}
