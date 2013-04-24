package games.examplegenre.example2;

import java.io.IOException;
import java.util.Random;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;

public class Example2 extends Game{
    
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
        getArcade().getUserGameData(this).setScore(new Random().nextInt(100));
        getArcade().killGame();
    }

}
