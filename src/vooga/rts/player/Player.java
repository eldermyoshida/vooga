package vooga.rts.player;

import java.awt.Graphics2D;
import java.util.Observable;
import arcade.games.Game;
import vooga.rts.IGameLoop;
import vooga.rts.commands.Command;
import vooga.rts.controller.Controller;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.manager.IndividualResourceManager;
import vooga.rts.manager.Manager;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.state.GameOver;
import vooga.rts.util.Location3D;


/**
 * Sends commands to its unit manager from either the human input, the network
 * input or the ai input.
 * Also stores information about a player, such as its team id, player id, base,
 * available resources, etc.
 * 
 * @author challenherzberg-brovold
 * @author Jonathan Schmidt
 * 
 */
public class Player extends Observable implements Controller, IGameLoop {

    protected Manager myManager;
    private IndividualResourceManager myResources;

    private int myPlayerID;
    private int myTeamID;

    private Location3D myBase;
    
    public Player (int playerid, int teamID) {
        myManager = new Manager(playerid);
        myPlayerID = playerid;
        myTeamID = teamID;
        myResources = new IndividualResourceManager();
        myBase = new Location3D();
    }
    
    public void setBase(Location3D loc) {
        myBase = new Location3D(loc);
    }
    
    /* 
     * @return the location of where the Player starts the game.
     */
    public Location3D getBase() {
    	return myBase;
    }
    
    /*
     * JUST TO RETURN A VALUE
     */
    public Location3D getEnemyBase() {
    	return new Location3D(700, 700, 0);
    }
    
    /**
     * @return the resources of the player
     */
    public IndividualResourceManager getResources () {
        return myResources;
    }

    @Override
    public void sendCommand (Command command) {
        // TODO Auto-generated method stub
    }

    public Manager getManager () {
        return myManager;
    }

    public void add (InteractiveEntity unit) {
        unit.setPlayerID(myPlayerID);
        myManager.add(unit);
    }

    @Override
    public void paint (Graphics2D pen) {        
    }

    @Override
    public void update (double elapsedTime) {
        myManager.update(elapsedTime);
        if (myManager.getAllEntities().size() == 0) {
            setChanged();
            notifyObservers(GameOver.OVER);
        }
    }

    /**
     * @return the playerID
     */
    public int getPlayerID () {
        return myPlayerID;
    }

    /**
     * @return the teamID
     */
    public int getTeamID () {
        return myTeamID;
    }
}
