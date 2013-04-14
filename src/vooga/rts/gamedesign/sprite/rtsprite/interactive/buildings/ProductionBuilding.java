package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Unit;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

public class ProductionBuilding extends Building {
    private Location myRallyPoint;
    private List<InteractiveEntity> myProducables; //for testing really, need to make it work with xml file
    
    public ProductionBuilding (Pixmap image,
                               Location center,
                               Dimension size,
                               Sound sound,
                               int teamID,
                               int health) {
        super(image, center, size, sound, teamID, health);
        myRallyPoint = new Location((int)getCenter().x, (int)getCenter().y + 50);
        myProducables = new ArrayList<InteractiveEntity>();
    }

    @Override
    public void getOccupied (Unit u) {
        // TODO Auto-generated method stub
    }
    public Location getRallyPoint() {
        return myRallyPoint;
    }
    /*
     * Test method to add an interactive entity to 
     */
    public void addProducable(InteractiveEntity i) {
        myProducables.add(i);
    }
    /*
     * returns the list of producables
     */
    public List<InteractiveEntity> getProducables() {
        return myProducables;
    }
}
