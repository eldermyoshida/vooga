
package vooga.scroller.level_editor;

import games.scroller.marioGame.spritesDefinitions.MarioLib;
import games.scroller.mr_fish.sprites.FishLib;
import vooga.scroller.level_editor.controllerSuite.LEController;
import vooga.scroller.level_editor.library.BackgroundLib;


public class Main {

    /**
     * @param args
     */
    public static void main (String[] args) {
        
        String[] filenames = new String[]{"underwater1.jpg",
                                          "underwater2.jpg",
                                          "underwater3.jpg",
                                          "bikini_bottom.jpg"};
        
        LEController.runLevelEditor(new FishLib(), new BackgroundLib(filenames));
        
    }
}
