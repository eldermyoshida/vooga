package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameEditorController extends JFrame {

    private Dimension mySize;
    
    public GameEditorController(Dimension size) {
        mySize = size;
        setSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initializeGUI();
    }
    
    public void initializeGUI() {
        StartUpScreen screen = new StartUpScreen(mySize, this);
        add(screen);
        screen.display();
    }
    
    public void addLevelToGame() {
        //TODO: implement
        System.out.println("added level to game");         
    }
    
    public void addMapToGame() {
        //TODO: implement
        System.out.println("added map to game");        
    }
    
    public void addProjectileToGame() {
        //TODO: implement
        System.out.println("added projectile to game");            
    }
    
    public void addUnitToGame() {
        //TODO: implement
        System.out.println("added unit to game");         
    }
    
    public void addTowerToGame() {
        //TODO: implement
        System.out.println("added tower to game");
    }
    
    public void addViewToGame() {
        //TODO: implement
        System.out.println("add this view to game");        
    }
    
    public void addWaveToGame() {
        //TODO: implement
        System.out.println("add wave to game");        
    }
    
    public void displayNextScreen(String nextScreenName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Class[] args = {Dimension.class, GameEditorController.class};
        Class theClass = Class.forName(nextScreenName);
        Constructor cons = theClass.getConstructor(args);
        GameEditorScreen screen = (GameEditorScreen) cons.newInstance(mySize, this);
        screen.display();
        
    }
}
