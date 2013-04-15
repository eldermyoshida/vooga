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
import vooga.rts.input.Input;
import vooga.rts.gui.Window;
import vooga.rts.util.FrameCounter;


public class MainState implements Observer, IGameLoop {

    private final static String DEFAULT_INPUT_LOCATION = "vooga.rts.resources.properties.Input";
    private Window myWindow;
    private FrameCounter myFrames;
    private Input myInput;
    private Queue<SubState> myStates;
    private SubState myActiveState;
    private Timer myTimer;
    
    public MainState () {
        myWindow = new Window();
        myWindow.setFullscreen(true);
        myStates = new LinkedList<SubState>();
        myInput = new Input(DEFAULT_INPUT_LOCATION, myWindow.getCanvas());
        myStates.add(new LoadingState(this, myInput));      
        myTimer = new Timer((int) Game.TIME_PER_FRAME(), new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                update(Game.TIME_PER_FRAME());
                render();
            }
        });
        myTimer.start();
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
        // Get graphics and clear frame
        Graphics2D graphics = myWindow.getCanvas().getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, myWindow.getCanvas().getWidth(), myWindow.getCanvas().getHeight());
        graphics.setColor(Color.BLACK);

        // Paint stuff
        paint(graphics);

        // Now, render the window
        myWindow.getCanvas().render();
    }
}
