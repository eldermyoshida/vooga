package vooga.rts.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;
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

    private MainState myGameState;

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

        myInputController = new InputController(this);
        myInput = new Input(DEFAULT_INPUT_LOCATION, myWindow.getCanvas());
        myInput.addListenerTo(myInputController);

        myWindow.setFullscreen(true);

        myGameState = MainState.Loading;
        setActiveController(myLoadingController);

        myTimer = new Timer((int) Mode.TIME_PER_FRAME(), new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                update(Mode.TIME_PER_FRAME());
                render();
            }
        });
        myTimer.start();
    }

    public void update (double elapsedTime) {
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
        myInputController.setActiveController(myController);
        myActiveController.activate(myGameState);
    }

    @Override
    public void update (Observable myObservable, Object myObject) {
        if (!(myObject instanceof MainState)) {
            return;
        }
        myGameState = (MainState) myObject;
        switch (myGameState) {
            case Starting:
                break;
            case Loading:
                setActiveController(myLoadingController);
                break;
            case Splash:
                setActiveController(myLoadingController);
                break;
            case Menu:
                setActiveController(myMenuController);
                break;
            case Mode:
                setActiveController(myGameController);
                break;
            default:
                break;
        }
    }

    @Override
    public void activate (MainState gameState) {
    }
}
