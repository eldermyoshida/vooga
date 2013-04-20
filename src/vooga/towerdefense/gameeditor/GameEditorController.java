package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.gameElements.Wave;

/**
 * Controls the game editor.
 *
 * @author Angelica Schwartz
 */
public class GameEditorController extends JFrame {
    
    public static final String CLASS_INDICATOR_STRING = ".class";
    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    private static final String TITLE_KEYWORD = "GAME EDITOR";
    private static final Dimension SIZE = new Dimension(700, 700);
    private Dimension mySize;
    private Dimension myMapSize;
    private List<Unit> myCreatedUnits;
    private List<Wave> myCreatedWaves;
    
    /**
     * Constructor.
     * @param size
     */
    public GameEditorController(Dimension size) {
        this.setTitle(TITLE_KEYWORD);
        myCreatedUnits = new ArrayList<Unit>();
        myCreatedWaves = new ArrayList<Wave>();
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
        //update myCreatedUnits to contain the new unit
    }
    
    /**
     * gets the list of already created units.
     * @return a list of units
     */
    public List<Unit> getUnits() {
        return myCreatedUnits;
    }
    
    /**
     * gets the list of already created waves.
     * @return a list of units
     */
    public List<Wave> getWaves() {
        return myCreatedWaves;
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
       // return myMapSize; // TODO FIX THIS
        return new Dimension (500, 500);
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
    
    /**
     * Get the classes in this package.
     * @param packageName
     * @return list of classes in the package
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    @SuppressWarnings("rawtypes")
    public List<Class> getClassesInPackage(String packageName) throws IOException, ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        URL resource = classLoader.getResource(path);
        File directory = new File(resource.getFile());
        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(CLASS_INDICATOR_STRING)) {
                    classes.add(Class.forName(packageName + "." +
                            file.getName().subSequence(0, file.getName().length()
                                 - CLASS_INDICATOR_STRING.length())));
                }
            }
        }
        return classes;
    }
}
