package vooga.fighter.controller;

import java.awt.Dimension;

import arcade.util.Location;
import vooga.fighter.util.Paintable;

public interface ViewDelegate {
	
	public int ObjectNumber();
	
	public Paintable getPaintable(int index);
	
	public Location getLocation(int index);
	
	public Dimension getSize(int index);
	
	public Integer getPlayerNumber();
	
	public Integer getScore(int index);
	
	public Integer getPlayerHealth();
}
