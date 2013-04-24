package games.examplegenre.example2;

import java.io.IOException;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;

public class Example2 extends Game{
    
    private static final String GAME_NAME = "example2";
    public Example2 (ArcadeInteraction arcade) {
        super(arcade);
    }

    @Override
    public void run () {
        String url = "http://belarr.com/bakercat/";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    
        // update the score before killing it 
        //getArcade().getUserGameData().setScore(42);
        getArcade().killGame();
    }

}
