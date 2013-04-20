package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

public class GameEditorController extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String TITLE_KEYWORD = "GAME EDITOR";
    private static final Dimension SIZE = new Dimension(700, 700);
    
    private Dimension mySize;
    
    public GameEditorController(Dimension size) {
        this.setTitle(TITLE_KEYWORD);
        mySize = size;
        setSize(mySize);
        setPreferredSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeGUI();
    }
    
    public void initializeGUI() {
        StartUpScreen screen = new StartUpScreen(SIZE, this);
        this.getContentPane().add(screen, BorderLayout.CENTER);
        
        this.pack();
        setVisible(true);
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
        this.getContentPane().add(screen);
        screen.display();   
        
        this.pack();
        setVisible(true);
    }
}
