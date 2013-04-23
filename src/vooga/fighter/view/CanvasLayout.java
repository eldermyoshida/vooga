package vooga.fighter.view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import vooga.fighter.controller.ViewDataSource;

public abstract class CanvasLayout {
    public abstract void paintComponents (Graphics2D pen, ViewDataSource data, Dimension screenSize);
    
    protected void defaultPaint(Graphics2D pen, ViewDataSource data, int objectNumber) {
        data.getPaintable(objectNumber).paint(pen, data.getLocation(objectNumber),data.getSize(objectNumber));
    }
    
    protected void horizontalReversePaint(Graphics2D pen, ViewDataSource data, int objectNumber) {
    	pen.setTransform(AffineTransform.getScaleInstance(1, -1));
    	data.getPaintable(objectNumber).paint(pen, data.getLocation(objectNumber),data.getSize(objectNumber));
    }
}
