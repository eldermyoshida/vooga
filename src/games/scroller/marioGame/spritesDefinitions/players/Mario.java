package games.scroller.marioGame.spritesDefinitions.players;

import java.awt.Dimension;
import util.Location;
import util.Vector;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import vooga.scroller.level_management.IInputListener;
import vooga.scroller.marioGame.spritesDefinitions.MarioLib;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.util.physics.Force;
import vooga.scroller.util.physics.Gravity;
import vooga.scroller.view.GameView;

@InputClassTarget
public class Mario extends Player implements IInputListener{


    private static final String CONTROLS_FILE_PATH = "vooga/scroller/marioGame/controls/MarioMapping";
   
    
    private static final int MAX_JUMPS = 2;
    private static final int MAX_HORIZONTAL_SPEED = 5;
    private static final Pixmap DEFAULT_IMAGE = MarioLib.makePixmap("standright.png");
    private static final int DEATH_PENALTY = 1000;


    private static final Vector JUMP_VELOCITY = new Vector(Sprite.UP_DIRECTION, 100);


    private static final double MOVE_MAGNITUDE = 10;


    private static final double MAX_SPEED = 300;

   
    private int myJumpCount;
    private Force myGravity;


    public Mario (Location center, Dimension size, GameView gameView, ScrollingManager sm) {
        super(DEFAULT_IMAGE, center, size, gameView, sm, new Integer(1), new Integer (1));
        MarioLib.addLeftRightAnimationToPlayer(this, "mario.gif");
        myJumpCount = 0;
        myGravity = new Gravity(this);

    }

    @Override
    public void update (double elapsedTime, Dimension bounds) {
        myGravity.apply();

        if (myJumpCount == MAX_JUMPS && this.getVelocity().getComponentVector(Sprite.UP_DIRECTION).getMagnitude() < .5) {
            myJumpCount = 0;
        }
        
        double leftMag = this.getVelocity().getComponentVector(Sprite.LEFT_DIRECTION).getMagnitude();
        double rightMag = this.getVelocity().getComponentVector(Sprite.RIGHT_DIRECTION).getMagnitude();
        
        if( leftMag > MAX_HORIZONTAL_SPEED){
            Vector left = new Vector(LEFT_DIRECTION,MAX_HORIZONTAL_SPEED- leftMag);
            this.addVector(left);
        }
        
        if( rightMag > MAX_HORIZONTAL_SPEED){
            Vector right= new Vector(RIGHT_DIRECTION,MAX_HORIZONTAL_SPEED- rightMag);
            this.addVector(right);
        }
        super.update(elapsedTime, bounds);
        checkSpeed();
    }

    private void checkSpeed () {
        double speed = this.getVelocity().getMagnitude();       
        if(speed > MAX_SPEED){
            double angle = this.getVelocity().getDirection();
            this.setVelocity(angle, MAX_SPEED);
        }       
    }

    @Override
    public void handleDeath () {
        
        
    }

    public Player getPlayer () {
        return this;
    }   
    
    @Override
    public String getInputFilePath () {
        return CONTROLS_FILE_PATH;
    }

    @InputMethodTarget(name = "left")
    public void walkLeft() {        
        Vector force = this.getVelocity().getComponentVector(Player.RIGHT_DIRECTION);
        force.negate();
        this.addVector(force);     
        this.translate(new Vector(Sprite.LEFT_DIRECTION, MOVE_MAGNITUDE));

    }
    
    @InputMethodTarget(name = "right")
    public void walkRight() {
        Vector force = this.getVelocity().getComponentVector(Player.LEFT_DIRECTION);
        force.negate();
        this.addVector(force);     
        this.translate(new Vector(Sprite.RIGHT_DIRECTION, MOVE_MAGNITUDE));

    }
    
    @InputMethodTarget(name = "jump")
    public void jump() {
        if(this.getVelocity().getComponentVector(Sprite.UP_DIRECTION).getMagnitude() < .5 &&
            this.getVelocity().getComponentVector(Sprite.DOWN_DIRECTION).getMagnitude() < .5 && myJumpCount < MAX_JUMPS ) {           
            addVector(JUMP_VELOCITY);
            myJumpCount +=1;
        }
    }

    
    public void incrementScore (int increment) {
        // TODO Auto-generated method stub
        
    }
}



