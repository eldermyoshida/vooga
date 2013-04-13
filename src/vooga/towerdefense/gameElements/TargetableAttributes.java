package vooga.towerdefense.gameElements;

public class TargetableAttributes {
	private Stat myHealth;
	private Stat myArmor;
	
	public TargetableAttributes(Stat health, Stat armor){
		myHealth=health;
		myArmor=armor;
		
	}
	public Stat getHealth(){
		return myHealth;
	}
	
	public Stat getArmor(){
		return myArmor;
	}
}
