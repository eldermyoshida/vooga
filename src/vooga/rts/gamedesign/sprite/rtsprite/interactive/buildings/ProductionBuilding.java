package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Unit;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
/**
 * This class is a subclass of Building to deal with production buildings.
 * Has rallypoints which is where newly produced units go to. 
 * 
 * @author Junho Oh
 */
public class ProductionBuilding extends Building {
    private Location myRallyPoint;
    private List<InteractiveEntity> myProducables; //for testing really, need to make it work with xml file
    
    public ProductionBuilding (Pixmap image,
                               Location center,
                               Dimension size,
                               Sound sound,
                               int playerID,
                               int health) {
        super(image, center, size, sound, playerID, health);
        myRallyPoint = new Location((int)getCenter().x, (int)getCenter().y + 50);
        myProducables = new ArrayList<InteractiveEntity>();
    }

    @Override
    public void getOccupied (Unit u) {
        // does nothing if building isnt occupied. 
    }
    
    /*
     * returns the list of producables
     */
    public List<InteractiveEntity> getProducables() {
        return myProducables;
    }
    
    /**
     * Returns the rally point of the production building. 
     * Will be used to move the newly created units to
     * @return myRallyPoint, the rally point of the 
     * production building 
     */
    public Location getRallyPoint() {
        return myRallyPoint;
    }
    /*
     * Test method to add an interactive entity to 
     */
    public void addProducable(InteractiveEntity i) {
        myProducables.add(i);
    }
    
    /**
     * Sets the rally point of the production building
     * @param rallyPoint the location of the new rally point 
     */
    public void setRallyPoint(Location rallyPoint) {
    	myRallyPoint = rallyPoint;
    }
   
}
