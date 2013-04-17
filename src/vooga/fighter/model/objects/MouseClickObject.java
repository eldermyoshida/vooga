package vooga.fighter.model.objects;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import util.Location;
import util.Pixmap;
import vooga.fighter.model.utils.State;
import vooga.fighter.model.utils.UpdatableLocation;

public class MouseClickObject extends GameObject {
	private static final String IMAGE_LOC = "vooga.fighter.images.ball.gif";
	private static final Dimension SIZE = new Dimension(30, 30);
	private int myTicks;

	public MouseClickObject(Point2D loc) {
		State mouse = new State(this, 1);
		mouse.populateImage(new Pixmap(IMAGE_LOC), 0);
		mouse.populateSize(SIZE, 0);
		super.addState("mouse", mouse);
		super.setCurrentState("mouse");
		super.setLocation(new UpdatableLocation(loc.getX(),loc.getY()));
		myTicks = 0;
	}

	@Override
	public boolean shouldBeRemoved() {
		return(myTicks<20);
	}

	public void update() {
		myTicks ++;
	}
}
