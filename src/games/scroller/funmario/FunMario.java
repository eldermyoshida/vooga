package games.scroller.funmario;

import arcade.games.ArcadeInteraction;
import arcade.games.GameData;
import arcade.games.UserGameData;
import vooga.scroller.model.ScrollerGame;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.view.GameView;

public class FunMario extends ScrollerGame {

    public FunMario (ArcadeInteraction arcade) {
        super(arcade);
    }

    @Override
    protected ScrollingManager setScrollingManager () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Player setPlayer (ScrollingManager sm, GameView gameView) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String setTitle () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String[] setLevelFileNames () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserGameData generateNewProfile () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GameData generateNewGameProfile () {
        // TODO Auto-generated method stub
        return null;
    }

}
