package vooga.towerdefense.gameElements;

import java.awt.Graphics2D;

import vooga.towerdefense.util.Location;

/**
 * Game stat object that can be added to a game element's collection of attributes.
 * Can be health, lives, damage level depending on nature of game element.
 * 
 * @author XuRui
 *
 */

public class Stat {

	private String myName;
	private double myValue;
	private double regenRate;
	private double myMaxValue;
	
	public Stat(String statName, double statValue){
		myName = statName;
		myValue = statValue;
	}
	
	public void updateStat(double value){
		myValue = value;
	}
		
	public void increment(double value){
		myValue += value;
	}
	
	public void decrement(double value){
		myValue -= value;
	}
	
	public String getDisplayableInfo(){
		String info = myName + " : " + String.valueOf(myValue);
		return info;
	}
	
	
	public double getValue(){
		return myValue;
	}
	
	public String getName(){
		return myName;
	}
	
	/**
	 * 
	 * paints a bar representing this stat
	 */
	public void paint(Graphics2D pen, Location where){
		//paints a bar representing this stat
	}
	
	
}
