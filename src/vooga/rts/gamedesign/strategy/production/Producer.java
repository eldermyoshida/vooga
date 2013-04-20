package vooga.rts.gamedesign.strategy.production;

import vooga.rts.gamedesign.Interval;
import vooga.rts.gamedesign.factories.Factory;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * This class implements ProductionStrategy and is used as an instance in
 * interactives for objects that are able to produce other interactives.
 * The produce method in this class will specify how the interactive will
 * produce other units.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class Producer implements IProducer {

    private List<InteractiveEntity> myProducables;

    private Interval myBuildTime;

    public void produce() {
    	myProducables = new ArrayList<InteractiveEntity>();
    	myBuildTime = new Interval();
    }
    
    /**
     * Sets the time it takes to produce an InteractiveEntity.
     * @param time
     */
    public void setBuildTime(int time) {
    	myBuildTime = new Interval(time);
    	myBuildTime.resetCooldown();
    }

    /**
     * Returns the amount of time left to produce an InteractiveEntity.
     * @return the amount of time left to produce an InteractiveEntity
     */
	public int getBuildTime() {
		return myBuildTime.getCooldown();
	}
    
	/**
	 * Adds an InteractiveEntity that this Producer can produce to the list of
	 * what can be produced.
	 * @param producable is the InteractiveEntity that can be produced by this
	 * producer
	 */
	public void addProducables(InteractiveEntity producable) {
		myProducables.add(producable);
	}

	@Override
	public void produce(InteractiveEntity produced) {
		if(myProducables.contains(produced)) {
			setBuildTime(produced.getBuildTime());
		}
		
	}

}
