package vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import vooga.rts.commands.Command;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.strategy.Strategy;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.gamedesign.strategy.occupystrategy.CanBeOccupied;
import vooga.rts.gamedesign.strategy.occupystrategy.CannotBeOccupied;
import vooga.rts.gamedesign.strategy.production.CanProduce;
import vooga.rts.gamedesign.strategy.upgradestrategy.CanUpgrade;
import vooga.rts.gamedesign.strategy.upgradestrategy.CannotUpgrade;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;


/**
 * This is an class that represents a building. It will be extended
 * by specific types of buildings such as AttackTower.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */

public class Building extends InteractiveEntity {
    public static final int PRODUCE_TIME = 90;
    public static final Dimension DEFAULT_SIZE = new Dimension(100,100);
    public static final int MAXHEALTH = 100;

    /**
     * Creates a new building with a rally point, a list of what can be 
     * produced, a list of what can observe the building, and an upgrade tree.
     * @param image is the picture of the building
     * @param center is the location of the building
     * @param size is the dimensions of the building
     * @param sound is the sound that the building makes
     * @param playerID is the team that the building is on
     * @param health is how much health the building has
     * @param buildTime is the time it takes to create a building
     * @param upgradeTree is the upgrade tree for the building
     */
    public Building (Pixmap image,
                     Location3D center,
                     Dimension size,
                     Sound sound,
                     int playerID,
                     int health,
                     double buildTime) {
        super(image, center, size, sound, playerID, MAXHEALTH, buildTime);

    }
    
    public Building(Pixmap image, Sound sound, int health, double buildTime) {
    	this(image, InteractiveEntity.DEFAULT_LOCATION, DEFAULT_SIZE, sound, InteractiveEntity.DEFAULT_PLAYERID, health, buildTime);
    }

    @Override
    public InteractiveEntity copy () {
        Building copyBuilding = new Building(getImage(), getWorldLocation(), getSize(), getSound(), getPlayerID(),
                getHealth(), getBuildTime());
        
        transmitProperties(copyBuilding);
        setRallyPoint();
    	return copyBuilding;
    }

    @Override
    public int getSpeed() {
    	return 0;
    }
    
    @Override
    public void addDefaultActions() {		
		
    }

    @Override
    public void updateAction (Command command) {
        // TODO Auto-generated method stub
        
    }
}
