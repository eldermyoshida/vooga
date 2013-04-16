package vooga.rts.manager;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import vooga.rts.controller.Command;
import vooga.rts.controller.Controller;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.state.State;

public class Manager implements Controller, State  {
    
    private List<InteractiveEntity> myUnits;
    
    public Manager () {
        myUnits = new ArrayList<InteractiveEntity>();
    }
    @Override
    public void receiveCommand (Command command){
        
    }

    @Override
    public void sendCommand (Command command) {
        
    }
    
    public void add (InteractiveEntity unit) {
        myUnits.add(unit);
    }
    
    public void selectDrag (Rectangle2D area) {
      
    }
    
    public void select (InteractiveEntity unit) {
        unit.select(true);
    }
    
    public void deselect (InteractiveEntity unit) {
        unit.select(false);
    }
    
    public void deselectAll () {
        for (InteractiveEntity u: myUnits) {
            deselect(u);
        }
    }
    @Override
    public void update (double elapsedTime) {
        for (InteractiveEntity u: myUnits) {
            u.update(elapsedTime);
        }        
    }
    @Override
    public void paint (Graphics2D pen) {
        for (InteractiveEntity u: myUnits) {
            u.paint(pen);
        }        
    }
    
    
}
