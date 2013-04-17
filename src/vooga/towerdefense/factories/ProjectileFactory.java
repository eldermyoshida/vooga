package vooga.towerdefense.factories;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;
import vooga.towerdefense.util.Location;

public class ProjectileFactory {
	//this code is really bad now, need to transport fields from projectile to here
	public Projectile createProjectile(Location spawn, GameElement target){
		return new Projectile(spawn,target);
	}

}
