package vooga.fighter.view;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import vooga.fighter.controller.ViewDataSource;

public class HorizontalReverse {
	
	public HorizontalReverse() {
		
	}
	
    protected void applyReverse(Graphics2D pen, ViewDataSource data, int objectNumber) {
    	pen.setTransform(AffineTransform.getScaleInstance(1, -1));
    	data.getPaintable(objectNumber).paint(pen, data.getLocation(objectNumber),data.getSize(objectNumber));
    }

}
