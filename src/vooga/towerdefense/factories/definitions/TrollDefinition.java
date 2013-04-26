package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;

import util.Location;
import util.Pixmap;
import vooga.towerdefense.factories.attributefactories.AttributeManagerFactory;

public class TrollDefinition extends GameElementDefinition {
	private static final String DEFAULT_NAME="troll";
	private static final Pixmap DEFAULT_IMAGE=new Pixmap("Troll_Sprite.png");
	private static final Dimension DEFAULT_SIZE=new Dimension(50,50);
	private static final Location DEFAULT_LOCATION=new Location(0,0);
	
	

	public TrollDefinition() {
		super(DEFAULT_NAME,DEFAULT_IMAGE,DEFAULT_LOCATION,DEFAULT_SIZE);
		
	}
	@Override
	public AttributeManagerFactory getAttributeManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
