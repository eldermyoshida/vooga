package vooga.rts.manager;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import vooga.rts.IGameLoop;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Units;


public class UnitManager implements IGameLoop {
    private List<Units> myUnits;
    private List<Units> mySelectedUnits;
    
    public void addUnit(Units u) {
        myUnits.add(u);
    }

    public UnitManager () {
        myUnits = new ArrayList<Units>();
        mySelectedUnits = new ArrayList<Units>();
    }

    public void select (Units u) {
        if (!mySelectedUnits.contains(u)) {
            if (myUnits.contains(u)) {
                mySelectedUnits.add(u);
            }
        }
    }

    public void deselect (Units u) {
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
    
    public List<Units> getSelected() {
        return mySelectedUnits;
    }
    
    public List<Units> getAllUnits() {
        return myUnits;
    }

    @Override
    public void update (double elapsedTime) {
        for (Units u : myUnits) {
            u.update(elapsedTime);
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        for (Units u : myUnits) {
            u.paint(pen);
        }
    }
    
}
