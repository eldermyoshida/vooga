package vooga.rts.gamedesign.sprite.rtsprite.interactive;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.production.IProducer;
import vooga.rts.gamedesign.strategy.skillstrategy.SkillStrategy;
import vooga.rts.gamedesign.upgrades.Upgrade;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.gamedesign.factories.Factory;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Interactive extends RTSprite {


	public IProducer myProducer;

    /** 
     *  the data structure for storing progress of upgrades can be changed? 
     */
    public AttackStrategy myAttackStrategy;

    public UpgradeTree myUpgradeTree;

    public Integer buildTime;

    public SkillStrategy mySkillStrategy;
    
    public List<Factory> myMakers;

    public Interactive (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        myMakers = new ArrayList<Factory>();
    }

    public void upgrade(Upgrade upgrade) {
    }

}