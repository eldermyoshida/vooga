package vooga.fighter.controller;

import vooga.fighter.game.GameInstance;
import vooga.fighter.game.SplashScreen;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import vooga.fighter.view.Canvas;

@InputClassTarget
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
		setupControllerConfiguration(myResources, myControllerNames);
		setupControllerMap(myCanvas, myControllerMap, myControllerNames);
	}
	
	public Map getMap(){
		return myControllerMap;
	}
	
    private void setupControllerConfiguration(ResourceBundle resources, List<String> controllerName) {
        for(String key: resources.keySet()){
            controllerName.add(key);
        }
    }
    
    private void setupControllerMap(Canvas frame, Map<String, Controller> controllermap, 
    		List<String> controllerName) {
    	for(String name: controllerName) {
            Controller controller = new LevelController(name, frame);
            controllermap.put(controller.getName(), controller);
        }
    }



}
