package games.scroller.mr_fish.sprites.player.states;

import java.awt.Dimension;
import java.awt.Graphics2D;
import games.scroller.mr_fish.sprites.player.MrFish;
import games.scroller.mr_fish.sprites.player.stats.Inventory;
import vooga.scroller.sprites.state.SpriteState;

public class InventoryState extends SpriteState<MrFish> {

    private static final int PRIORITY = -1;
    public static final int STATE_ID = 99;
    
    private Inventory myInventory;
    
    public InventoryState (MrFish unit, Inventory inventory) {
        super(unit);
        myInventory = inventory;
    }


    @Override
    public void update (double elapsedTime, Dimension bounds) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paint (Graphics2D pen, double angle) {
        myInventory.paint(pen);
        getUnit().getView().paint(pen, getUnit().getPaintLocation(), getUnit().getSize());
    }

    @Override
    public int getPaintPriority () {
        return PRIORITY;
    }

    @Override
    public void activate () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deactivate () {
        // TODO Auto-generated method stub
        
    }

}
