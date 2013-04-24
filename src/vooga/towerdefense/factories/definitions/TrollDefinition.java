package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;

import vooga.towerdefense.factories.AttributeManagerFactory;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

public class TrollDefinition extends GameElementDefinition {

	public TrollDefinition() {
		myImage = new Pixmap("Troll_Sprite.gif");
    	mySize = new Dimension(50,50);
    	myCenter = new Location(0,0);
    	myType = "troll";
	}
	@Override
	public AttributeManagerFactory getAttributeManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
