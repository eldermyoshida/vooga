package vooga.towerdefense.gameElements;

/**
 * An asset can be anything useful held by a Tower or a Unit. It can be a weapon, money or anything the designer wishes to include in the game design.
 * The asset can be used only through an Action
 * 
 * @author XuRui
 *
 */

public abstract class Asset {
	
	public Asset(){
		
	}
	
	/**
	 * Use Asset, called by Action.
	 */
	public abstract void use();
	
	

}
