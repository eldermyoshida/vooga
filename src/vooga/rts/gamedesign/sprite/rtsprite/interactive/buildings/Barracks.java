package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import vooga.rts.gamedesign.action.ProductionAction;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

/**
 * 
 * @author Kevin Oh
 *
 */
public class Barracks extends ProductionBuilding {
    public int PRODUCE_TIME = 90;
    private List<InteractiveEntity> myBabies;
    
    public Barracks(Pixmap image, Location center, Dimension size, Sound sound,
                    int playerID, int health) {
        super(image, center, size, sound, playerID, health);
        myBabies = new ArrayList<InteractiveEntity>();
        initProducables();
        addProductionActions(this);
    }
    /*
     * FOR TESTING: CALLED IN CONSTRUCTOR TO INITIALIZE PRODUCABLE LIST 
     */
    private void initProducables() {
        addProducable(new Soldier());
    }
    
    public void addProductionActions(ProductionBuilding p) {
        getActions().add(new ProductionAction("soldier",null,"I maketh un soldier", p.getCenter()){
            @Override
            public void apply() {
                InteractiveEntity ie = getProducables().get(0).copy();
                Location ieLoc = new Location(getProducedFrom());                
                ie.setCenter(ieLoc.x, ieLoc.y);
                //these below are for testing purposes 
                ie.move(new Location(300,400));
                //this part below will not be in actual implementaiton as I will notify player/unit manager that a new unit should be added to the player
                myBabies.add(ie);
            }
        });
    }
    @Override
    public void paint(Graphics2D pen) {
        super.paint(pen);
        for(int i = 0; i < myBabies.size(); i++) {
            myBabies.get(i).paint(pen);
        }
    }
    
    @Override
    public void update(double elapsedTime) {
        super.update(elapsedTime);
        PRODUCE_TIME -= 1/elapsedTime;
        if(PRODUCE_TIME <= 0) { 
            try {
				getActions().get(3).apply();
			} catch (Exception e) {
				e.printStackTrace();
			} 
            PRODUCE_TIME = 90;
        }
        for(InteractiveEntity ie : myBabies) {
            ie.update(elapsedTime);
        }
        
    }
    
    
}