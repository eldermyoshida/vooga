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
public class GameInstance implements Mode {
    
    private List<CharacterObject> myInteractables = new ArrayList<CharacterObject>();
    private String myID;
    private String myFilePath;
    private String myNextMode;
    private Map myNonInteractables;
    private boolean myStartGame = false;
    private Input myInput;
    private boolean shouldEnd;
    private ObjectLoader myLoader;
    
    public GameInstance (String levelName, String filePath, String nextMode, Input input) {
        myID = levelName;
        myFilePath = filePath;
        myNextMode = nextMode;
        loadFile(filePath);
        myInput = input;
        myLoader = new ObjectLoader(input);
        myInteractables.add(myLoader.getTestCharacter());
        shouldEnd = false;
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
    
    @Override
    public void switchNeed() {
        shouldEnd = !shouldEnd;
    }

    @Override
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
        return shouldEnd;
    }

    @Override
    public void reset () {
        myInteractables.clear();
        myInteractables.add(myLoader.getTestCharacter());
    }

    @Override
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

    @Override
    public void setupPainting (PaintManager paintmanager) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Integer getStatus () {
        return 0;
    }
    
}
