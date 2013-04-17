package vooga.towerdefense.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vooga.towerdefense.action.Action;

/**
 * Handles events that handles the game state and triggers actions.
 * 
 * @author XuRui
 *
 */
public class EventHandler {
	
	protected HashMap<String, List<Event>> myEventsList;
	protected Action myAction;
	
	public EventHandler(Action a){
		myAction = a;
		myEventsList = new HashMap<String, List<Event>>();
	}
	
	public void addEvent (Event e){
		if (!contains(e.getID())){
			myEventsList.put(e.getID(), new ArrayList<Event>());
		}
		myEventsList.get(e.getID()).add(e);
	}
	
	public void removeAllEvents(Event e){
		if (contains(e.getID())) myEventsList.remove(e.getID());
	}
	
	public void remove(Event e){
		if (contains(e.getID())) myEventsList.get(e.getID()).remove(0);
	}

	private boolean contains(String eventID) {
		return myEventsList.containsKey(eventID);
	}

	
	public boolean hasEvent() {
		return !myEventsList.isEmpty();
		
	}
}
