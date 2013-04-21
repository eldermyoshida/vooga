package vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings;
import vooga.rts.gamedesign.action.OccupyAction;
import vooga.rts.gamedesign.action.ProductionAction;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.strategy.occupystrategy.CanBeOccupied;

import vooga.rts.util.Location;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Garrison extends Building {

    public Garrison(Pixmap image, Location3D center, Dimension size, Sound sound,
                    int playerID, int health, int ID) {
        super(image, center, size, sound, playerID, health, ID);
        setOccupyStrategy(new CanBeOccupied()); 
        addOccupyActions(this);
    }
    
    public void addOccupyActions(final Building building) {
    	getActions().add(new OccupyAction("puke",null,"I puke out all I have"){
            @Override
            public void apply(int playerID) {
            	getGameUnitManager().removeEntityUnit(building);
            	getOccupyStrategy().setOccupierID(0);
            	getOccupyStrategy().setOccupiers(new ArrayList<Unit>());
            }
    	});
    }
    
    /**
     * TESTING PURPOSE
     */
    @Override
    public void update(double elapsedTime) {
        super.update(elapsedTime);
        if(getOccupyStrategy().getOccupiers().size() == 5) { 
            try {
				getActions().get(0).apply(getOccupyStrategy().getOccupierID());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
}