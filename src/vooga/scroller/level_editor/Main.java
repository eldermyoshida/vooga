
package vooga.scroller.level_editor;

import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.sprites.test_sprites.PokemonLib;


public class Main {

    /**
     * @param args
     */
    public static void main (String[] args) {
        
        String[] filenames = new String[]{"background_small.png",
                                          "background.png",
                                          "forestbackground.jpg"};
        
        LEController con = new LEController(new PokemonLib(), new BackgroundLib(filenames));
        con.start();
        
    }
}
