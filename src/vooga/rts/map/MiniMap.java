package vooga.rts.map;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import util.Location;
import vooga.rts.IGameLoop;


public class MiniMap implements IGameLoop {

    private GameMap myMap;
    private Dimension myMaxSize;
    private Location myScreen;
    
    private int nodesPerPixel; 

    public MiniMap (GameMap toshow, Location screen, Dimension size) {
        myMap = toshow;
        myMaxSize = size;
        myScreen = screen;
        nodesPerPixel = (int) (myMap.getNodeMap().getWidth() / size.getWidth());
    }

    @Override
    public void update (double elapsedTime) {        
        
    }

    @Override
    public void paint (Graphics2D pen) {
        for (int x = 0; x < myMap.getNodeMap().getWidth(); x += nodesPerPixel) {
            for (int y = 0; y < myMap.getNodeMap().getHeight(); y += nodesPerPixel) {
                Node n = myMap.getNodeMap().get(x, y);
                pen.fill(new Rectangle2D.Double(myScreen.getX() + x / nodesPerPixel, myScreen.getY() + y / nodesPerPixel, 1, 1));                        
            }
        }
    }
    
    

}
