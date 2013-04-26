package vooga.rts.game;

import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import vooga.rts.resourcemanager.ImageLoader;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.resourcemanager.SoundLoader;
import vooga.rts.state.MainState;

public class RTSGame extends Game {
    MainState myState;

    public static final int FPS = 60;
    
    private final static String DEFAULT_RESOURCE_LOCATION = "/vooga/rts/resources/";

    public static double TIME_PER_FRAME () {
        double persecond = 1 / (double) FPS;
        return persecond;
    }

    public RTSGame (ArcadeInteraction arcade) {      
        super(arcade);
        
        ResourceManager.getInstance().registerResourceLoader(new ImageLoader());
        ResourceManager.getInstance().registerResourceLoader(new SoundLoader());
        ResourceManager.getInstance().setResourceBase(DEFAULT_RESOURCE_LOCATION);        
    }

    @Override
    public void run () {
        new MainState(); 
    }
}
