package vooga.rts.controller;

import java.awt.geom.Rectangle2D;
import vooga.rts.input.InputClassTarget;
import vooga.rts.input.InputMethodTarget;
import vooga.rts.input.PositionObject;
import vooga.rts.state.State;

/** 
 * After much thought, I've decided to only have one InputController. This controller
 * sends the formatted inputs to the main state, which relays them to the appropriate 
 * state.
 * @author Challen Herzberg-Brovold
 *
 */
@InputClassTarget
public class InputController implements Controller {

    private State myState;
    private PositionObject myLeftMouse;
    private Rectangle2D myDrag;
    
    public InputController (State state) {
        myState = state;
    }
    
    @Override
    public void sendCommand (Command command) {
        myState.receiveCommand(command);   
    }
    
    @InputMethodTarget(name  = "leftMouseDown")
    public void leftMouseDown (PositionObject o) {
        myLeftMouse = o;
    }
    
    @InputMethodTarget(name  = "leftMouseDown")
    public void leftMouseUp (PositionObject o) {
        if (myDrag == null) {            
            sendCommand(new DragCommand("drag", myDrag));
        }
        else{
            sendCommand(new ClickCommand("leftclick", o));
        }
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
