package games.scroller.mr_fish.sprites.items;

import games.scroller.mr_fish.sprites.FishLib;
import games.scroller.mr_fish.sprites.player.MrFish;
import java.awt.Dimension;
import util.Location;
import vooga.scroller.sprites.superclasses.GameCharacter;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;

public abstract class Item extends GameCharacter {

    private static final int DEFAULT_ITEM_DAMAGE = 0;
    private static final int DEFAULT_ITEM_HEALTH = 1;
    //private static final Pixmap EXPLODED_ITEM = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "explosion.gif");
    
    public Item (ISpriteView image, Location center, Dimension size) {
        super(image, center, size, DEFAULT_ITEM_HEALTH, DEFAULT_ITEM_DAMAGE);
    }

    @Override
    public void handleDeath (vooga.scroller.level_editor.Level level) {
        // TODO Auto-generated method stub

    }
    
    
    public abstract int getValue();
    
    public abstract void useItem(MrFish p); 
    
    
    

}
