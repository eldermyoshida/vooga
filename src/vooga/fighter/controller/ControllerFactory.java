package vooga.fighter.controller;





import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import vooga.fighter.view.Canvas;


public class ControllerFactory {

    private static final String DEFAULT_RESOURCE_PACKAGE = "vooga.fighter.config.FightingManifesto";
    private static final String PACKAGE_NAME = "vooga.fighter.controller.";
    
    private Map<String, Controller> myControllerMap;
    private List<Controller> myControllerList;
    private Canvas myCanvas;
    private ResourceBundle myResources;


    public ControllerFactory(Canvas frame) {
        myControllerMap = new HashMap<String, Controller>();
        myControllerList = new ArrayList<Controller>();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
        constructControllerMap();
    } 
    
    public void constructControllerMap() {
        for (String controllerName : myResources.keySet()) {
            Controller current = createController(controllerName);
            myControllerMap.put(current.getName(), current);
        }
    }
    public Controller createController(String controllerName) {
            Object controllerObject = null;
            Controller controller = null;
            try {
                Class<?> controllerClass = null;
                String filePath = PACKAGE_NAME + controllerName;
                controllerClass = Class.forName(filePath);
                controllerObject = controllerClass.newInstance();
                controller = (Controller) controllerObject;
                controller.initializeName(myResources.getString(controllerName));
                controller.initializeName(myResources.getString(controllerName));
                System.out.println("<controller factory>: " + controller.getName() + " created");
                
            }
            catch (Exception e){
                throw new NullPointerException("No such class");
            }
        return controller;
    }
    
    public Map getMap() {
        return myControllerMap;
    }
    
    public List getList() {
        return myControllerList;
    }

}    
   



