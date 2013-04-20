package vooga.rts.gamedesign.strategy.production;

import vooga.rts.gamedesign.factories.Factory;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.ProductionBuilding;
import vooga.rts.util.Location3D;

import java.util.ArrayList;
import java.util.List;


/**
 * This class implements ProductionStrategy and is used as an instance in
 * interactives for objects that are able to produce other interactives.
 * The produce method in this class will specify how the interactive will
 * produce other units.
 * @author Kevin Oh
 * 
 */
public class CanProduce implements IProducer {

    private List<InteractiveEntity> myProducables;
    private Location3D myRallyPoint;
    
    public CanProduce() {
        myProducables = new ArrayList<InteractiveEntity>();
        myRallyPoint = new Location3D();
    }
    
    public void setRallyPoint(Location3D rallyPoint) {
        myRallyPoint = rallyPoint;
    }
    public void addProducable(InteractiveEntity producable) {
        myProducables.add(producable);
    }
    
    @Override
    public void createProductionActions (InteractiveEntity producer) {
        if(producer instanceof ProductionBuilding) {
            for(InteractiveEntity producable : ((ProductionBuilding) producer).getProducables()) {
                //get the first letter of the class name to use as the keyboard input. 
                String[] name = producable.getClass().getName().split(".");
                //producer.addAction
                //on apply, create new thingy, notify the observer of the producer 
                //how to get the id of the observer? pass into constructor? 
            }
        }
    }


}
