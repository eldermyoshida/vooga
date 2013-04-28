package vooga.towerdefense.model;

import java.util.HashSet;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.controller.Controller;

/**
 * 
 * @author JLongley
 *
 */
public class Player {

	private AttributeManager myAttributeManager;
	private Controller myController;
	
	public Player(Controller controller) {
		myController = controller;
		myAttributeManager = new AttributeManager();
		myAttributeManager.addAttribute(new Attribute(AttributeConstants.HEALTH, 100D));
		myAttributeManager.addAttribute(new Attribute(AttributeConstants.SCORE, 0D));
		myAttributeManager.addAttribute(new Attribute(AttributeConstants.MONEY, 1000D));
	}

	public Player(HashSet<Attribute> attributes) {
		myAttributeManager = new AttributeManager(attributes);
	}
	
	public void update(double elapsedTime) {
	    myController.displayPlayerStatistics(getPlayerDataString());
    }
	
	public String getPlayerDataString() {
		StringBuilder playerInfo = new StringBuilder("Player Attributes:\n");
		
		for(String attr : myAttributeManager.getAttributesInfo()) {
			playerInfo.append(" "+attr+"\n");
		}
		
		
//		System.out.println(playerInfo.toString());
		return playerInfo.toString();
	}

	public AttributeManager getAttributeManager() {
		return myAttributeManager;
	}
	
	public void addAttribute(Attribute newAttribute){
		myAttributeManager.addAttribute(newAttribute);
	}
}
