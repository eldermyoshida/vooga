package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Unit;
import vooga.rts.util.Location;
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
public class AttackTower extends Building {

	public AttackTower(Pixmap image, Location center, Dimension size,
			Sound sound, int teamID, int health) {
		super(image, center, size, sound, teamID, health);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void getOccupied (Unit u) {
        // TODO Auto-generated method stub
        
    }


	
}