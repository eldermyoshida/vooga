package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

/**
 * Controls the game editor.
 *
 * @author Angelica Schwartz
 */
public class GameEditorController extends JFrame {
    
    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    private static final String TITLE_KEYWORD = "GAME EDITOR";
    private static final Dimension SIZE = new Dimension(700, 700);
    private Dimension mySize;
    private Dimension myMapSize;
    
    /**
     * Constructor.
     * @param size
     */
    public GameEditorController(Dimension size) {
        this.setTitle(TITLE_KEYWORD);
        mySize = size;
        setSize(mySize);
        setPreferredSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeGUI();
    }
    
    /**
     * starts the visual for the game editor.
     */
    public void initializeGUI() {
        StartUpScreen screen = new StartUpScreen(SIZE, this);
        this.getContentPane().add(screen, BorderLayout.CENTER);
        
        this.pack();
        setVisible(true);
    }
    
    /**
     * adds a level to the XML file.
     */
    public void addLevelToGame() {
        //TODO: implement
        System.out.println("added level to game");         
    }
    
    /**
     * adds a map to the XML file.
     */
    public void addMapToGame() {
        //TODO: implement
        System.out.println("added map to game");        
    }
    
    /**
     * adds a projectile to the XML file.
     */
    public void addProjectileToGame() {
        //TODO: implement
        System.out.println("added projectile to game");            
    }
    
    /**
     * adds a unit to the XML file.
     */
    public void addUnitToGame() {
        //TODO: implement
        System.out.println("added unit to game");         
    }
    
    /**
     * adds a tower to the XML file.
     */
    public void addTowerToGame() {
        //TODO: implement
        System.out.println("added tower to game");
    }
    
    /**
     * adds a view to the XML file.
     */
    public void addViewToGame() {
        //TODO: implement
        System.out.println("add this view to game");        
    }
    
    /**
     * adds a wave to the XML file.
     */
    public void addWaveToGame() {
        //TODO: implement
        System.out.println("add wave to game");        
    }
    
    public void setMapSize (Dimension mapSize) {
        myMapSize = mapSize;
    }
    
    public Dimension getMapSize () {
        return myMapSize;
    }
    
    /**
     * uses reflection to display the next screen in the sequence.
     * @param nextScreenName is the next screen
     */
    @SuppressWarnings("rawtypes")
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
