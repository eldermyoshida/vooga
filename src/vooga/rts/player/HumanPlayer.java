package vooga.rts.player;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import util.Location;
import vooga.rts.action.*;
import vooga.rts.commands.ClickCommand;
import vooga.rts.commands.Command;
import vooga.rts.commands.InformationCommand;
import vooga.rts.controller.Controllable;
import vooga.rts.controller.Controller;
import vooga.rts.gui.Window;
import vooga.rts.gui.menus.GameMenu;
import vooga.rts.util.Camera;


/**
 * The Player needs to do make the following decisions:
 * - does the command affect units or managers (eg. select units)?
 * - if so, does it need to be sent to server/be bounced back. If it affects
 * a manager, it can be executed immediately, but if it affects units, it
 * needs to be sent to the server.
 * - does the command affect the view or other non-gameplay related things?
 * 
 * @author Challen Herzberg-Brovold
 * 
 */
public class HumanPlayer extends Player implements Observer {

    // private Map<String, Controllable> myInputMap; // Maps the command to the appropriate
    // controllable

    private Robot myMouseMover;

    private GameMenu myGameMenu;

    public HumanPlayer (int id, int teamID) {
        super(id, teamID);
        
        myGameMenu = new GameMenu(getResources());
        myGameMenu.addObserver(this);
        myManager.addObserver(myGameMenu);

        try {
            myMouseMover = new Robot();
        }
        catch (AWTException e) {
            // Cannot move the camera
        }
        // method which adds all the inputs from controllables to them.
        // Maybe look for design pattern that can implement filtering the inputs
    }

    @Override
    public void sendCommand (Command command) {
        // Check for camera movement
        if (myGameMenu.withinBoundary(command)) {
            myGameMenu.receiveCommand(command);
        }
        else {            
            getManager().receiveCommand(command);            
        }
    }

    public void checkCameraMouse (double elapsedtime) {
        Point p = MouseInfo.getPointerInfo().getLocation();

        double x = 0;
        double y = 0;
        double setX = p.getX();
        double setY = p.getY();

        if (p.getX() <= 0) {
            x = -1 * Camera.MOVE_SPEED;
            setX = 0;
        }
        if (p.getY() <= 0) {
            y = -1 * Camera.MOVE_SPEED;
            setY = 0;
        }
        if (p.getX() >= Window.SCREEN_SIZE.getWidth() - 1) {
            x = 1 * Camera.MOVE_SPEED;
            setX = Window.SCREEN_SIZE.getWidth() - 1;
        }

        if (p.getY() >= Window.SCREEN_SIZE.getHeight() - 1) {
            y = 1 * Camera.MOVE_SPEED;
            setY = Window.SCREEN_SIZE.getHeight() - 1;
        }
        if (x != 0 || y != 0) {
            y *= elapsedtime;
            x *= elapsedtime;
            Camera.instance().moveCamera(new Location(x, y));

            myMouseMover.mouseMove((int) setX, (int) setY);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see vooga.rts.player.Player#update(double)
     */
    @Override
    public void update (double elapsedTime) {
        super.update(elapsedTime);
        checkCameraMouse(elapsedTime);
    }

    @Override
    public void paint (Graphics2D pen) {
        super.paint(pen);
        myGameMenu.paint(pen);
    }

    @Override
    public void update (Observable o, Object a) {
        if (a instanceof InformationCommand) {
            InformationCommand i = (InformationCommand) a;
            getManager().receiveCommand(i);
        } else {
            setChanged();
            notifyObservers(a);
        }
        
       
    }

}
