package vooga.rts.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import vooga.rts.gui.Button;
import vooga.rts.util.Location;

public class TextButton extends Button {

    private String myText;
    private Color myColor;
    
    public TextButton (String text, Color c, Dimension size, Location pos) {
        super(null, size, pos);
        myText = text;
        myColor = c;
    }

    @Override
    public void update (double elapsedTime) {
        System.out.println(myText);
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void paint(Graphics2D pen) {
        pen.setColor(myColor);        
        pen.fill(new Rectangle2D.Double(myPos.x, myPos.y, mySize.width, mySize.height));
        pen.setFont(new Font("Arial", Font.BOLD, 16));   
        
        int cX = (int) (myPos.x + 5);
        int cY = (int) ((myPos.y + (mySize.height / 2)) + 8);
        pen.setColor(Color.BLACK);
        pen.drawString(myText, cX, cY);
    }

}
