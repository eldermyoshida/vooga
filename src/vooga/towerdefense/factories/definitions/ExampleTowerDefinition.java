package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;

import util.Location;
import util.Pixmap;
import vooga.towerdefense.factories.attributefactories.AttributeManagerFactory;

public class ExampleTowerDefinition extends GameElementDefinition {

	public ExampleTowerDefinition(Pixmap pixmap, Location putHere,
			Dimension dimension, String name) {
		super(name,pixmap, putHere, dimension);
	}

	@Override
	public AttributeManagerFactory getAttributeManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
