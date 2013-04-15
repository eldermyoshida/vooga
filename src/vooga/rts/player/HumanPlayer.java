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
<<<<<<< HEAD
            u.move(new Location(x, y));            
        }
    }    
    
    public void handleLeftClick(int x, int y) {
        getUnits().deselectAll();
        for (Unit u : getUnits().getAllUnits())
        {         
            if (u.intersects(new Point(x, y))) {
                getUnits().select(u);
            }            
        }
=======
            u.move(new Location(x, y));
        }
    }

    public void handleLeftClick (int x, int y) {
        getUnits().select(new Point(x, y));
    }

    @Override
    public void update (Observable o, Object arg) {
        
>>>>>>> 8e147d9d1c42826cebc293468ccd937f2dbfbe75
    }

}
