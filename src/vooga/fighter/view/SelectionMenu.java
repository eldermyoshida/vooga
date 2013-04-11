package vooga.fighter.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import vooga.fighter.util.Pixmap;

//This class is intended to be used for the character and level selection menus

public class SelectionMenu {
	// public class SelectionMenu extends HUDElement {

	public SelectionMenu() {

	}

	// create an image that works as a button
	// code from
	// http://stackoverflow.com/questions/4898584/java-using-an-image-as-a-button
	private void setButtonImage(ActionListener action, MouseListener mouse)
			throws IOException {
		BufferedImage buttonIcon = ImageIO.read(new File("buttonIconPath"));
		JButton button = new JButton(new ImageIcon(buttonIcon));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.addActionListener(action);
		button.addMouseListener(mouse);
	}
	
	private void setCharacter(int player, String character){
		//set character
	}
	
	private void setLevel(String level) {
		//set level
	}

	// make a pictureless menu button
	private void makeMenuButton(String label, int x, int y, int width,
			int height, ActionListener action, MouseListener mouse) {
		JButton button = new JButton();
		button.setLabel(label);
		button.setBounds(x, y, width, height);
		// select.setLocation(x, y);
		button.addActionListener(action);
		button.addMouseListener(mouse);
	}

	// make a picture
	private void makeProfilePicture(vooga.fighter.util.Pixmap p,
			Graphics2D pen, Point2D center, Dimension size, int x, int y) {
		p.paint(pen, center, size);
	}

	public void paint(Graphics2D pen, Point2D center, Dimension size) {
		// TODO Auto-generated method stub

	}

}