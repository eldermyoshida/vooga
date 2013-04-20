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
                    int playerID, int health) {
        super(image, center, size, sound, playerID, health);
        setOccupyStrategy(new CanBeOccupied()); 
        addOccupyActions(this);
    }
    
    public void addOccupyActions(final Building building) {
    	getActions().add(new OccupyAction("puke",null,"I puke out all I have"){
            @Override
            public void apply(int playerID) {
            	getOccupyStrategy().setOccupierID(0);
            	getGameUnitManager().removeEntityUnit(building);
            }
    	});
    }
    
    @Override
    public void update(double elapsedTime) {
        super.update(elapsedTime);
        if(getOccupyStrategy().getOccupiers().size() == getOccupyStrategy().getMaxOccupiers()) { 
            try {
				getActions().get(0).apply(getOccupyStrategy().getOccupierID()); //2: for testing. make Barrack create new Units of different team.
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
}