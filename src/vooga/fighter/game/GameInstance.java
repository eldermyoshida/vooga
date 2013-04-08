package vooga.fighter.game;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import vooga.fighter.controller.*;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;
import vooga.fighter.util.*;
import vooga.fighter.objects.*;

/**
 * A Game instance 
 * @author Jerry
 *
 */

@InputClassTarget
public class GameInstance implements Mode {
    
    private List<GameObject> myInteractables;
    private String myID;
    private String myFilePath;
    private String myNextMode;
    private Map myNonInteractables;
    private boolean myStartGame = false;
    private Input myInput;
    
    public GameInstance (String levelName, String filePath, String nextMode, Input input) {
        myID = levelName;
        myFilePath = filePath;
        myNextMode = nextMode;
        loadLevel(filePath);
        myInput = input;
    }
    
    public void loadLevel(String filePath) {
        //Some scanner method
    }
    
    
    public void updateObjects(double stepTime, Dimension bounds) {
    	for (GameObject s : myInteractables) {
            s.update(stepTime, bounds);
        }
        myNonInteractables.update(stepTime, bounds);
    }


    @Override
    public void update (double stepTime, Dimension bounds) {
    	if (myInteractables != null) {
    	updateObjects(stepTime, bounds);
        detectCollisions(myInteractables);
        System.out.println("GameInstance initialized and updating");
    	}
    }
    
    public void detectCollisions(List<GameObject> objects) {
        for (GameObject g : objects) {
            for (GameObject o : objects) {
                detectCollision(g, o);
            }
        }
    }
    
    public void detectCollision(GameObject a, GameObject b) {
        //some sort of algorithm 
    }

    @Override
    public String getNextModeName () {
        return myNextMode;
    }

    @Override
    public String getModeName () {
        return myID;
    }

    @Override
    public boolean needNextMode () {
        return false;
    }

    @Override
    public void reset () {
        loadLevel(myFilePath);
    }

    @Override
    public void paint (Graphics2D pen) {
        paintObjects(pen);
    }
    
    public void paintObjects(Graphics2D pen) {
    	if (myInteractables != null) {
    		for (GameObject s: myInteractables) {
    			s.paint(pen);
        	}
    	
        myNonInteractables.paint(pen);
    	}
    }

    @Override
    public void setupPainting (PaintManager paintmanager) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Integer getStatus () {
        return 0;
    }
    
}
