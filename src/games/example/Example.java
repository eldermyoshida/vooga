package games.example;

import java.io.IOException;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.UserGameData;

public class Example extends Game {

    public Example (ArcadeInteraction arcade) {
        super(arcade);
    }

    @Override
    public UserGameData generateNewProfile () {
        return new UserGameData();
    }

    @Override
    public void run () {
        String url = "http://breadfish.de/";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            // win condition is wait 5 sec.
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // update the score before killing it 
        getArcade().getUserGameData().setScore(42);
        getArcade().killGame();

    }

}
