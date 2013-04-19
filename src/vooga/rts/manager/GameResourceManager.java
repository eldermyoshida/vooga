package vooga.rts.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vooga.rts.IObservable;
import vooga.rts.gamedesign.sprite.gamesprites.Resource;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.player.IGameManagerObserver;
import vooga.rts.player.IProductionObserver;

/**
 * This class stores all the resources in the game and manages their 
 * distribution among players.
 * It provides methods to check if the player has enough resources to
 * purchase something and it also provides methods to use a resource
 * and add to a resource.
 * 
 * @author Jonathan Schmidt
 * 
 */
public class GameResourceManager implements IManagerObservable{
    
	private List<IGameManagerObserver> myObservers;
	private List<Resource> myUnassignedResources;
	private Map<Integer, HashMap<String, Integer>> myPlayerResources;
    //private Map<String, Integer> myResources;
    
    public GameResourceManager() {
    	myObservers = new ArrayList<IGameManagerObserver>();
    	myUnassignedResources = new ArrayList<Resource>();
        myPlayerResources = new HashMap<Integer, HashMap<String, Integer>>();
    	//myResources = new HashMap<String, Integer>();        
    }
    
    public void addPlayer(int playerID) {
    	myPlayerResources.put(playerID, new HashMap<String, Integer>());
    }
    
    /**
     * Returns the amount of a particular type of resource owned by a player
     * @param resource
     * @param playerID
     * @return
     */
    public int getAmount(String resource, int playerID) {
        Map<String, Integer> particularPlayerResources = myPlayerResources.get(playerID);
        
    	if (particularPlayerResources.containsKey(resource)){
            return particularPlayerResources.get(resource);
        }
        return 0;
    }
    
    //TODO: refactor later
    public void addUnassignedResource(Resource resource) {
    	myUnassignedResources.add(resource);
    }
    
    public List<Resource> getUnassignedResources() {
    	return myUnassignedResources;
    }
    
    /**
     * Assigns the resource to a specific player
     * @param resource
     * @param playerID
     */
    public void assignResoure(Resource resource, int playerID) {
    	String resourceType = resource.getType();
    	if (!myPlayerResources.get(playerID).containsKey(resourceType)) {
    		myPlayerResources.get(playerID).put(resourceType, 1);
    		System.out.println("haha added!");
    	} else {
    		int oldAmount = myPlayerResources.get(playerID).get(resourceType);
    		myPlayerResources.get(playerID).put(resourceType, oldAmount+1);
    	}
    	int resourceIndex = myUnassignedResources.indexOf(resource);
    	myUnassignedResources.remove(resourceIndex);
    	notifyGameManagerObserver(playerID, myPlayerResources.get(playerID));
    }
    
    /**
     * Removes the resource from a specific player
     * @param resource
     * @param playerID
     */
    public void removeResource(String resource, int playerID) {
    	int oldAmount = myPlayerResources.get(playerID).get(resource);
    	myPlayerResources.get(playerID).put(resource, oldAmount+1);
    	notifyGameManagerObserver(playerID, myPlayerResources.get(playerID));
    }

	@Override
	public void register(IGameManagerObserver o) {
		myObservers.add(o);
	}

	@Override
	public void unregister(IGameManagerObserver o) {
		int observerIndex = myObservers.indexOf(o);
		myObservers.remove(observerIndex);
	}

	@Override
	public void notifyGameManagerObserver(int playerID, HashMap<String, Integer> updatedResources) {
		myObservers.get(playerID-1).updateResource(updatedResources);
	}
}
