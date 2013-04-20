package vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.strategy.occupystrategy.CanBeOccupied;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.manager.IndividualBuildingManager;
import vooga.rts.manager.GameBuildingManager;
import vooga.rts.util.Location;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.towerdefense.gameElements.Unit;


/**
 * This is an abstract class that represents a building. It will be extended
 * by specific types of buildings such as AttackTower.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public abstract class Building extends InteractiveEntity {
    public static final int MAXHEALTH = 100;
    private static UpgradeTree myUpgradeTree;
    //TODO: probably shouldn't be stored in Building. Should try Observer pattern later?
    private static GameBuildingManager myGameBuildingManager;
    
    public Building (Pixmap image,
            Location3D center,
            Dimension size,
            Sound sound,
            int playerID,
            int health) {
    	this(image, center, size, sound, playerID, health, null);
    }
    
    public Building (Pixmap image,
                     Location3D center,
                     Dimension size,
                     Sound sound,
                     int playerID,
                     int health, UpgradeTree upgradeTree) {
        super(image, center, size, sound, playerID, MAXHEALTH);
        if (upgradeTree != null) {
        	myUpgradeTree = upgradeTree;
        }
        if (myGameBuildingManager != null) {
        	System.out.println("yay has GameBuildingManager!");
        	myGameBuildingManager.addBuilding(this);
        }
    }
    
    public void setGameBuildingManager(GameBuildingManager gameBuildingManager) {
    	myGameBuildingManager = gameBuildingManager;
    	myGameBuildingManager.addBuilding(this);
    }
    
    public GameBuildingManager getGameBuildingManager() {
    	return myGameBuildingManager;
    }
    
    @Override
    public UpgradeTree getUpgradeTree() {
    	return myUpgradeTree;
    }
}
