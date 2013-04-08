package vooga.rts.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import vooga.rts.Game;
import vooga.rts.gui.Menu;
import vooga.rts.gui.Window;
import vooga.rts.gui.menus.MainMenu;
import vooga.rts.input.Input;
import vooga.rts.resourcemanager.ResourceManager;


public class MainController extends AbstractController implements Observer {

    private final static String DEFAULT_INPUT_LOCATION = "vooga.rts.resources.Input";
    private GameController myGameController;
    private LoadingController myLoadingController;
    private MenuController myMenuController;

    private InputController myInputController;

    private AbstractController myActiveController;

    private Window myWindow;

    private Timer myTimer;

    private Input myInput;

    public MainController () {

        myWindow = new Window();
        myGameController = new GameController();
        myGameController.addObserver(this);

        myLoadingController = new LoadingController();
        myLoadingController.addObserver(this);

        myMenuController = new MenuController();
        myMenuController.addObserver(this);
        myMenuController.addMenu(0, new MainMenu());

        myInputController = new InputController(myActiveController);
        myInput = new Input(DEFAULT_INPUT_LOCATION, myWindow.getCanvas());
        myInput.addListenerTo(myInputController);

        myActiveController = myLoadingController;

        myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run () {
                update(this.scheduledExecutionTime());
                render();
            }
        }, 500, Game.TIME_PER_FRAME());
    }

    
      public void update(double elapsedTime) {
          myActiveController.update(elapsedTime);
      }
     

    public void paint (Graphics2D pen) {
        myActiveController.paint(pen);
    }

    private void render () {
        // Get graphics and clear frame
        Graphics2D graphics = myWindow.getCanvas().getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, myWindow.getCanvas().getWidth(), myWindow.getCanvas().getHeight());
        graphics.setColor(Color.BLACK);

        // Paint stuff
        paint(graphics);

        //
        myWindow.getCanvas().render();
    }

    public AbstractController getActiveController () {
        return myActiveController;
    }

    public void setActiveController (AbstractController myController) {
        myActiveController = myController;
    }
    
    public void update (Observable myObservable, Object myObject) {
        MainState myMainState = (MainState) myObject;
        switch (myMainState) {
            case Starting:
                break;
            case Loading:
                myActiveController = myLoadingController;
                break;
            case Splash:
                
                break;
            case Menu:
                myActiveController = myMenuController;
                break;
            case Game:
                myActiveController = myGameController;
                break;
            default:
                break;
        }
    }

}
