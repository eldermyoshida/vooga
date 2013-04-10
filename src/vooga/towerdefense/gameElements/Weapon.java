package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Sprite;
import vooga.towerdefense.util.Vector;


/**
 * There will be two primary types of weapons - loaded and primitive.
 * A loaded weapon utilizes ammunitions, while a primitive one can be used directly without ammunitions (such as a bat or a fist).
*
 * @author XuRui
 *
 */
public abstract class Weapon extends Sprite{
	
	private static final Pixmap myImage = new Pixmap(""); //fill in image
	private Attributes myAttributes;
	
	private Vector myHeading;
	
	public Weapon(Pixmap image, Location center, Dimension size){
		super(image, center, size);
	}
	
	/**
	 * Define main weapon function for specific weapon. 
	 */
	
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
