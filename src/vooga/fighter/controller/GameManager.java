package vooga.fighter.controller;

import java.awt.BorderLayout; 
import java.awt.Dimension;
import javax.swing.JFrame;
import arcade.games.UserGameData;
import vooga.fighter.model.loaders.MapLoader;
import vooga.fighter.view.Canvas;
import vooga.fighter.controller.ControllerManager;
import vooga.fighter.controller.GameInfo;
import java.util.Map;

/**
 * 
 * @author Jack Matteucci
 *
 */

public class GameManager {//extends Game{
    public static final Dimension SIZE = new Dimension(800, 600);
    public static final String TITLE = "Fighter!";
    public static final int THREE_TOP_HIGH_SCORES = 3;
    private Canvas myCanvas;
    private ControllerManager myControllerManager;
    private GameInfo myGameInfo;
    private String myHardFilePathway;

    public GameManager(){//ArcadeInteraction arcade) {
        //super(arcade);
        setFilePathway();
        myCanvas = new Canvas(SIZE); 
        myGameInfo = new GameInfo(new MapLoader(myHardFilePathway).getMapNames());
        //myGameInfo.setHighScores(getArcade().getHighScores(THREE_TOP_HIGH_SCORES));
        ControllerFactory factory = makeFactory(myCanvas,myHardFilePathway);
        ControlProgressionManager progressionmanager = makeProgression(factory.getMap());
        myControllerManager = makeManager(myCanvas, myGameInfo, factory, progressionmanager,myHardFilePathway);
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(myCanvas, BorderLayout.CENTER);
        // display them
        frame.pack();
        frame.setVisible(true);
    }

    public void run (){
        myControllerManager.run();
    }

    protected ControllerFactory makeFactory(Canvas canvas, String pathway){
        return new ControllerFactory(canvas, pathway);
    }

    protected ControllerManager makeManager(Canvas canvas, GameInfo info, ControllerFactory factory,
                                            ControlProgressionManager progression, String myFilePathway){
        return new ControllerManager(canvas, info, factory, progression, myFilePathway);
    }

    protected ControlProgressionManager makeProgression(Map map){
        return new ControlProgressionManager(map);
    }


    public UserGameData generateNewProfile(){
        return myGameInfo;
    }

    protected void setFilePathway(){
        myHardFilePathway = "vooga.fighter.";
    }




}
