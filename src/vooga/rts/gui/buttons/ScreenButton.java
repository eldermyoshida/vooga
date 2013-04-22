package vooga.rts.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import vooga.rts.gui.Button;
import vooga.rts.util.Location;

public class ScreenButton extends Button {

	public int FONT_SIZE = 60;
	public static final int X_PADDING = 15;
	public static final int Y_PADDING = 15;
	public static final Color TEXT_COLOR = Color.white;
	public Color DEFAULT_FONT_COLOR = Color.white;
	public Color HOVER_FONT_COLOR = Color.blue;
	public String myText;

	public ScreenButton(String t, Dimension size, Location pos) {
		super(null, size, pos);
		myText = t;
	}

	@Override
	public void update(double elapsedTime) {
		setChanged();
		notifyObservers();
	}

	@Override
	public void paint(Graphics2D pen) {
		pen.setFont(new Font("Helvetica", Font.BOLD, FONT_SIZE));
		int cX = (int) (myPos.x + X_PADDING);
		int cY = (int) ((myPos.y + (mySize.height / 2)) + Y_PADDING);
		pen.setColor(((isFocused) ? HOVER_FONT_COLOR : DEFAULT_FONT_COLOR));
		pen.drawString(myText, cX, cY);
		super.paint(pen);
	}

	@Override
	public void processClick() {
		update(0);
	}

    @Override
    public void processHover () {
        // TODO Auto-generated method stub
        
    }



}
