package vooga.rts.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import vooga.rts.gui.Button;
import vooga.rts.util.Location;

public class ScreenButton extends Button {

	public ScreenButton(Dimension size, Location pos) {
		
		super(null, size, pos);
	}

	@Override
	public void update(double elapsedTime) {
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void paint (Graphics2D pen) {
//		pen.setColor(Color.white);
//		pen.fill(new Rectangle2D.Double(myPos.x, myPos.y, mySize.width,
//				mySize.height));
		super.paint(pen);
	}
	

}
