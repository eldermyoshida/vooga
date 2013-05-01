package vooga.rts.util;

import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import vooga.rts.resourcemanager.ResourceManager;


/**
 * This class represents an image on the screen and 
 * adds some utility functions to the Image class.
 * 
 * Note, Java only supports the formats: png, jpg, gif.
 * 
 * @author Robert C. Duvall
 */
public class Pixmap {
    
	private java.awt.Image myImage;
	private String myFileName;


	/**
	 * Create an image from the given filename.
	 */
	public Pixmap (String fileName) {
		setImage(fileName);
	}

	/**
	 * Create an image from the given filename.
	 */
	public Pixmap (Image image) {
		myImage = image;
	}

	/**
	 * Create a copy of image from the given other image.
	 */
	public Pixmap (Pixmap other) {
	    //this(other.myFileName);
	    this(other.myImage);
	}

	/**
	 * Set this image to the image referred to by the given filename.
	 */
	public void setImage (String fileName) {
		myImage = ResourceManager.getInstance().<BufferedImage> getFile(fileName, BufferedImage.class);
		myFileName = fileName;
	}

    /**
     * Describes how to draw the image rotated on the screen.
     */
    public void paint (Graphics2D pen, Point2D center, Dimension size, double angle) {
        // save current state of the graphics area
        AffineTransform old = new AffineTransform(pen.getTransform());
        // move graphics area to center of this shape
        pen.translate(center.getX(), center.getY());
        // rotate area about this shape
        pen.rotate(angle);
        // draw as usual (i.e., rotated)
        pen.drawImage(myImage, -size.width / 2, -size.height / 2, size.width, size.height, null);
        //pen.drawImage(myImage, 0, 0, size.width, size.height, null);
        // restore graphics area to its old state, so our changes have no lasting effects
        pen.setTransform(old);
    }
    //public void paint ()
    
    public Dimension getMyDimension() {
        return new Dimension(myImage.getWidth(null), myImage.getHeight(null));
    }
    
    public int getWidth() {
        return myImage.getWidth(null);
    }
    
    public int getHeight() {
        return myImage.getHeight(null);
    }
	/**
	 * Describes how to draw the image on the screen.
	 */
    public void paint (Graphics2D pen, Point2D center) {
		paint(pen, center, null, 0);
	
    }

	/**
	 * Describes how to draw the image on the screen.
	 */
	
    public void paint (Graphics2D pen, Point2D center, Dimension size) {
		paint(pen, center, size, 0);
	
    }
    
    public Image getImage() {
        return myImage;
    }

}
