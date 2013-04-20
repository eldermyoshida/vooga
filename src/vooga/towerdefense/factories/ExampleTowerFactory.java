package vooga.towerdefense.factories;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.FollowPath;
import vooga.towerdefense.action.Move;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Tower;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.model.Path;
import vooga.towerdefense.util.Location;

/**
 * @author Matthew Roy
 *
 */
public class ExampleTowerFactory extends TowerFactory {

    /**
     * @param name
     * @param def
     */
    public ExampleTowerFactory (String name, TowerDefinition def) {
        super(name, def);
    }
    
    
    
    public GameElement createGameElement(Location putHere){
        GameElementDefinition def = getDefinition();
        if (def == null) {
            return null;
        }
        AttributeManager AM = new AttributeManager();
        AM.addAttribute(new Attribute(AttributeConstants.MOVE_SPEED, 150.0));
        AM.addAttribute(new Attribute(AttributeConstants.DIRECTION, 50.0));
        AM.addAttribute(new Attribute(AttributeConstants.ATTACK_INTERVAL, 50.0));
        Tower myTower;
        if (putHere != null) {
                myTower = new Tower(def.getImage(), putHere,
                                def.getSize(), AM);
        } else {
                myTower = new Tower(def.getImage(),
                                def.getCenter(), def.getSize(), AM);
        }

        ArrayList<Action> actions = new ArrayList<Action>();
        actions.add(new Move(myTower.getCenter(), myTower.getAttributeManager()
                        .getAttribute(AttributeConstants.MOVE_SPEED), myTower
                        .getAttributeManager().getAttribute(
                                        AttributeConstants.DIRECTION)));
        
        
       
        //actions.add(new AttackAction(myTower, ));
        myTower.addActions(actions);
        
        return myTower;

        
        /*
                return new GameElement(def.getImage(), 
                                def.getCenter(), 
                                def.getSize(), 
                                createAttributeFactory().makeAttributeManager(), 
                                createActionFactory().createActions());
                                */
    }

}
