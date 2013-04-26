package games.scroller.mr_fish.sprites.player;

import games.scroller.mr_fish.sprites.FishLib;
import games.scroller.mr_fish.sprites.player.states.TiltDown;
import games.scroller.mr_fish.sprites.player.states.TiltUp;
import games.scroller.mr_fish.sprites.player.stats.Inventory;
import java.awt.Dimension;
import util.Location;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.animation.movement.MoveDown;
import vooga.scroller.sprites.animation.movement.MoveLeft;
import vooga.scroller.sprites.animation.movement.MoveRight;
import vooga.scroller.sprites.animation.movement.MoveUp;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.statistics.Statistic;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.GameView;

@InputClassTarget
public class MrFish extends Player {

    private static final Pixmap MR_FISH_VIEW = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_move_right.gif");
    private static final Dimension MR_FISH_SIZE = new Dimension(32,32);
    public static final int MR_FISH_HEALTH = 20;
    private static final int MR_FISH_DAMAGE = 10;
    private static final int DEATH_PENALTY = 100;
    private static final String INPUT_LOCATION = "games/scroller/mr_fish/controls/MrFishMapping";
    private static final ISpriteView MOVE_LEFT = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_move_left.gif");
    private static final ISpriteView STAND_LEFT = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_stand_left.gif");
    private static final double SPEED = 75;
    private static final ISpriteView MOVE_RIGHT = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_move_right.gif");
    private static final ISpriteView STAND_RIGHT = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_stand_right.gif");
    private static final ISpriteView MOVE_UP = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_move_up.gif");
    private static final ISpriteView STAND_UP = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_stand_up.gif");
    private static final ISpriteView MOVE_DOWN = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_move_down.gif");
    private static final ISpriteView STAND_DOWN = FishLib.makePixmap(FishLib.IMAGE_LOCATION, "frog_stand_down.gif");
    private static final double RATE_ROTATION = 2.0;
    
    
    
    private Inventory myInventory;
    private Statistic myScore;
    private Statistic myMoney;
    
    
    public MrFish (Location center, GameView gameView, ScrollingManager sm) {
        super(MR_FISH_VIEW, center, MR_FISH_SIZE, gameView, sm, MR_FISH_HEALTH, MR_FISH_DAMAGE);
        initializePossibleStates();
    }

    private void initializePossibleStates () {
        // TODO left, right, up, down, super, invincible
        
        // Movement states
        this.addPossibleState(MoveLeft.STATE_ID, new MoveLeft(this, MOVE_LEFT, STAND_LEFT, SPEED));
        this.addPossibleState(MoveRight.STATE_ID, new MoveRight(this, MOVE_RIGHT, STAND_RIGHT, SPEED));
        this.addPossibleState(MoveUp.STATE_ID, new MoveUp(this, MOVE_UP, STAND_UP, SPEED));
        this.addPossibleState(MoveDown.STATE_ID, new MoveDown(this, MOVE_DOWN, STAND_DOWN, SPEED));

        //this.addPossibleState(TiltUp.STATE_ID, new TiltUp(this, RATE_ROTATION, SPEED));
        //this.addPossibleState(TiltDown.STATE_ID, new TiltDown(this, RATE_ROTATION, SPEED));

        
    }

    @Override
    public String getInputFilePath () {
        return INPUT_LOCATION;
    }

    @Override
    public void handleDeath () {
        // lose all money
        myMoney.removeValue(myMoney.getAggregateValue());
        myScore.removeValue(DEATH_PENALTY);
    }

    
    @InputMethodTarget(name = "leftstart")
    public void walkLeft() {
        this.activateState(MoveLeft.STATE_ID);
    }
    
    @InputMethodTarget(name = "leftend")
    public void stopLeft() {        
        this.deactivateState(MoveLeft.STATE_ID);
    }
    
    @InputMethodTarget(name = "upstart")
    public void walkUp() {
        this.activateState(MoveUp.STATE_ID);
        //this.activateState(TiltUp.STATE_ID);
    }
    
    @InputMethodTarget(name = "upend")
    public void stopUp() {
        this.deactivateState(MoveUp.STATE_ID);
        //this.deactivateState(TiltUp.STATE_ID);

    }
    
    @InputMethodTarget(name = "downstart")
    public void walkDown() {
        this.activateState(MoveDown.STATE_ID);
        //this.activateState(TiltDown.STATE_ID);

    }
    
    @InputMethodTarget(name = "downend")
    public void stopDown() {
        //this.deactivateState(TiltDown.STATE_ID);

        this.deactivateState(MoveDown.STATE_ID);
    }
    
    @InputMethodTarget(name = "rightstart")
    public void walkRight() {
        this.activateState(MoveRight.STATE_ID);
    }
    
    @InputMethodTarget(name = "rightend")
    public void stopRight() {
        this.deactivateState(MoveRight.STATE_ID);
    }
}
