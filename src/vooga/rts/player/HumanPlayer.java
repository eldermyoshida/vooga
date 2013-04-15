package vooga.rts.player;

import java.awt.Graphics2D;
import java.awt.Point;

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
    
    public void handleRightClick(int x, int y) {
        for (Unit u : getUnits().getSelected()) {
            u.move(new Location(x, y));            
        }
    }
    // Duplicate method 
    public void handlRightClick(int x, int y, int z) {
        for (Unit u : getUnits().getSelected())
        {            
            u.move(new Location(x, y), getMap());            
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
    }

}
