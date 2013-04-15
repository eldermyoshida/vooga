<<<<<<< HEAD
package games.example;

import java.awt.Component;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.UserGameData;

public class Example extends Game {

    public Example (ArcadeInteraction arcade) {
        super(arcade);
    }

    @Override
    public UserGameData generateNewProfile () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Component createView () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void run () {
        // TODO Auto-generated method stub

    }

}
=======
package games.example;

import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.UserGameData;

public class Example extends Game {

    public Example (ArcadeInteraction arcade) {
        super(arcade);
    }

    @Override
    public UserGameData generateNewProfile () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void run () {
        System.out.println("running the game");

    }

}
>>>>>>> db33675460551d990c9a9f53b90108bfded60ff7
