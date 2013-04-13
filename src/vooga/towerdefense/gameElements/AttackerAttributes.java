package vooga.towerdefense.gameElements;

public class AttackerAttributes {
	private Stat myAttackDamage;
	private Stat myAttackRadius;
	private Stat myAttackInterval;
	private Stat myNumberOfTargets;


	public AttackerAttributes(Stat dmg, Stat radius, Stat interval, Stat number) {
		myAttackDamage.updateStat(dmg.getValue());
		myAttackRadius.updateStat(radius.getValue());
		myAttackInterval.updateStat(interval.getValue());
		myNumberOfTargets.updateStat(number.getValue());

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
