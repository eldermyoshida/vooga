package vooga.towerdefense.gameeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vooga.towerdefense.gameElements.Unit;

/**
 * The Catalog displays the images that the
 *      game developer has already made for this game.
 *
 * @author Angelica Schwartz
 */
public class Catalog extends JPanel {
    
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final int SIDE_LENGTH = 50;
    private List<Image> myIconList;
    private Dimension mySize;
    
    /**
     * constructor.
     * @param units
     */
    public Catalog(Dimension size, List<Image> images) {
        mySize = size;
        setPreferredSize(size);
        myIconList = images;
        repaint();
    }
    
    /**
     * paints the unit catalog.
     */
    @Override
    public void paint(Graphics pen) {
        super.paintComponent(pen);
        System.out.println("painting catalog");
        pen.setColor(BACKGROUND_COLOR);
        pen.fillRect(0, 0, mySize.width, mySize.height);
        displayUnits(pen);
    }
    
    /**
     * draws the units on the catalog.
     * @param pen
     */
    //TODO: figure out what to do if there are more units than can show
    private void displayUnits(Graphics pen) {
        int x = 0;
        int y = 0;
        for (Image image : myIconList) {
            if (x + SIDE_LENGTH > mySize.width) {
                y += SIDE_LENGTH;
                x = 0;
            }
            pen.drawImage(image, x, y, SIDE_LENGTH, SIDE_LENGTH, null);
            x += SIDE_LENGTH;
        }
    }
    
    

}
