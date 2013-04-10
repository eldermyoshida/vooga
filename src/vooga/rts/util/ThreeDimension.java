package vooga.rts.util;

import java.awt.Dimension;

public class ThreeDimension extends Dimension {
	private double myX;
	private double myY;
	private double myZ;
	
	public ThreeDimension (double x, double y, double z) {
		myX = x;
		myY = y;
		myZ = z;
	}
	
	public void setX (int x) {
		myX = x;
	}
	
	public double getX() {
		return this.getWidth();
	}
	
	public void setY (int y) {
		myY = y;
	}
	
	public double getY() {
		return myY;
	}
	
	public void setZ (int z) {
		myZ = z;
	}
	
	public double getZ() {
		return myZ;
	}
}
