package vooga.rts.manager;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import vooga.rts.controller.Command;
import vooga.rts.controller.Controller;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.state.State;

public class Manager implements State  {
    
    private List<InteractiveEntity> myUnits;
    private List<InteractiveEntity> mySelectedUnits;
    
    public Manager () {
        myUnits = new ArrayList<InteractiveEntity>();
        mySelectedUnits = new ArrayList<InteractiveEntity>();
    }
    
    @Override
    public void receiveCommand (Command command){
        // This will create an action and then use the .execute() method to invoke it 
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
    
    public void add (InteractiveEntity unit) {
        myUnits.add(unit);
    }
    
    // All the of the following methods need to be turned in to commands!!!
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
}