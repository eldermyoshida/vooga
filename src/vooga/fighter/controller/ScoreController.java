package vooga.fighter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import vooga.fighter.game.Mode;
import vooga.fighter.input.Input;
import vooga.fighter.view.Canvas;

public class ScoreController extends Controller {
    
    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private static final String INPUT_PATHWAY = "PATHWAY";
    private Timer myTimer;
    private Mode myMode;
    private Canvas myCanvas;

    public ScoreController (String name, Canvas frame) {
        super(name, frame);
    }

    public ScoreController (String name, Canvas frame, ControllerDelegate manager,
                            GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
    }

    public void start () {
        final int stepTime = DEFAULT_DELAY;
        // create a timer to animate the canvas
        myCanvas = super.getView();
        myTimer = new Timer(stepTime,
                            new ActionListener() {
                                public void actionPerformed (ActionEvent e) {
                                    myMode.update((double) stepTime / ONE_SECOND,
                                                  myCanvas.getSize());
                                    myCanvas.paint();
                                }
                            });
        // start animation
        myTimer.start();
    }
    
    
    public void notifyEndCondition () {
        
    }

    /**
     * Exits program.
     */
    public void exit () {
        System.exit(0);
    }

    @Override
    public void stop () {
        myTimer.stop();

    }

    @Override
    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
        return new LevelController(super.getName(), super.getView(),
                                   delegate, gameinfo);
    }

    @Override
    protected Input makeInput () {
        return new Input(INPUT_PATHWAY, super.getView());
    }
    
    
    

}
