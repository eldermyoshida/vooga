package vooga.towerdefense.factories;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Projectile;
import vooga.towerdefense.util.Pixmap;

public class ProjectileFactory {
	private static final AttributeConstants ATTRIBUTES_CONSTANTS=new AttributeConstants();
    private static int DEFAULT_WIDTH;
    private static final Pixmap DEFAULT_IMAGE = new Pixmap("defined by designer");
    private static final Dimension DEFAULT_SIZE = new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH);
    private static final List<Action> DEFAULT_ACTIONS = new ArrayList<Action>();
    private static final AttributeManager DEFAULT_ATTRIBUTE_MANAGER=new AttributeManager();
    
    
    
	public Projectile createProjectile(GameElement initiator, GameElement target){
		return new Projectile(DEFAULT_IMAGE,DEFAULT_SIZE,initiator,target,DEFAULT_ACTIONS,DEFAULT_ATTRIBUTE_MANAGER);
	}

}
