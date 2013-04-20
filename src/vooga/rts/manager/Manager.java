package vooga.rts.manager;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.action.Action;
import vooga.rts.action.IActOn;
import vooga.rts.commands.Command;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.state.State;
import vooga.rts.util.Location3D;


/**
 * The Manager class is responsible for managing all of the units and buildings
 * that each player has control of.
 * Commands are passed through to the Manager and the appropriate actions are
 * executed on the selected units or even the manager.
 * 
 * @author Jonathan Schmidt
 * @author Challen Herzberg-Brovold
 * 
 */
public class Manager implements State, IActOn {

    private List<InteractiveEntity> myEntities;
    private List<InteractiveEntity> mySelectedEntities;
    private Map<Integer, List<InteractiveEntity>> myGroups;
    private boolean myMultiSelect;
    private Map<String, Action> myActions;

    public Manager () {
        myEntities = new ArrayList<InteractiveEntity>();
        mySelectedEntities = new ArrayList<InteractiveEntity>();
        myGroups = new HashMap<Integer, List<InteractiveEntity>>();
        myMultiSelect = false;
        myActions = new HashMap<String, Action>();
        addAction();
    }

    @Override
    public void paint (Graphics2D pen) {
        for (InteractiveEntity u : myEntities) {
            u.paint(pen);
        }
    }

    @Override
    public void update (double elapsedTime) {
        for (InteractiveEntity u : myEntities) {
            u.update(elapsedTime);
        }
    }

    @Override
    public void receiveCommand (Command command) {
        updateAction(command);
    }

    @Override
    public void updateAction (Command command) {
        if (myActions.containsKey(command.getMethodName())) {
            Action current = myActions.get(command.getMethodName());
            current.update(command);
            current.apply();
        }
    }

    @Override
    public void put (String input, Action action) {
        myActions.put(input, action);

    }

    public void applyAction (Command command) {
        for (InteractiveEntity u : mySelectedEntities) {
            if (u.containsInput(command)) {
                u.updateAction(command);
                u.getAction(command).apply();
            }
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

    public void deselect (Location3D location) {
        for (int i = getAllEntities().size() - 1; i >= 0; i--) {
            InteractiveEntity ie = getAllEntities().get(i);
            if (ie.intersects(location)) {
                deselect(ie);
                return;
            }
        }
        deselectAll();
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
    public void select (Shape area) {
        deselectAll();
        boolean multi = myMultiSelect;
        setMultiSelect(true);
        for (InteractiveEntity ie : myEntities) {
            if (area.intersects(ie.getBounds()) || area.contains(ie.getBounds())) {
                select(ie);
            }
        }
        setMultiSelect(multi);
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

    public void addAction () {
        put("drag", new DragSelectAction(this));
        put("leftclick", new LeftClickAction(this));
        put("rightclick", new RightClickAction(this));
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

}