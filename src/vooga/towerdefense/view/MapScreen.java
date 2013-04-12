package vooga.towerdefense.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.util.Location;

/**
 * Displays the map and everything on the map.
 * @author Angelica Schwartz
 *
 */
public class MapScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private Controller myController;
    private MouseListener myMouseListener;
    private Dimension mySize;

    /**
     * Constructor.
     * @param size
     */
    public MapScreen (Dimension size, Controller controller) {
        mySize = size;
        setPreferredSize(mySize);
        setFocusable(true);
        setVisible(true);
        myController = controller;
        makeMouseListener();
        addMouseListener(myMouseListener);
        repaint();
    }
    
    /**
     * updates the mapscreen appropriately.
     */
    public void update() {
        revalidate();
        repaint();
    }
    
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        myController.paintMap();
        paintGridLines(pen);
    }
    
    public void paintGridLines(Graphics pen) {
        for (int i = 0; i < mySize.width; i+=25)
            pen.drawLine(i, 0, i, mySize.height);
        for (int j = 0; j < mySize.height; j+=25)
            pen.drawLine(0, j, mySize.width, j);
    }
    
    /**
     * helper method to create the listener for mouse input.
     */
    //TODO: integrate this with input team
    private void makeMouseListener() {
        myMouseListener = new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent e) {
                myController.handleMapClick(e.getComponent().getLocation());
            }
            @Override
            public void mouseEntered (MouseEvent e) {
            }
            @Override
            public void mouseExited (MouseEvent e) {
            }
            @Override
            public void mousePressed (MouseEvent e) {
            }
            @Override
            public void mouseReleased (MouseEvent e) {
            }
        };
    }
}
