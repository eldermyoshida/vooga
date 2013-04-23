package vooga.towerdefense.action.actionlist;

import java.util.LinkedList;
import java.util.Queue;

import vooga.towerdefense.action.TargetedAction;
import vooga.towerdefense.factories.examples.ExampleDosProjectileFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.util.Location;

/**
 * Creates a projectile aimed at a target, target needs to be predefined by FindTarget action.
 * 
 * @author Matthew Roy
 * @author Zhen Gou
 * @author Xu Rui
 */
public class LaunchProjectile extends TargetedAction {

	private ExampleDosProjectileFactory myProjectileFactory;
	private Location myStart;
	private GameMap myMap;
    private double myFireDelay = 500;
    private double myTimer = 0;	
    private Queue<GameElement> myQueue;
    private double myLastSpawnTime;

    public LaunchProjectile (GameMap map, Location startLocation, ExampleDosProjectileFactory projectileFactory) {
    	setTargetTracking(true);
    	myProjectileFactory = projectileFactory;
    	myStart = startLocation;
    	myMap = map;
    	myQueue = new LinkedList<GameElement>();
    }

    /**
     * Creates a projectile with action of shooting at targets. 
     * Needs to figure out way to pass target information (one per follow up action or all targets for all follow up actions etc.)
     * 
     * @param elapsedTime 
     */
    @Override
    public void executeAction (double elapsedTime) {
    	/*System.out.println(getTargets().size());
    	GameElement projectile = myProjectileFactory.createElement(myStart);
        myMap.addGameElement(projectile);
        System.out.println(projectile.getTargetedActions().size()+ 10);
        for (TargetedAction t: projectile.getTargetedActions()){
            t.updateTargetedFollowUpActions(getTargets());
        }
    	//this.setEnabled(false);*/
    	launch(elapsedTime);
    }
    

    public void generateProjectile(ExampleDosProjectileFactory factory, int numProjectiles, Location startLocation){
    	for (int i=0;i<numProjectiles; i++ ){
    		myQueue.add(factory.createElement(startLocation));
    	}
    }
    
    public void launch(double elapsedTime){
    	while(!myQueue.isEmpty()){
    		myMap.addGameElement(myQueue.poll());
    		myLastSpawnTime = myTimer;
    	}
    	myTimer += elapsedTime;
    	
    }
    
    private boolean canSpawn() {
        return myTimer == 0 || (myTimer - myLastSpawnTime) > myFireDelay;
    }
}
