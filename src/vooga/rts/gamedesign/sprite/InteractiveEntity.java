package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vooga.rts.gamedesign.Action;
import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.factories.Factory;
import vooga.rts.gamedesign.sprite.rtsprite.EntityVisitor;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;

import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

/**
 * This class is the extension of GameEntity. It represents shapes that are
 * able to upgrade (to either stat of its current properties or add new
 * properties) and attack others.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 *
 */
public abstract class InteractiveEntity extends GameEntity implements IAttackable{

    private UpgradeTree myUpgradeTree;
    private Sound mySound;
    private AttackStrategy myAttackStrategy;
    private int myArmor;
    private List<Action> myActions;
    private List<Weapon> myWeapons;
    private int myWeaponIndex;

    private Map<String, Factory> myMakers; //WHERE SHOULD THIS GO??

    public InteractiveEntity (Pixmap image, Location center, Dimension size, Sound sound, int teamID, int health) {
        super(image, center, size, teamID, health);
        myMakers = new HashMap<String, Factory>(); //WHERE SHOULD THIS GO?
        //myUpgradeTree =new UpgradeTree();
        mySound = sound;
        myAttackStrategy = new CannotAttack();
        myActions = new ArrayList<Action>();
        myWeapons = new ArrayList<Weapon>();
        myWeaponIndex = 0;
        initDefaultActions();

        //UpgradeNode armor = new ArmorUpgradeNode("armor1","myHealth",40); //TESTING
        //myUpgradeTree.addUpgrade(armor); //TESTING
    }
    
    public void getAttacked(InteractiveEntity a){
    	a.attack(this);
    }
  

    public Sound getSound(){
        return mySound;
    } 
    
    public void attack(IAttackable a){
    	if(myAttackStrategy.canAttack(a) && inRange((InteractiveEntity) a)){
    		myWeapons.get(myWeaponIndex).fire((InteractiveEntity) a);
    	}    
    }
    
    
    public boolean inRange(InteractiveEntity enemy){
    	return myWeapons.get(myWeaponIndex).inRange(enemy);
    }

    /**
     * Sets the attack strategy for an interactive. Can set the interactive
     * to CanAttack or to CannotAttack and then can specify how it would
     * attack.
     * 
     * @param newStrategy is the new attack strategy that the interactive
     *        will have
     */
    public void setAttackStrategy(AttackStrategy newStrategy){
        myAttackStrategy = newStrategy;
    }
    /**
     * Returns the current attack strategy of the interactive
     * 
     * @return the current attack strategy
     */
    public AttackStrategy getAttackStrategy () {
        
        return myAttackStrategy;
    }

    /**
     * upgrades the interactive based on the selected upgrade
     * 
     * @param upgradeNode is the upgrade that the interactive will get
     * @throws NoSuchMethodException 
     * @throws InstantiationException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws IllegalArgumentException 
     */
    public void upgrade (UpgradeNode upgradeNode) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException { 	
    	upgradeNode.apply(upgradeNode.getUpgradeTree().getUsers());
    }

    public UpgradeTree getTree(){
        return myUpgradeTree;
    }

    public int calculateDamage(int damage) {
        return damage * (1-(myArmor/(myArmor+100)));
    }
    
    public boolean hasWeapon(){
        return !myWeapons.isEmpty();
    }
    public Weapon getWeapon(){
        return myWeapons.get(0);
    }
    public void addWeapons(Weapon weapon) {
        myWeapons.add(weapon);
    }
    
    private void initDefaultActions(){
        myActions.add(new Action("Stop", null, "Action to stop InteractiveEntity"){
            @Override
            public void apply(){
                //change the state of the entity to normal
                setVelocity(0, 0);
            }
        });
        myActions.add(new Action("Hold", null, "Sets the InteractiveEntity to hold position"){
            @Override
            public void apply(){
                //does not change state
                setVelocity(0,0);
            }
        });
        myActions.add(new Action("Test2", null, "Action to stop InteractiveEntity"){
            @Override
            public void apply(){
                setVelocity(0, 0);
            }
        });
        
    }


}
