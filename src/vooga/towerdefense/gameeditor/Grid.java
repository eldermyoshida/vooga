package vooga.towerdefense.gameeditor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Grid extends Rectangle {
    private static final long serialVersionUID = 1L;
    private static final Color PAINT_COLOR = Color.BLUE;
    private static final Color ERASE_COLOR = Color.CYAN;
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private boolean isPath;
    
    public Grid(int x, int y, int width, int height){
        super.x = x;
        super.y = y;
        super.width = width;
        super.height = height;
        isPath = false;
        
    }
    
    public void setPath (boolean path) {
        isPath = path;
    }
    
    public boolean getPathState () {
        return isPath;
    }
    
    public void paint (Graphics2D pen) {
        double thickness = 5;
        pen.setStroke(new BasicStroke((float) thickness));
        pen.drawRect(x, y, width, height);

        if (isPath == true) {
            paintHelper(pen, PAINT_COLOR, DEFAULT_COLOR);
        }
        else {
            paintHelper(pen, ERASE_COLOR, DEFAULT_COLOR);
        }
    }
    
    private void paintHelper(Graphics2D pen, Color one, Color two) {
        pen.setColor(one);
        pen.fillRect(x, y, width, height);
        pen.setColor(two);
    }
}
