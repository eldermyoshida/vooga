package vooga.scroller.level_editor;

import java.awt.Dimension;
import java.awt.Graphics2D;
import vooga.scroller.view.GameView;

public interface LevelState {

    public void update (double elapsedTime, Dimension bounds, GameView gameView);

    public void paint(Graphics2D pen);
}
