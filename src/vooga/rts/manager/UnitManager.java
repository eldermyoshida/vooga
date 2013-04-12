package vooga.rts.manager;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import vooga.rts.IGameLoop;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Unit;


public class UnitManager implements IGameLoop {
    private List<Unit> myUnits;
    private List<Unit> mySelectedUnits;
    
    public void addUnit(Unit u) {
        myUnits.add(u);
    }

    public UnitManager () {
        myUnits = new ArrayList<Unit>();
        mySelectedUnits = new ArrayList<Unit>();
    }

    public void select (Unit u) {
        if (!mySelectedUnits.contains(u)) {
            if (myUnits.contains(u)) {
                mySelectedUnits.add(u);
            }
        }
    }

    public void deselect (Unit u) {
        if (mySelectedUnits.contains(u)) {
            mySelectedUnits.remove(u);
        }
    }
    
    public void group(int groupID) {
        // TODO: implement
    }
    
    public void activateGroup(int groupID) {
        // TODO: implement
    }
    
    public void deselectAll() {
        mySelectedUnits.clear();
    }
    
    public List<Unit> getSelected() {
        return mySelectedUnits;
    }
    
    public List<Unit> getAllUnits() {
        return myUnits;
    }

    @Override
    public void update (double elapsedTime) {
        for (Unit u : myUnits) {
            u.update(elapsedTime);
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        for (Unit u : myUnits) {
            u.paint(pen);
        }
    }
    
}
