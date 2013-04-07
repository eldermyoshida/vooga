package controller;

import model.GameModel;


/**
 * The bridge between the model and the view. 
 * Initializes view components and updates view using information from game model
 * Point of communication between arcade and other extensible components
 * 
 * @author Xu Rui
 * 
 */

public class Controller {
    private static final String LANGUAGE = "English";
    private int DEFAULT_MOVE_VALUE = 100;
    private int DEFAULT_TURN_VALUE = 90;
    public static final String USER_DIR = "user.dir";
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.";


    private GameModel myGameModel;
    private VoogaView myView;

    
    /**
     * Constructor for controller responsible for initializing the view
     * and the parser
     */
    public Controller () {
        myGameModel = new GameModel();
        myView = new VoogaView();
    }
    
    /**
     * Initializes view components
     */
    public void createView () {

    }

    /**
     * Returns game model
     */
    private GameModel getModel () {
        return myGameModel;
    }
