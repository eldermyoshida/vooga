package vooga.fighter.game;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
public class Model {
    
    private List<CharacterObject> myInteractables = new ArrayList<CharacterObject>();
    private String myID;
    private String myFilePath;
    private Map myNonInteractables;
    private boolean myStartGame = false;
    private boolean shouldEnd;
    private ObjectLoader myLoader;
    private ControlDelegate myDelegate;
    
    public Model (String levelName, String filePath, ControlDelegate delegate) {
        loadFile(filePath);
        myInteractables.add(myLoader.getTestCharacter());
        shouldEnd = false;
        
        //do not delete these three!
        myID = levelName;
        myFilePath = filePath;
        myDelegate = delegate;
    }
    
    public void loadFile(String filePath) {
//        File fileName = new File(filePath);
//        Scanner scan;
//        try {
//            scan = new Scanner(fileName);
//            loadLevel(scan);
//        }
//        catch (FileNotFoundException e) {
//           System.out.println("file not found");
//        }
    }
    
    public void loadLevel(Scanner scan) {
//        while (scan.hasNextLine()) {
//            String line = scan.nextLine();
//            Scanner lineScan = new Scanner(line);
//            String className = lineScan.next();
//            Class<?> commandClass = null;
//            try {
//                commandClass = Class.forName("src/vooga.fighter.objects." + className);
//                
//            }
//            catch (ClassNotFoundException e) {
//                System.out.println("class not found");
//            }
//        }
    }
    
    public void updateObjects(double stepTime, Dimension bounds) {
    	for (CharacterObject s : myInteractables) {
            s.update(stepTime, bounds);
            if (s.getCenter().getX() >= bounds.width || s.getCenter().getX() <= 0
                || s.getCenter().getY() <= 0 || s.getCenter().getY() >= bounds.height) {
                shouldEnd = true;
            }
        }
        //myNonInteractables.update(stepTime, bounds);
    }
    
    public void switchNeed() {
        shouldEnd = !shouldEnd;
    }

    public void update (double stepTime, Dimension bounds) {
        if (myInteractables != null) {
            updateObjects(stepTime, bounds);
            detectCollisions(myInteractables);
            
        }
    }
    
    public void detectCollisions(List<CharacterObject> objects) {
        for (CharacterObject g : objects) {
            for (CharacterObject o : objects) {
                detectCollision(g, o);
            }
        }
    }
    
    public void detectCollision(GameObject a, GameObject b) {
        //some sort of algorithm 
    }

    public String getNextModeName () {
        return myNextMode;
    }

    public String getModeName () {
        return myID;
    }

    public boolean needNextMode () {
        return shouldEnd;
    }


    public void reset () {
        myInteractables.clear();
        myInteractables.add(myLoader.getTestCharacter());
    }

    public void paint (Graphics2D pen) {
        paintObjects(pen);
    }
    
    public void paintObjects(Graphics2D pen) {
    	if (myInteractables != null) {
    		for (CharacterObject s: myInteractables) {
    			s.paint(pen);
        	}
    	
        //myNonInteractables.paint(pen);
    	}
    }

    public void setupPainting (PaintManager paintmanager) {
        // TODO Auto-generated method stub
        
    }

    public Integer getStatus () {
        return 0;
    }
    
}
