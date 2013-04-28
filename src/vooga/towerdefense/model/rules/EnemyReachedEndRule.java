package vooga.towerdefense.model.rules;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameModel;
import vooga.towerdefense.model.Tile;

/**
 * This rule decrements your health when an enemy reaches the goal without dying.
 * @author JLongley
 *
 */
public class EnemyReachedEndRule extends Rule {
	
	private final double HEALTH_COST = 1;

	List<GameElement> enemiesAtEnd;
	
	public EnemyReachedEndRule(GameModel model) {
		super(model);
		enemiesAtEnd = new ArrayList<GameElement>();
	}

	@Override
	protected boolean condition() {
		for(GameElement e : myModel.getMap().getAllGameElements()) {
			//TODO: fix the affiliation code
			////if the element's affiliation is 1, aka, it is an enemy unit
			//if( Math.floor(e.getAttributeManager().getAttribute("affilitation").getValue()) == 1) {
				Tile enemyTile = myModel.getMap().getTile(e.getCenter());
				Tile endTile = myModel.getMap().getTile(myModel.getMap().getEndLocation());
				if(enemyTile == endTile)
				{ //enemy reached tile
					enemiesAtEnd.add(e);
				}
			//}
		}
		return (enemiesAtEnd.size()>0);
	}

	@Override
	protected void execute() {
		for(GameElement e: enemiesAtEnd) {
			Attribute health = myModel.getPlayer().getAttributeManager().getAttribute(AttributeConstants.HEALTH);
			health.setValue(health.getValue()-HEALTH_COST);
			myModel.getMap().removeGameElement(e);
		}
		enemiesAtEnd.clear();
	}

}
