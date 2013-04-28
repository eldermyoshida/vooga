package util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import sun.awt.image.ToolkitImage;


/**
 * This class represents an image on the screen and
 * adds some utility functions to the Image class.
 * 
 * Note, Java only supports the formats: png, jpg, gif.
 * 
 * @author Robert C. Duvall, Dagbedji F, edited by @author Yoshida, @author Xu Rui, @author
 *         Bill Muensterman and @author Wayne You added paintReverse
 */
public class Pixmap implements Paintable {
	// OS-independent relative resource locations (like URLs)
	private static final String RESOURCE_LOCATION = "/vooga/";

	private java.awt.Image myImage;
	private String myFileName;

	/**
	 * Create an image from the given filename.
	 */
	public Pixmap(String fileName) {
		setImage(fileName);
	}

	/**
	 * Create a copy of image from the given other image.
	 */
	public Pixmap(Pixmap other) {
		this(other.myFileName);
	}

	/**
	 * Set this image to the image referred to by the given filename.
	 */
	public void setImage(String fileName) {
		myImage = new ImageIcon(getClass().getResource(
				RESOURCE_LOCATION + fileName)).getImage();
		//setImageToGreyScale();
		myFileName = fileName;
	}

	/**
	 * Returns the size of the image
	 */
	public Dimension getSize() {
		return new Dimension(myImage.getWidth(null), myImage.getHeight(null));
	}

	/**
	 * Describes how to draw the image on the screen.
	 */
	public void paint(Graphics2D pen, Point2D center, Dimension size) {
		paint(pen, center, size, 0);
	}

	/**
	 * Describes how to draw the image rotated on the screen.
	 */
	public void paint(Graphics2D pen, Point2D center, Dimension size,
			double angle) {
		// save current state of the graphics area
		AffineTransform old = new AffineTransform(pen.getTransform());
		// move graphics area to center of this shape
		pen.translate(center.getX(), center.getY());
		// rotate area about this shape
		pen.rotate(angle);
		// draw as usual (i.e., rotated)
		pen.drawImage(myImage, -size.width / 2, -size.height / 2, size.width,
				size.height, null);
		// restore graphics area to its old state, so our changes have no
		// lasting effects
		pen.setTransform(old);
	}
	
	/**
	 * Reverse the pen before painting
	 * @param pen
	 * @param center
	 * @param size
	 */

	public void paintReverse(Graphics2D pen, Point2D center, Dimension size) {
		// Get the current transform
		AffineTransform saveAT = pen.getTransform();
		// Perform transformation
		pen.transform(AffineTransform.getScaleInstance(-1, 1));
		// Render
		paint(pen, center, size);
		// Restore original transform
		pen.setTransform(saveAT);

	}
	
/**
 * Uses BufferedImages and ToolKitImages to set an image to grayscale
 */
	public void setImageToGrayscale() {
		BufferedImage buffered = ((ToolkitImage) myImage).getBufferedImage();
		BufferedImage temp = new BufferedImage(buffered.getWidth(),
				buffered.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		temp.getScaledInstance(buffered.getWidth(), buffered.getHeight(), 0);
		Graphics g = temp.getGraphics();
		g.drawImage(buffered, 0, 0, null);
		buffered = temp;
		g.dispose();
		myImage = (Image) buffered;
	}

	/**
	 * Gets the image of this <code>Pixmap</code> as a
	 * <code>java.awt.Image</code>
	 * 
	 * @return the image of this <code>Pixmap</code> as a
	 *         <code>java.awt.Image</code>
	 */
	public Image getImg() {
		return myImage;
	}
}
