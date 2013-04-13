package vooga.towerdefense.gameElements;

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
	public Stat getMyAttackDamage() {
		return myAttackDamage;
	}

	public Stat getMyAttackRadius() {
		return myAttackRadius;
	}

	public Stat getMyAttackInterval() {
		return myAttackInterval;
	}

	public Stat getMyNumberOfTargets() {
		return myNumberOfTargets;
	}


}
