package vooga.towerdefense.model;

import java.util.HashSet;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstantsEnum;
import vooga.towerdefense.attributes.AttributeManager;

public class Player {

	private AttributeManager myAttributeManager;
	
	public Player() {
		myAttributeManager = new AttributeManager();
		myAttributeManager.addAttribute(new Attribute(AttributeConstants(HEALTH), 100D));
		myAttributeManager.addAttribute(new Attribute(AttributeConstantsEnum.SCORE, 0D));
		myAttributeManager.addAttribute(new Attribute(AttributeConstantsEnum.MONEY, 1000D));
	}

	public Player(HashSet<Attribute> attributes) {
		myAttributeManager = new AttributeManager(attributes);
	}

	public AttributeManager getAttributeManager() {
		return myAttributeManager;
	}
	
	public void addAttribute(Attribute newAttribute){
		myAttributeManager.addAttribute(newAttribute);
	}
}
