package vooga.rts.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import vooga.rts.Game;
import vooga.rts.gui.Menu;
import vooga.rts.gui.Window;
import vooga.rts.gui.menus.MainMenu;
import vooga.rts.resourcemanager.ResourceManager;

public class MainController extends AbstractController {

    private GameController myGameController;
    private LoadingController myLoadingController;
    private MenuController myMenuController;

    private Window myWindow;

    private MainState myState;

    private Timer myTimer;

    public MainController () {
        myState = MainState.Starting;
        ResourceManager.instance().load();
        myWindow = new Window();
        myGameController = new GameController();
        myLoadingController = new LoadingController();
        myMenuController = new MenuController();
        myMenuController.addMenu(0, new MainMenu());

        myState = MainState.Loading;
        myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run () {
                update(this.scheduledExecutionTime());
                render();
            }
        }, 50, Game.TIME_PER_FRAME());  
        
        
    }    

    @Override
    public void update (double elapsedTime) {        
        switch (myState) {
            case Game:
                myGameController.update(elapsedTime);
                break;
            case Loading:
                ResourceManager.instance().load();
                myWindow.setFullscreen(true);
                setState(MainState.Splash);
                break;
            case Menu:
                myMenuController.update(elapsedTime);
                break;
            case Splash:
                if (!ResourceManager.instance().isLoading()) {                    
                    setState(MainState.Menu);
                }
                break;
            case Starting:
                // What state is this?
                break;
            default:
                break;
        }
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

    @Override
    public void paint (Graphics2D pen) {
        switch (myState) {
            case Game:
                myGameController.paint(pen);
                break;
            case Loading:                
                break;
            case Menu:
                myMenuController.paint(pen);
                break;
            case Splash:                
                myLoadingController.paint(pen);
                break;
            case Starting:
                break;
            default:
                break;
        }
    }

    public MainState getState () {
        return myState;
    }

    public void setState (MainState state) {
        this.myState = state;
    }

    @Override
    public void receiveUserInput () {
        // TODO Auto-generated method stub
        
    }

}
