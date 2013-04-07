package gamedesign.strategy.productionstrategy;

import gamedesign.factories.Factory;
import gamedesign.sprite.rtsprite.interactive.Interactive;

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
public class Producer implements ProductionStrategy {

  public List<Interactive> myProducables;

  public Integer cooldown;

  public Factory myFactory;

  public void produce() {
  }

@Override
public void produce(String str) {
	// TODO Auto-generated method stub
	
}

}