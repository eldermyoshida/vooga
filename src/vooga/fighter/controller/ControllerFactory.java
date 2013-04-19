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

    public static final String ONE_V_ONE = "test";
    public static final String MAIN_MENU = "MainMenu";
    public static final String CHARACTER_SELECT = "CharacterSelectMenu";
    public static final String MAP_SELECT = "MapSelectMenu";
    public static final String MODE_SELECT = "ModeSelectMenu";
    public static final String SCORE_CONTROLLER = "GameOver";

    private Map<String, Controller> myControllerMap;
    private Canvas myCanvas;
    private ResourceBundle myLevelResources;
    private ResourceBundle myMenuResources;
    private ResourceBundle myScoreResources;


    public ControllerFactory(Canvas frame) {
        myCanvas = frame;
        myControllerMap = new HashMap<String, Controller>();
        setupControllerConfiguration(frame, myControllerMap);
    } 

    public Map getMap(){
        return myControllerMap;
    }

    protected void setupControllerConfiguration(Canvas frame,  Map<String, Controller> controllermap) {
                Controller controller = new OneVOneController(ONE_V_ONE, frame);
                controllermap.put(controller.getName(), controller);
                controller = new MainMenuController(MAIN_MENU, frame);
                controllermap.put(controller.getName(), controller);
                controller = new CharacterSelectController(CHARACTER_SELECT, frame);
                controllermap.put(controller.getName(), controller);
                controller = new MapSelectController(MAP_SELECT, frame);
                controllermap.put(controller.getName(), controller);
                controller = new ScoreController(SCORE_CONTROLLER, frame);
                controllermap.put(controller.getName(), controller);
                controller = new ModeSelectMenuController(MODE_SELECT, frame);
                controllermap.put(controller.getName(), controller);
        }
    }



