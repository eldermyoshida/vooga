package vooga.towerdefense.gameElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Vector;


/**
 * There will be two primary types of weapons - loaded and primitive.
 * A loaded weapon utilizes ammunitions, while a primitive one can be used directly without ammunitions (such as a bat or a fist).
*
 * @author XuRui
 *
 */
public abstract class Weapon extends Asset{
	
	private static final Pixmap myImage = new Pixmap(""); //fill in image
	private Attributes myAttributes;
	private List<Ammunition> myAmmo;
	private Vector myHeading;
	
	public Weapon(){
		myAmmo = new ArrayList<Ammunition>();
	}
	
	/**
	 * Define main weapon function for specific weapon. 
	 */
	@Override
	public abstract void use();
	
	
	/**
	 * Action available for loaded weapons.
	 */
	public abstract void shoot();
	
	/**
	 * Action available for primitive weapons.
	 */
	public abstract void attack(Object target);
	
	
	public abstract void upgradeWeapon(Stat stat);




}
