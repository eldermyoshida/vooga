package vooga.towerdefense.attributes;

import vooga.towerdefense.gameElements.Stat;

public class AttackerAttributes {
	private Stat myAttackDamage;
	private Stat myAttackRadius;
	private Stat myAttackInterval;
	private Stat myNumberOfTargets;


	public AttackerAttributes(Stat dmg, Stat radius, Stat interval, Stat number) {
		myAttackDamage=dmg;
		myAttackRadius=radius;
		myAttackInterval=interval;
		myNumberOfTargets=number;

	}
	public Stat getAttackDamage() {
		return myAttackDamage;
	}

	public Stat getAttackRadius() {
		return myAttackRadius;
	}

	public Stat getAttackInterval() {
		return myAttackInterval;
	}

	public Stat getNumberOfTargets() {
		return myNumberOfTargets;
	}


}
