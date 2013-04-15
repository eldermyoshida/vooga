package vooga.rts.gamedesign.action;

import vooga.rts.util.Pixmap;
import vooga.rts.util.Location;
/**
 * This class is the subclass of Action that will deal with 
 * Production actions, ie, actions that will create a new 
 * interactiveEntity 
 * @author Junho Oh
 *
 */
public class ProductionAction extends Action {
	private Location toProduceFrom;

	public ProductionAction (String name, Pixmap image, String description, Location from) {
		super(name, image, description);
		toProduceFrom = new Location(from);
	}
	/**
	 * Returns the location from where the production will take place.  
	 * @return toProduceFrom the location of where the production will take place 
	 */
	public Location getProducedFrom() {
		return toProduceFrom;
	}

}
