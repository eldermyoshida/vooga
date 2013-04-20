package vooga.scroller.sprites.interfaces;

import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.sprites.superclasses.Player;

public interface ILevelPortal {

    public LevelPortal getLevelPortal();
    public void goToNextLevel (Player player);
}
