package arcade.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Thumbnail extends JComponent {
    
    private Pixmap myImage;
    private Dimension mySize;
    
    public Thumbnail(String filename, Dimension size) {
        this(new Pixmap(filename), size);
    }
    
    public Thumbnail(Pixmap pixmap, Dimension size) {
        myImage = pixmap;
        mySize = size;
    }

    @Override
    public void paintComponent (Graphics pen) {
        Location center = new Location(mySize.getWidth()/2, mySize.getHeight()/2);
        myImage.paint((Graphics2D) pen, center, mySize);
    }
}
