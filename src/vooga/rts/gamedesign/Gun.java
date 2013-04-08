package vooga.rts.gamedesign;

import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.util.Location;

public class Gun extends Weapon{

	public Gun(int damage, Projectile projectile, int range, Location center) {
		super(damage, projectile, range, center);
	}

}
