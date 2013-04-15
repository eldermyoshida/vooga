package vooga.rts.state;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import vooga.rts.controller.Command;
import vooga.rts.controller.MainState;
import vooga.rts.gui.Menu;
import vooga.rts.gui.menus.MainMenu;
import vooga.rts.input.PositionObject;

// I'm not really changing this class for now. 
// Low priority in terms of functionality.
// This is the same as the MenuController class
public class MenuState extends SubState implements Observer {
    private Map<Integer, Menu> myMenus;
    private int myCurrentMenu;
    
    public MenuState (Observer observer) {
        super(observer);
        myMenus = new HashMap<Integer, Menu>();
        addMenu(0, new MainMenu());
    }
    
    public void addMenu (int index, Menu menu) {
        myMenus.put(index, menu);
        menu.addObserver(this);
    }
    
    public void setMenu(int index) {
        if (myMenus.containsKey(index)) {
            myCurrentMenu = index;
        }        
    }
    
    @Override
    public void update (double elapsedTime) {        
        getCurrentMenu().update(elapsedTime);        
    }

    private Menu getCurrentMenu () {
        return myMenus.get(myCurrentMenu);
    }

    @Override
    public void paint (Graphics2D pen) {
        getCurrentMenu().paint(pen);        
    }

    public void activate () {
        setMenu(0);
    }

    public void onLeftMouseUp (PositionObject o) {        
        getCurrentMenu().handleMouseDown((int)o.getX(), (int)o.getY());
    }

    @Override
    public void update (Observable arg0, Object arg1) {
        System.out.println("I am hereby notified.");  
        setChanged();
        notifyObservers(arg1);
    }
    
    @Override
    public void receiveCommand (Command command) {
        
    }
}
