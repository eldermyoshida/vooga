package vooga.rts.manager;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.controller.ClickCommand;
import vooga.rts.controller.Command;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Soldier;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.state.State;
import vooga.rts.util.Camera;
import vooga.rts.util.Location3D;



public class Manager implements State {
    
    private List<Unit> myUnits;
    private List<InteractiveEntity> myEntities;
    private List<InteractiveEntity> mySelectedEntities;
    private Map<Integer, List<InteractiveEntity>> myGroups;
    private boolean myMultiSelect;
    private Map<String, Action> myInputs;

    public Manager () {
        myEntities = new ArrayList<InteractiveEntity>();
        mySelectedEntities = new ArrayList<InteractiveEntity>();
        myGroups = new HashMap<Integer, List<InteractiveEntity>>();
        myMultiSelect = false;
        myInputs = new HashMap<String, Action>();
        myUnits = new ArrayList<Unit>();
        myInputs.put("leftclick", new Action());
    }

    /**
     * Activates a previously create group of entities.
     * 
     * @param groupID The ID of the group to select
     */
    public void activateGroup (int groupID) {
        if (myGroups.containsKey(groupID)) {
            mySelectedEntities = new ArrayList<InteractiveEntity>(myGroups.get(groupID));
        }
    }

    /**
     * Adds an entity to the manager.
     * This will be done when a new entity is created.
     * 
     * @param u The entity that is to be added.
     */
    public void add (InteractiveEntity unit) {
        myEntities.add(unit);
    }

    /**
     * Deselects the specified entity.
     * 
     * @param u The entity to deselect
     */
    public void deselect (InteractiveEntity ie) {
        if (mySelectedEntities.contains(ie)) {
            mySelectedEntities.remove(ie);
            ie.select(false);
        }
    }

    /**
     * Deselects all the selected entities.
     */
    public void deselectAll () {
        if (myMultiSelect) {
            return;
        }
        for (InteractiveEntity ie : mySelectedEntities) {
            ie.select(false);
        }
        mySelectedEntities.clear();
    }

    /**
     * Returns the list of all the entities in the manager.
     * 
     * @return List of all entities
     */
    public List<InteractiveEntity> getAllEntities () {
        return myEntities;
    }

    /**
     * Returns the list of selected entities.
     * 
     * @return The selected entities
     */
    public List<InteractiveEntity> getSelected () {
        return mySelectedEntities;
    }

    /**
     * Groups the currently selected entities together with a
     * specified group ID
     * 
     * @param groupID The ID of the group
     */
    public void group (int groupID) {
        myGroups.put(groupID, new ArrayList<InteractiveEntity>(mySelectedEntities));
    }

    @Override
    public void paint (Graphics2D pen) {
        for (InteractiveEntity u : myUnits) {
            u.paint(pen);
        }
    }

    @Override
    public void receiveCommand (Command command) {
        for (Unit u: myUnits) {
            u.updateAction(command);
        }
//        if(myInputs.containsKey(command.getMethodName())) {
// //       Camera.instance().viewtoWorld(click.getPosition())
//           myInputs.get(command.getMethodName()).update(command, myUnits);
//           for(Unit u: myUnits) {
//               u.move(new Location3D(100, 100, 0));
//           }         
//       }
    }

    /**
     * Selects a specific entity and marks it as selected.
     * 
     * @param entity
     */
    public void select (InteractiveEntity entity) {
        deselectAll();
        if (!mySelectedEntities.contains(entity)) {
            if (myEntities.contains(entity)) {
                mySelectedEntities.add(entity);
                entity.select(true);
            }
        }
    }

    /**
     * Selects the top most interactive entity that is underneath
     * the provided Point location.
     * This is used for selecting entities by mouse click.
     * 
     * @param loc
     */
    public void select (Location3D loc) {
        deselectAll();
        for (int i = getAllEntities().size() - 1; i >= 0; i--) {
            InteractiveEntity ie = getAllEntities().get(i);
            if (ie.intersects(loc)) {
                select(ie);
                return;
            }
        }
    }

    /**
     * Selects all the entities in provided rectangle.
     * Allows a user to drag around the desired entities.
     * 
     * @param area The area to select the entities in.
     */
    public void select (Rectangle2D area) {
        deselectAll();
        for (InteractiveEntity ie : getAllEntities()) {
            if (area.intersects(ie.getBounds())) {
                select(ie);
            }
        }
    }

    /**
     * Sets the Manager into multi select mode which
     * allows the user to select more than one entity at a time.
     * 
     * @param val whether it is multi select or not
     */
    public void setMultiSelect (boolean val) {
        myMultiSelect = val;
    }

    @Override
    public void update (double elapsedTime) {
        for (Unit u : myUnits) {
            u.update(elapsedTime);
        }
    }
    
    public void add (Unit unit) {
        myUnits.add(unit);
    }
}
