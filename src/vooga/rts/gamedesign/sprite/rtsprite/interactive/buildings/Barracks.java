package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import vooga.rts.gamedesign.action.ProductionAction;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics2D;

/**
 * 
 * @author Kevin Oh
 *
 */
public class Barracks extends ProductionBuilding {
    public int PRODUCE_TIME = 90;
    private List<InteractiveEntity> myBabies;
    
    public Barracks(Pixmap image, Location center, Dimension size, Sound sound,
                    int teamID, int health) {
        super(image, center, size, sound, teamID, health);
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
                
                ie.setCenter(getProduceFrom().x, getProduceFrom().y);
                //these below are for testing purposes 
                ie.move(new Location(300,400));
                myBabies.add(ie);
            }
        });
        //add actions to create a unit
    }
    @Override
    public void paint(Graphics2D pen) {
        super.paint(pen);
        for(InteractiveEntity ie : myBabies) {
            ie.paint(pen);
        }
    }
    
    @Override
    public void update(double elapsedTime) {
        super.update(elapsedTime);
        PRODUCE_TIME -= 1/elapsedTime;
        if(PRODUCE_TIME <= 0) { 
            getActions().get(3).apply();
            PRODUCE_TIME = 90;
        }
        System.out.println("Size of my babies " + myBabies.size());
        for(InteractiveEntity ie : myBabies) {
            ie.update(elapsedTime);
        }
        
    }
    
    
}