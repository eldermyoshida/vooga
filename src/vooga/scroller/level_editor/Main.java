
package vooga.scroller.level_editor;

import vooga.scroller.example.sprites.MarioLib;


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
