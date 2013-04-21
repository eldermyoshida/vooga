package vooga.towerdefense.factories;

import vooga.towerdefense.gameElements.GameElement;

/**
 * Creates a Tower at a specified location
 * @author XuRui
 *
 */
public class TowerFactory extends GameElementFactory {

	public TowerFactory(String name, TowerDefinition def){
		super(name, def);
	}
	
	public TowerFactory(){
		super();
	}

}
