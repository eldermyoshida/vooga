package vooga.towerdefense.factories.examples;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.FindTargets;
import vooga.towerdefense.action.actionlist.Move;
import vooga.towerdefense.action.actionlist.MoveToTarget;
import vooga.towerdefense.action.tobetested.ModifyAttributeValue;
import vooga.towerdefense.action.tobetested.RandomChance;
import vooga.towerdefense.action.tobetested.RemoveGameElement;
import vooga.towerdefense.action.tobetested.SetAttributeValue;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.attributes.DefaultAttributeManager;
import vooga.towerdefense.factories.GameElementFactory;
import vooga.towerdefense.factories.ProjectileDefinition;
import vooga.towerdefense.factories.ProjectileFactory;
import vooga.towerdefense.factories.TowerDefinition;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * @author Matthew Roy
 * 
 */
public class ExampleDosProjectileFactory extends GameElementFactory {

    private static final int DEFAULT_WIDTH = 10;
    private static final Pixmap DEFAULT_IMAGE = new Pixmap("fireball.gif");
    private static final Dimension DEFAULT_SIZE = new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH);
    private static final List<Action> DEFAULT_ACTIONS = new ArrayList<Action>();
    private static final DefaultAttributeManager DEFAULT_ATTRIBUTE_MANAGER = new DefaultAttributeManager();
    private static final String DEFAULT_PROJECTILE_TYPE = "projectile";

    public GameElement createElement (Location putHere) {
        ProjectileDefinition def = new ProjectileDefinition();
        AttributeManager AM = getDefaultAM();

        Pixmap tImage = new Pixmap("fireball.gif");
        GameElement myProjectile;
        if (putHere != null) {
            myProjectile = new GameElement(tImage, putHere,
                                      new Dimension(25,25), AM, "projectile");
        }
        else {
            myProjectile = new GameElement(def.getImage(),
                                      def.getCenter(), def.getSize(), AM, "projectile");
        }

        ArrayList<Action> actions = new ArrayList<Action>();
       /* FindTargets findTargets =
                new FindTargets(getMap(), putHere,
                                AM.getAttribute(AttributeConstants.ATTACK_RADIUS));
        /*findTargets.addFollowUpAction(new SetAttributeValue(AM
                .getAttribute(AttributeConstants.AURA_EFFECT), AttributeConstants.MOVE_SPEED));*/
        Move m = new Move(putHere, DEFAULT_ATTRIBUTE_MANAGER.getAttribute(AttributeConstants.MOVE_SPEED), 
        		DEFAULT_ATTRIBUTE_MANAGER.getAttribute(AttributeConstants.DIRECTION));
        ModifyAttributeValue a = new ModifyAttributeValue(AM
        .getAttribute(AttributeConstants.AURA_EFFECT), AttributeConstants.HEALTH);
        m.addFollowUpAction(a);
        //findTargets.addFollowUpAction(m);
        actions.add(m);

        myProjectile.addActions(actions);
        return myProjectile;
    }

    public AttributeManager getDefaultAM () {
        AttributeManager AM = new AttributeManager();
        AM.addAttribute(new Attribute(AttributeConstants.ATTACK_RADIUS, 100.0));
        AM.addAttribute(new Attribute(AttributeConstants.DIRECTION, -50.0));
        AM.addAttribute(new Attribute(AttributeConstants.ATTACK_INTERVAL, 30.0));
        AM.addAttribute(new Attribute(AttributeConstants.NUM_OF_TARGETS, 1.0));
        AM.addAttribute(new Attribute(AttributeConstants.ATTACK_RADIUS, 200.0));
        AM.addAttribute(new Attribute(AttributeConstants.MOVE_SPEED, 50.0));
        AM.addAttribute(new Attribute(AttributeConstants.AURA_EFFECT, 5.0));
        AM.setProjectileFactory(new ProjectileFactory());
        return AM;
    }

    /**
     * @param myStart
     * @param center
     * @return
     */
    public GameElement createElement (GameElement myStart, GameElement e, GameMap map) {
        TowerDefinition def = new TowerDefinition();
        AttributeManager AM = getDefaultAM();
        initialize(map);

        Pixmap tImage = new Pixmap("mergeConflict.jpg");
        GameElement myProjectile;
        if (myStart != null) {
            myProjectile = new GameElement(tImage, myStart.getCenter(),
                                           new Dimension(30, 30), AM, DEFAULT_PROJECTILE_TYPE);
        }
        else {
            myProjectile = new GameElement(def.getImage(),
                                           def.getCenter(), def.getSize(), AM, DEFAULT_PROJECTILE_TYPE);
        }

        ArrayList<Action> actions = new ArrayList<Action>();
        /*FindTargets findTargets =
                new FindTargets(map, myStart.getCenter(), AM.getAttribute(AttributeConstants.ATTACK_RADIUS));
        findTargets.addFollowUpAction(new SetAttributeValue(AM
                .getAttribute(AttributeConstants.AURA_EFFECT), AttributeConstants.HEALTH));
        actions.add(findTargets);
        //Action randomChance = new RandomChance(-0.01);
        //randomChance.addFollowUpAction(new RemoveGameElement(map, myProjectile));
        //actions.add(randomChance);
        //actions.add(new Move(myProjectile.getCenter(), AM
        //        .getAttribute(AttributeConstants.MOVE_SPEED), AM
        //        .getAttribute(AttributeConstants.DIRECTION)));
        actions.add(new MoveToDestination(myProjectile.getCenter(), e.getCenter(), AM
                .getAttribute(AttributeConstants.MOVE_SPEED)));*/
        
        MoveToTarget m = new MoveToTarget(myStart.getCenter(), null, DEFAULT_ATTRIBUTE_MANAGER.getAttribute(AttributeConstants.MOVE_SPEED));
        ModifyAttributeValue a = new ModifyAttributeValue(AM
        .getAttribute(AttributeConstants.AURA_EFFECT), AttributeConstants.HEALTH);
        m.addFollowUpAction(a);
        actions.add(m);
        myProjectile.addActions(actions);
        return myProjectile;
    }

    /**
     * @param myStart
     * @param myTarget
     * @return 
     */
    public GameElement createProjectile (GameElement myStart, GameElement myTarget) {
        return this.createElement(myStart, myTarget, getMap());
    }

}
