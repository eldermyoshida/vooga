package vooga.towerdefense.gameeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.JScrollPane;
import vooga.towerdefense.gameElements.Unit;

/**
 * The UnitCatalog displays the units that the
 *      game developer has already made for this game.
 *
 * @author Angelica Schwartz
 */
public class UnitCatalog extends JScrollPane {
    
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private List<Unit> myUnitList;
    private Dimension mySize;
    
    /**
     * constructor.
     * @param units
     */
    public UnitCatalog(Dimension size, List<Unit> units) {
        mySize = size;
        setPreferredSize(size);
        myUnitList = units;
        repaint();
    }
    
    /**
     * paints the unit catalog.
     */
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(BACKGROUND_COLOR);
        pen.fillRect(0, 0, mySize.width, mySize.height);
        displayUnits(pen);
    }
    
    /**
     * draws the units on the catalog.
     * @param pen
     */
    private void displayUnits(Graphics pen) {
        int x = 0;
        int y = 0;
        for (Unit unit : myUnitList) {
            Image unitImage = unit.getPixmap().getImage();
            if (x + unitImage.getWidth(null) > mySize.width) {
                y += unitImage.getHeight(null);
                x = 0;
            }
            pen.drawImage(unitImage, x, y, unitImage.getWidth(null), unitImage.getHeight(null), null);
            x += unitImage.getWidth(null);
        }
    }
    
    

}
