package vooga.towerdefense.action;

import java.util.List;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.factories.ExampleProjectileFactory;
import vooga.towerdefense.factories.ProjectileFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Vector;

public class TrackTarget extends Action{
	
	private Attribute myScanningRadius;
	private List<GameElement> myTargets;
	private Location mySource;
	private GameMap myMap;
	

	public TrackTarget(Location source, Attribute attackRadius, GameMap myMap){
		myScanningRadius = attackRadius;
		mySource = source;
		myTargets = myMap.getTargetsWithinRadius(source, myScanningRadius.getValue(), 10);
		//hard coded to add in CreateProjectile action
	}

	public void update(double elapsedTime) {
		if (isEnabled()){
			executeAction(elapsedTime);
		}

	}

	@Override
	public void executeAction(double elapsedTime) {
		if(!myTargets.isEmpty()){
			for (GameElement t: myTargets){
				addFollowUpAction(new LaunchProjectile(mySource, new ExampleProjectileFactory(), t, myMap));
				getFollowUpAction().update(elapsedTime);

			}
		}

	}
	

}
