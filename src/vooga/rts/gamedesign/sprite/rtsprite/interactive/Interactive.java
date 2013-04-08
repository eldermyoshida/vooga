package vooga.rts.gamedesign.sprite.rtsprite.interactive;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.RTSpriteVisitor;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings.Building;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.gamedesign.strategy.gatherstrategy.CannotGather;
import vooga.rts.gamedesign.strategy.gatherstrategy.GatherStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.CannotOccupy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.gamedesign.strategy.production.IProducer;
import vooga.rts.gamedesign.strategy.skillstrategy.SkillStrategy;
import vooga.rts.gamedesign.upgrades.Upgrade;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.gamedesign.factories.Factory;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */

public abstract class Interactive extends RTSprite implements RTSpriteVisitor {

    /**
     * the data structure for storing progress of upgrades can be changed?
     */
    private AttackStrategy myAttackStrategy;

    private GatherStrategy myGatherStrategy;
    private OccupyStrategy myOccupyStrategy;

    private UpgradeTree myUpgradeTree;

    private Integer buildTime;

    private SkillStrategy mySkillStrategy;

    private Map<String, Factory> myMakers;

    private int myVision;

    public Interactive (Pixmap image,
                        Location center,
                        Dimension size,
                        Sound sound,
                        int teamID,
                        int health) {
        super(image, center, size, sound, teamID, health);
        myMakers = new HashMap<String, Factory>();
        myAttackStrategy = new CannotAttack();
        myGatherStrategy = new CannotGather();
        myOccupyStrategy = new CannotOccupy();

    }

    /**
     * Sets the attack strategy for an interactive. Can set the interactive
     * to CanAttack or to CannotAttack and then can specify how it would
     * attack.
     * 
     * @param newStrategy is the new attack strategy that the interactive
     *        will have
     */
    public void setAttackStrategy (AttackStrategy newStrategy) {
        myAttackStrategy = newStrategy;
    }

    /**
     * Sets the gatehr strategy for an interactive. Can set the interactive
     * to CanGather or to CannotGather and then can specify how it would
     * gather.
     * 
     * @param newStrategy is the new gather strategy that the interactive
     *        will have
     */
    public void setGatherStrategy (GatherStrategy newStrategy) {
        myGatherStrategy = newStrategy;
    }

    /**
     * Sets the occupy strategy for an interactive. Can set the interactive
     * to CanOccupy or to CannotOccupy.
     * 
     * @param newStrategy is the new occupy strategy that the interactive
     *        will have
     */
    public void setOccupyStrategy (OccupyStrategy newStrategy) {
        myOccupyStrategy = newStrategy;
    }

    /**
     * Returns the current attack strategy of the interactive
     * 
     * @return the current attack strategy
     */
    public AttackStrategy getAttackstrategy () {
        return myAttackStrategy;
    }

    /**
     * upgrades the interactive based on the selected upgrade
     * 
     * @param upgrade is the upgrade that the interactive will get
     */
    public void upgrade (Upgrade upgrade) {
        upgrade.apply(this);
    }

}
