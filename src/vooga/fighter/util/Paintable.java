package vooga.fighter.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import vooga.fighter.controller.ViewDataSource;


public interface Paintable {

    public void paint (Graphics2D pen, Point2D center, Dimension size);
    
    //public void paintReverse(Graphics2D pen, Point2D center, Dimension size);

	void paintReverse(Graphics2D pen, Point2D center, Dimension size);
}