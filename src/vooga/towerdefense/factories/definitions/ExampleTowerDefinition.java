package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;

import vooga.towerdefense.factories.AttributeManagerFactory;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

public class ExampleTowerDefinition extends GameElementDefinition {

	public ExampleTowerDefinition(Pixmap pixmap, Location putHere,
			Dimension dimension, String string) {
		super(pixmap, putHere, dimension, string);
	}

	@Override
	public AttributeManagerFactory getAttributeManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
