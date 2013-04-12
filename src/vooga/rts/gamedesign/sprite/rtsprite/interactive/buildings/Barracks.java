package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.EntityVisitor;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.strategy.production.Producer;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Barracks extends Building {

    public Barracks(Pixmap image, Location center, Dimension size, Sound sound,
                    int teamID, int health) {
        super(image, center, size, sound, teamID, health);
        // TODO Auto-generated constructor stub
    }

  
 

}