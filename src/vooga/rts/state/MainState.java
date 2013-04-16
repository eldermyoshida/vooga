package vooga.rts.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import javax.swing.Timer;
import vooga.rts.Game;
import vooga.rts.IGameLoop;
import vooga.rts.controller.Command;
import vooga.rts.controller.InputController;
import vooga.rts.input.Input;
import vooga.rts.gui.Window;


public class MainState implements State, Observer {

    private final static String DEFAULT_INPUT_LOCATION = "vooga.rts.resources.properties.Input";
    private Window myWindow;
    private Queue<SubState> myStates; // This isn't ideal, but for now it will do the trick
    private SubState myActiveState;
    private Timer myTimer;
    private InputController myController;
    
    public MainState () {
        myWindow = new Window();
        myWindow.setFullscreen(true);
        myStates = new LinkedList<SubState>();
        Input input = new Input(DEFAULT_INPUT_LOCATION, myWindow.getCanvas());
        myController = new InputController(this);
        input.addListenerTo(myController);
        myStates.add(new LoadingState(this));
        myStates.add(new GameState(this, myWindow.getSize()));
        myTimer = new Timer((int) Game.TIME_PER_FRAME(), new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                update(Game.TIME_PER_FRAME());
                render();
            }
        });
        myTimer.start();
        setActiveState();
    }

    @Override
    public void receiveCommand (Command command) {
        myActiveState.receiveCommand(command);
    }
    
    @Override
    public void update (double elapsedTime) {
        myActiveState.update(elapsedTime);
    }
    
    @Override
    public void paint (Graphics2D pen) {
        myActiveState.paint(pen);
    }
    
    @Override
    public void update (Observable o, Object arg) {
        setActiveState();
    }
    
    private void setActiveState() {
        myActiveState = myStates.poll();
    }
    
    private void render () { // At some point, might move this method in to its own view class
        Graphics2D graphics = myWindow.getCanvas().getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, myWindow.getCanvas().getWidth(), myWindow.getCanvas().getHeight());
        graphics.setColor(Color.BLACK);
        paint(graphics);
        myWindow.getCanvas().render();
    }
}
