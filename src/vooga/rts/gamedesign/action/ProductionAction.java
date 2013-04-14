package vooga.rts.gamedesign.action;

import vooga.rts.util.Pixmap;
import vooga.rts.util.Location;

public class ProductionAction extends Action {
    private Location toProduceFrom;

    public ProductionAction (String name, Pixmap image, String description, Location from) {
        super(name, image, description);
        toProduceFrom = new Location(from);
    }
    
    public Location getProduceFrom() {
        return toProduceFrom;
    }
    
}
