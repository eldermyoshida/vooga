package vooga.fighter.objects.utils;

import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;

/**
 * Holds the data needed to construct an AttackObject.
 * 
 * @author james
 *
 */
public class AttackProperties {

    private int myAttackPower;
    private int myMoveSpeed;
    private int myTimedLife;
    private int myNumFrames;
    private Vector myKnockBack;
    private Pixmap[] myImages;
    private Effect[] myEffects;
    
    public AttackProperties() {
        
    }
    
}
