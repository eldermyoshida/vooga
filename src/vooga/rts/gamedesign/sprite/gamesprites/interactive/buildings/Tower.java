package vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.gamesprites.Projectile;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.gamedesign.strategy.gatherstrategy.CannotGather;
import vooga.rts.gamedesign.strategy.occupystrategy.CanBeOccupied;
import vooga.rts.gamedesign.strategy.production.CannotProduce;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.gamedesign.weapon.Gun;
import vooga.rts.gamedesign.weapon.Weapon;
import vooga.rts.util.Information;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

/**
 * A custom implementation of building. Instead of specifying type in XML, you
 * can specify type with default values here.
 * 
 * @author Francesco Agosti
 * 
 */
public class Tower extends Building {

	private static Pixmap DEFAULTPIX = new Pixmap("barracks.jpeg");
	private static Location3D DEFAULTLOC = new Location3D(100, 100, 100);
	private static Dimension DEFAULTSIZE = new Dimension(50, 50);
	private static Sound DEFAULTSOUND = new Sound("squirtle.wav");
	private static int DEFAULTHEALTH = 100;
	private static int DEFAULTBUILDTIME = 10;
	private static int NOTEAM = 0;
	private AttackStrategy myAttack = new CanAttack();

	public Tower (int playerID) {
        super(DEFAULTPIX, DEFAULTLOC, DEFAULTSIZE, DEFAULTSOUND, playerID, DEFAULTHEALTH,
              DEFAULTBUILDTIME);
        myAttack.addWeapon(new Weapon(new Projectile(Projectile.DEFAULT_PIC,
        		getWorldLocation(),
                Projectile.DEFAULT_DIMENSION, getPlayerID(),
                Projectile.DEFAULT_DAMAGE,
                Projectile.DEFAULT_HEALTH,800),Weapon.DEFAULT_RANGE,
                getWorldLocation(),
                Weapon.DEFAULT_COOLDOWN_TIME));
    }

	public Tower() {
		this(NOTEAM);
	}

	@Override
	public void update(double elapsedTime) {
		super.update(elapsedTime);
		if (getOccupyStrategy().getOccupiers().size() > 0) {
			setAttackStrategy(myAttack);
		}
		else {
			setAttackStrategy(new CannotAttack());
		}
		
	}

}
