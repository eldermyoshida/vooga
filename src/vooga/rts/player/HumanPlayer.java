package vooga.rts.player;

import java.awt.Graphics2D;
import java.awt.Point;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Units;
import vooga.rts.map.GameMap;
import vooga.rts.util.Location;

public class HumanPlayer extends Player {
    
    private GameMap myMap;
    @Override
    public void update (double elapsedTime) {        
        super.update(elapsedTime);
    }

    @Override
    public void paint (Graphics2D pen) {
        super.paint(pen);
    }
    
    public void handleRightClick(int x, int y) {
        for (Units u : getUnits().getSelected())
        {            
            u.move(new Location(x, y), myMap);            
        }
    }
    
    public void handleLeftClick(int x, int y) {
        getUnits().deselectAll();
        for (Units u : getUnits().getAllUnits())
        {         
            if (u.intersects(new Point(x, y))) {
                getUnits().select(u);
            }            
        }
    }

}
