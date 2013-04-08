package vooga.rts.controller;

import java.awt.Graphics2D;
import java.awt.MenuItem;
import java.util.HashMap;
import java.util.Map;
import vooga.rts.gui.Menu;

public class MenuController extends AbstractController {

    private Map<Integer, Menu> myMenus;
    private int myCurrentMenu;
    
    public MenuController () {
        myMenus = new HashMap<Integer, Menu>();
    }
    
    public void addMenu (int index, Menu menu) {
        myMenus.put(index, menu);
    }
    
    public void setMenu(int index) {
        if (myMenus.containsKey(index)) {
            myCurrentMenu = index;
        }
    }

    @Override
    public void update (double elapsedTime) {
        myMenus.get(myCurrentMenu).update(elapsedTime);        
    }

    @Override
    public void paint (Graphics2D pen) {
        myMenus.get(myCurrentMenu).paint(pen);        
    }

    @Override
    public void receiveUserInput () {
        // TODO Auto-generated method stub
        
    }

}
