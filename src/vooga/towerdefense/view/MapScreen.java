package vooga.towerdefense.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * Displays the map and everything on the map.
 * @author Angelica Schwartz
 *
 */
public class MapScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String RESOURCE = "/vooga/towerdefense/images/";
    private Controller myController;
    private MouseListener myMouseListener;
    private MouseMotionListener myMouseMotionListener;
    private Dimension mySize;
    private Image towerImage; 
    private Point mouseLocation; 
    
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
        towerImage = new ImageIcon(getClass().getResource(RESOURCE + "tower.gif")).getImage();
        makeMouseListener();
        mouseLocation = new Point(0,0);
        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseMotionListener);
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
        myController.paintMap(pen);
        paintGridLines(pen);
        if (towerImage != null) {
            pen.drawImage(towerImage, (int)mouseLocation.getX(), (int)mouseLocation.getY(), null);
        }
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
                myController.handleMapClick(e.getPoint());
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
        myMouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged (MouseEvent e) {
            }
            @Override
            public void mouseMoved (MouseEvent e) {
                //myController.handleMouseMovement(e.getPoint());
                mouseLocation = e.getPoint();
                update();
            }
        };
    }
}
