package vooga.fighter.controller;





import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import vooga.fighter.view.Canvas;


public class ControllerFactory {
    private static final String DEFAULT_RESOURCE_PACKAGE = "vooga.fighter.config.";
    private static final String LEVEL = "LevelConfig";
    private static final String MENU = "MenuConfig";
    private static final String SCORE = "ScoreConfig";
    private static final String ONE_V_ONE = "OneVOneController";

    private Map<String, Controller> myControllerMap;
    private Canvas myCanvas;
    private ResourceBundle myLevelResources;
    private ResourceBundle myMenuResources;
    private ResourceBundle myScoreResources;


    public ControllerFactory(Canvas frame) {
        myCanvas = frame;
        myControllerMap = new HashMap<String, Controller>();
        myLevelResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + LEVEL);
        myMenuResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + MENU);
        myScoreResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + SCORE);
        setupControllerConfiguration(frame, myLevelResources, myMenuResources,
        		myScoreResources, myControllerMap);
    }

    public Map getMap(){
        return myControllerMap;
    }

    private void setupControllerConfiguration(Canvas frame, ResourceBundle levelresources,  ResourceBundle menuresources,
    		 ResourceBundle scoreresources, Map<String, Controller> controllermap) {
        for(String key: levelresources.keySet()){
        	if (key.equals(ONE_V_ONE)) {
                Controller controller = new OneVOneController(levelresources.getString(key), frame);
                controllermap.put(controller.getName(), controller);
            }
        }
        for(String key: menuresources.keySet()){
        	Controller controller = new MenuController(menuresources.getString(key), frame);
            controllermap.put(controller.getName(), controller);
        }
        for(String key: scoreresources.keySet()){
            Controller controller = new ScoreController(scoreresources.getString(key), frame);
            controllermap.put(controller.getName(), controller);
        }
    }




}
