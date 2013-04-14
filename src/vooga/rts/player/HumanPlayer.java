package vooga.rts.player;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Observable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Unit;
import vooga.rts.util.Location;


public class HumanPlayer extends Player {

    @Override
    public void update (double elapsedTime) {
        super.update(elapsedTime);
    }

    @Override
    public void paint (Graphics2D pen) {
        super.paint(pen);
    }

    public void handleRightClick (int x, int y) {
        for (Unit u : getUnits().getSelected()) {
            u.move(new Location(x, y));
        }
    }

    public void handleLeftClick (int x, int y) {
        getUnits().select(new Point(x, y));
    }

    @Override
    public void update (Observable o, Object arg) {
        
    }

}
