package vooga.rts.gui.menus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import vooga.rts.gui.Menu;
import vooga.rts.gui.buttons.ScreenButton;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.util.Location;

public class MainMenu extends Menu {

	public static final String DEFAULT_BGIMAGE_LOCATION = "images/backgrounds/menu_bg.png";
	public BufferedImage myBGImage;
	private Dimension myDefaultButtonDimension = new Dimension(500, 122);

	private Location myDefaultButtonLocation = new Location(678, 350);

	private double myX;
	private double myY;

	private ScreenButton myStartButton;

	public MainMenu() {
		super();

		myBGImage = ResourceManager.instance().loadFile(
				DEFAULT_BGIMAGE_LOCATION);
		setImage(myBGImage);

		myStartButton = new ScreenButton(myDefaultButtonDimension,
				myDefaultButtonLocation);

		addButton(myStartButton);

	}

	@Override
	public void paint(Graphics2D pen) {
		myX = pen.getDeviceConfiguration().getBounds().getWidth();
		myY = pen.getDeviceConfiguration().getBounds().getHeight();
		double xFactor = myX / myBGImage.getWidth();
		double yFactor = myY / myBGImage.getHeight();
		myStartButton.setSize(new Dimension((int) (myDefaultButtonDimension
			.getWidth() * xFactor), (int) (myDefaultButtonDimension
				.getHeight() * yFactor)));

		myStartButton.setPos(new Location(
				(int) (myDefaultButtonLocation.getX() * xFactor),
				(int) (myDefaultButtonLocation.getY() * yFactor)));

		super.paint(pen);
	}
}
