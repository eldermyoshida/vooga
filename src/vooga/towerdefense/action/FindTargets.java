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


/**
 * 
 * @author Xu Rui
 * @author Matthew Roy
 * 
 */
public class FindTargets extends Action {

    private Attribute myScanningRadius;
    private List<GameElement> myTargets;
    private Location mySource;
    private GameMap myMap;

    public FindTargets (GameMap myMap, Location source, Attribute attackRadius) {
        myScanningRadius = attackRadius;
        mySource = source;
        myTargets = myMap.getTargetsWithinRadius(source, myScanningRadius.getValue(), 10);
    }

    public void update (double elapsedTime) {
        if (isEnabled()) {
            executeAction(elapsedTime);
        }
    }

    @Override
    public void executeAction (double elapsedTime) {
        if (!myTargets.isEmpty()) {
            for (GameElement t : myTargets) {
                addFollowUpAction(new LaunchProjectile(mySource, new ExampleProjectileFactory(), t,
                                                       myMap));
                getFollowUpAction().update(elapsedTime);

            }
        }

    }

}
