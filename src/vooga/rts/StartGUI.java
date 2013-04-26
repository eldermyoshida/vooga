package vooga.rts;

import java.io.FileNotFoundException;
import arcade.games.ArcadeInteraction;
import vooga.rts.game.RTSGame;
import vooga.rts.resourcemanager.ImageLoader;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.resourcemanager.SoundLoader;
import vooga.rts.resourcemanager.exceptions.FileNotSupportedException;
import vooga.rts.state.MainState;


public class StartGUI extends RTSGame
{    

    public StartGUI (ArcadeInteraction arcade) {
        super(arcade);        
    }

    public static void main (String[] args) {
        StartGUI f = new StartGUI(null);
        f.run();
    }
}
