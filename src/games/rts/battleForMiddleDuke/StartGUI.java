package games.rts.battleForMiddleDuke;

import vooga.rts.game.RTSGame;
import arcade.games.ArcadeInteraction;


public class StartGUI extends RTSGame
{    

    public StartGUI (ArcadeInteraction arcade) {
        super(arcade, "/games/rts/battleForMiddleDuke/GameDefinition.xml");    
        setMap("/games/rts/example/maps/peter/peter.xml");
    }

    public static void main (String[] args) {
        StartGUI f = new StartGUI(null);
        f.run();
    }
}