package vooga.rts.controller;

import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import vooga.rts.manager.Manager;
import vooga.rts.input.ActionObject;
import vooga.rts.input.AlertObject;
import vooga.rts.input.Input;
import vooga.rts.input.PositionObject;
/**
 * At the moment, the player class is implementing the humanplayer. For network
 * player and ai player, some methods will be refactored into a super class
 * 
 * @author Challen Herzberg-Brovold, Jonno Schmidt
 *
 */
public class Player implements Controller {

    private PositionObject myLeftMouse;
    private Rectangle2D myDrag;
    private Manager myManager;
    
    public Player (Manager manager) {
        myManager = manager;
    }
    
    public void sendCommand(Command command) {
            myManager.receiveCommand(command);
    }
    
    public void leftMouseDown (PositionObject o) {
        myLeftMouse = o;
    }
    
    public void leftMouseUp (PositionObject o) {
        if (myDrag == null) {            
            sendCommand(new DragCommand("drag", myDrag));
        }
        sendCommand(new LeftClickCommand("rightclick", o));
        myLeftMouse = null;
        myDrag = null;
    }
    
    public void mouseDrag (PositionObject o) {
        if (myLeftMouse != null) {
            double uX = o.getX() > myLeftMouse.getX() ? myLeftMouse.getX() : o.getX();
            double uY = o.getY() > myLeftMouse.getY() ? myLeftMouse.getY() : o.getY();            
            double width = Math.abs(o.getX() - myLeftMouse.getX());
            double height = Math.abs(o.getY() - myLeftMouse.getY());
            myDrag = new Rectangle2D.Double(uX, uY, width, height);
        }
    }
}
