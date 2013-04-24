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

/**
 * 
 * @author Jack Matteucci
 * @author Jerry Li
 *
 */
public class ControllerFactory {

    private static final String DEFAULT_RESOURCE_PACKAGE = "vooga.fighter.config.FightingManifesto";
    private static final String PACKAGE_NAME = "vooga.fighter.controller.";
    
    private Map<String, Controller> myControllerMap;
    private List<Controller> myControllerList;
    private Canvas myCanvas;
    private ResourceBundle myResources;

    /**
     * Constructor - retrieves the resource bundle and constructs the map of
     * controller names (keys) and the controllers (value)
     * @param frame
     */
    public ControllerFactory(Canvas frame) {
        myControllerMap = new HashMap<String, Controller>();
        myControllerList = new ArrayList<Controller>();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
        constructControllerMap();
    } 
    
    /**
     * constructs the map of all controllers (value) associated with their names (key)
     */
    public void constructControllerMap() {
        for (String controllerName : myResources.keySet()) {
            Controller current = createController(controllerName);
            myControllerMap.put(current.getName(), current);
        }
    }
    
    /**
     * constructs a new controller from data in an xml file
     * @param controllerName
     * @return controller - the controller constructed from the xml
     */
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
                //controller.initializeName(myResources.getString(controllerName));
                
            }
            catch (Exception e){
                throw new NullPointerException("No such class");
            }
        return controller;
    }
    
    /**
     * returns the map of names and controllers
     * @return myControllerMap - map of controller names (key) and controllers (value)
     */
    public Map<String, Controller> getMap() {
        return myControllerMap;
    }
    
    /**
     * returns the list of all Controllers
     * @return myControllerList - list of all controllers
     */
    public List getList() {
        return myControllerList;
    }

}    
   



