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

    private Map<String, Controller> myControllerMap;
    private Canvas myCanvas;
    private ResourceBundle myResources;
    private List<String> myControllerNames;


    public ControllerFactory(Canvas frame) {
        myCanvas = frame;
        myControllerMap = new HashMap<String, Controller>();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "LevelConfig");
        myControllerNames = new ArrayList<String>();

        setupControllerConfiguration(frame, myResources, myControllerNames, myControllerMap);
    }

    public Map getMap(){
        return myControllerMap;
    }

    private void setupControllerConfiguration(Canvas frame, ResourceBundle resources, List<String> controllerName,
                                              Map<String, Controller> controllermap) {
        
        //We should probably try and find a way to get rid of these if elses. They work for now -Jerry
        for(String key: resources.keySet()){
            controllerName.add(key);
            if (key.equals("OneVOneController")) {
                Controller controller = new OneVOneController(resources.getString(key), frame);
                controllermap.put(controller.getName(), controller);
            }
            else if (key.equals("ScoreController")) {
                Controller controller = new ScoreController(resources.getString(key), frame);
                controllermap.put(controller.getName(), controller);
            }
            else if (key.equals("MenuController")) {
                Controller controller = new MenuController(resources.getString(key), frame);
                controllermap.put(controller.getName(), controller);
            }
            else if (key.equals("ModeSelectMenuController")) {
                Controller controller = new ModeSelectMenuController(resources.getString(key), frame);
                controllermap.put(controller.getName(), controller);
            }
            else if (key.equals("CharacterSelectMenuController")) {
                Controller controller = new CharacterSelectMenuController(resources.getString(key), frame);
                controllermap.put(controller.getName(), controller);
            }
        }
    }




}
