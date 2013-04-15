package vooga.towerdefense.levelEditor.controller;

import java.util.ResourceBundle;
import vooga.towerdefense.levelEditor.model.LEModel;
import vooga.towerdefense.levelEditor.view.LEView;


/**
 * The controller for the Level Editor listens to input events in the
 * View hierarchy and calls mutators on the Model and View.
 * 
 * @author Yoshida
 * 
 */
public class LEController {
    private static final String LEVIEW_TITLE = "LEView";
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages.";
    private static final String USER_DIR = "user.dir";
    private String myLanguage = "English";
    
    private LEView myView;
    private LEModel myModel;
    private ResourceBundle myResources;
    
    /**
     * This is the constructor of the Level Editor.
     * It starts the View and the Model.
     */
    public LEController (String language) {
        myLanguage = language;
        myView = new LEView(this, LEVIEW_TITLE);
        myModel = new LEModel(this);
        myView.setVisible(true);
    }
    
    public String getWord (String name) {
        return myResources.getString(name);
    }
    
    public void setLanguage(String language) {
        myLanguage = language;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }
}
