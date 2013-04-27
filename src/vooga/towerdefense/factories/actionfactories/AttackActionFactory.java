package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;

/**
 * A bundle of action factories to make implementing game elements easier
 * @author Matthew Roy
 *
 */
public class AttackActionFactory extends ActionFactory {
    
    
    private String myRadius;
    private String myAttackSpeed;
    private String myNumberOfTargets;
    private String myTargets;
    private String myProjectileType;
    
    private FindTargetsFactory myFinder;
    private FilterTargetsFactory myFilter;
    private PeriodicActionFactory mySpeed;
    private LaunchProjectileFactory myProjectiles;
    
    
    public AttackActionFactory(String attackRadius, String attackSpeed, String numTargets, String targetAffiliation, String projectileFactory) {
        myRadius = attackRadius;
        myAttackSpeed = attackSpeed;
        myNumberOfTargets = numTargets;
        myTargets = targetAffiliation;
        myProjectileType = projectileFactory;
    }
    
    public void initialize (GameMap map) {
        super.initialize(map);
        makeComboFactories();
        myFinder.initialize(map);
        myFilter.initialize(map);
        mySpeed.initialize(map);
        myProjectiles.initialize(map);
    }
    
    
    public void makeComboFactories() {
        myFinder = new FindTargetsFactory(myRadius);
        myFilter = new FilterTargetsFactory(myTargets, myNumberOfTargets);
        mySpeed = new PeriodicActionFactory(myAttackSpeed);
        myProjectiles = new LaunchProjectileFactory(myProjectileType);
    }

    /**
     * 
     * @param e
     * @return 
     */
    @Override
    protected Action buildAction (GameElement e) {
        Action attack = myFinder.buildAction(e);
        Action filter = myFilter.createAction(e);
        Action speed = mySpeed.createAction(e);
        Action projectile = myProjectiles.createAction(e);
        attack.addFollowUpAction(filter);
        filter.addFollowUpAction(speed);
        speed.addFollowUpAction(projectile);
        return attack;
    }

}
