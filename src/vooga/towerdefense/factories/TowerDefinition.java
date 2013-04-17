package vooga.towerdefense.factories;

import util.Pixmap;

public class TowerDefinition extends GameElementDefinition {
	
	private static final Pixmap TOWER_IMAGE = new Pixmap("tower.jif");
	
	private Pixmap myImage;

	public TowerDefinition() {
		myImage = TOWER_IMAGE;
	}
	

	
	
}
