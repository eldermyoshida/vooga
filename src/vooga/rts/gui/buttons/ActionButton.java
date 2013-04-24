package vooga.rts.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import vooga.rts.gui.Button;
import vooga.rts.util.Information;
import vooga.rts.util.Location;


public class ActionButton extends ImageButton {
    
    private Information myInfo;

    public ActionButton (BufferedImage image, Dimension size, Location pos, Information i) {
        super(image, size, pos);
        myInfo = i;
    }
    
    public ActionButton (String image, Dimension size, Location pos, Information i) {
        super(image, size, pos);
        myInfo = i;
    }
    
    @Override
    public void paint (Graphics2D pen) {
        super.paint(pen);
        if (isFocused) {
            pen.drawString(myInfo.getName(), (int) myPos.getX(), (int) myPos.getY());
        }
    }
    
    @Override
    public void processHover() {
        
    }


}
