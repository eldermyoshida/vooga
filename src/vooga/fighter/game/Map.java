package vooga.fighter.game;

import util.Pixmap;
import vooga.fighter.objects.*;
import vooga.fighter.util.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.*;


/**
 * Map class to contain, update, and manipulate all environemtal
 * objects in a particular map. Also contains the background image and
 * music for the map.
 * 
 * @author mp
 * 
 */

public class Map {

    private List<GameObject> myEnviroObjects;
    private Pixmap myBackground;
    private Sound myMusic;

    /**
     * Constructor
     * 
     * @param enviroObjects
     * @param backG
     * @param music
     */
    public Map (List<GameObject> enviroObjects, Pixmap backG, Sound music) {
        myEnviroObjects = enviroObjects;
        myBackground = backG;
        myMusic = music;
    }

    // start Environment Object manipulators

    /**
     * adds arg GameObject to the environmental objects in this Map
     * 
     * @param g
     */
    public void addEnviroObject (GameObject g) {
        myEnviroObjects.add(g);
    }

    /**
     * return the list of Environmental objects in this map
     * 
     * @return myEnviroObjects
     */
    public List<GameObject> getEnviroObjects () {
        return myEnviroObjects;
    }

    /**
     * Adds an environment object to map
     */
    
    public void addObject(EnvironmentObject object){
    	myEnviroObjects.add(object);
    }
    
    /**
     * Creates empty list of Environment Objects
     */
    
    public void initialize(){
    	myEnviroObjects= new ArrayList<GameObject>(); 
    }
    /**
     * return the GameObject environmental object at index i of
     * myEnviroObjects.
     * 
     * @param i
     * @return
     */
    public GameObject getEnviroObjects (int i) {
        return myEnviroObjects.get(i);
    }

    /**
     * sets the environmental objects in this map to
     * arg List of GameObjects
     * 
     * @param enviroObjects
     */
    public void setEnviroObjects (List<GameObject> enviroObjects) {
        myEnviroObjects = enviroObjects;
    }

    // end Environment Object manipulators

    // start background manipulators

    /**
     * sets the background of this Map to arg Pixmap
     * 
     * @param backG
     */
    public void setBackground (Pixmap backG) {
        myBackground = backG;
    }

    /**
     * sets the background of this Map from an image at String arg file location
     * 
     * @param filename
     */
    public void setBackground (String filename) {
        myBackground = new Pixmap(filename);
    }

    /**
     * returns the Pixmap background of this map
     * 
     * @return Pixmap myBackground
     */
    public Pixmap getBackground () {
        return myBackground;
    }

    // end background manipulators;

    // start Sound manipulators

    /**
     * set the music of this map from arg Sound
     * 
     * @param s - music contained in a Sound object
     */
    public void setMusic (Sound s) {
        myMusic = s;
    }

    /**
     * set the Music of this map from a filename.
     * 
     * @param filename - file location of music.
     */
    public void setMusic (String filename) {
        myMusic = new Sound(filename);
    }

    /**
     * get the music from this Map
     * 
     * @return Sound - myMusic
     */
    public Sound getMusic () {
        return myMusic;
    }

    // end Sound manipulations

    /**
     * updates all environmental objects in this map
     * (many environmental objects are completely static and do
     * not change, i.e. platforms)
     * 
     * @param elapsedTime
     * @param bounds
     */
    public void update (double elapsedTime, Dimension bounds) {
        for (GameObject g : myEnviroObjects) {
            // g.update(elapsedTime, bounds);
        }
    }

    public void paint (Graphics2D pen) {
        paintBackground(pen);
        paintEnvironment(pen);
    }

    /**
     * paints the background of this map
     * 
     * @param pen
     */
    public void paintBackground (Graphics2D pen) {

    }

    /**
     * paints all of the enivornmental objects in this map
     * 
     * @param pen
     */
    public void paintEnvironment (Graphics2D pen) {
        for (GameObject g : myEnviroObjects) {

        }
    }
}
