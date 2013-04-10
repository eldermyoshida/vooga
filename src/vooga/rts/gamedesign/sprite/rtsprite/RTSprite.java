package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;
import java.awt.Graphics2D;
import vooga.rts.gamedesign.sprite.GameSprite;
import vooga.rts.gamedesign.sprite.Sprite;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.gamedesign.strategy.gatherstrategy.CannotGather;
import vooga.rts.gamedesign.strategy.gatherstrategy.GatherStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.CannotOccupy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.Vector;

/**
 * This class represents a sprite that can be attacked and that can visit
 * other sprites of its type.  Because these sprites can be attacked, they
 * have a current health and a max health.  These sprites are also specific 
 * to a taem so they know the ID of their team.  These sprites will also
 * have the ability to have occupy strategies and attack strategies.  Examples
 * of RTSsprites are projectiles, resources, and interactives (such as units
 * and buildings).
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class RTSprite extends GameSprite implements IAttackable, RTSpriteVisitor {


    
    private Vector myVelocity;
    private Sound mySound;
    
    private Vector myOriginalVelocity;
    
    private OccupyStrategy myOccupyStrategy;
    private AttackStrategy myAttackStrategy;
    private GatherStrategy myGatherStrategy;

    private int armor;
    private int curHealth;
    private int maxHealth;
    private int playerID;



    public RTSprite (Pixmap image, Location center, Dimension size, Vector velocity, Sound sound, int teamID, int health) {
        super(image, center, size);
        myOriginalVelocity = new Vector(velocity);
        maxHealth = health;
        curHealth = maxHealth;
        mySound = sound;
        playerID = teamID;
        myAttackStrategy = new CanAttack();
        myGatherStrategy = new CannotGather();
        myOccupyStrategy = new CannotOccupy();
    }

    /** 
     *  This would accept RTSpriteVisitors and behave according to the 
     *  visitor's visit method. This code will always run 
     *  RTSpriteVisitor.visit(this). "this" being the subclass of RTSprite. 
     * @throws CloneNotSupportedException 
     */
    public void accept(RTSpriteVisitor visitor) {
        try {
            visitor.visit(this);
        }
        catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void setHealth(int health){
        curHealth = health;
    }
    public int getHealth(){
        return curHealth;
    }


    public Sound getSound(){
        return mySound;
    }

    public void visit(IAttackable a) throws CloneNotSupportedException{
        if(!isDead()){
            myAttackStrategy.attack(a);
        }
    }
    public void visit(IGatherable g){
        myGatherStrategy.gather(g);

    }
    public void visit(IOccupiable o){
        myOccupyStrategy.occupy(o);
    }
    /**
     * Rotates the Unit by the given angle. 
     * @param angle
     */
    public void turn(double angle){
        myVelocity.turn(angle);
    }
    /**
     * Sets the attack strategy for an interactive. Can set the interactive
     * to CanAttack or to CannotAttack and then can specify how it would
     * attack.
     * 
     * @param newStrategy is the new attack strategy that the interactive
     *        will have
     */
    public void setAttackStrategy(AttackStrategy newStrategy){
        myAttackStrategy = newStrategy;
    }
    /**
     * Sets the gatehr strategy for an interactive. Can set the interactive
     * to CanGather or to CannotGather and then can specify how it would
     * gather.
     * 
     * @param newStrategy is the new gather strategy that the interactive
     *        will have
     */
    public void setGatherStrategy(GatherStrategy newStrategy){
        myGatherStrategy = newStrategy;
    }
    /**
     * Sets the occupy strategy for an interactive. Can set the interactive
     * to CanOccupy or to CannotOccupy.
     * 
     * @param newStrategy is the new occupy strategy that the interactive
     *        will have
     */
    public void setOccupyStrategy(OccupyStrategy newStrategy){
        myOccupyStrategy = newStrategy;
    }


    /**
     * Checks to see if an RTSprite is dead.
     * @return true if the RTSprite has been killed and true if the RTSprite 
     * is still alive.
     */
    public boolean isDead() {
        return curHealth <= 0;
    }

    /**
     * Moves the Unit only. Updates first the angle the Unit is facing,
     * and then its location.
     * Possible design choice error. 
     */
    public void move (Location loc){
        double angle = getCenter().difference(loc).getDirection();
        double magnitude = getCenter().difference(loc).getMagnitude();
        turn(angle);
        setVelocity(angle, magnitude);
    }


    @Override
    public int calculateDamage(int damage) {
        return damage * (1-(armor/(armor+100)));
    }

    @Override
    public void changeHealth(int change) {
        curHealth -= calculateDamage(change);

    }

    @Override
    public void update(double elapsedTime) {                
        Vector scale = new Vector(getVelocity());
        scale.scale(1/elapsedTime);
        getCenter().translate(scale);
        resetBounds();
    }
    /**
     * Returns the current attack strategy of the interactive
     * 
     * @return the current attack strategy
     */
    public AttackStrategy getAttackStrategy () {
        return myAttackStrategy;
    }
    public void die(){
        curHealth = 0;
    }

    public void paint(Graphics2D pen) {
        if (!isDead()) {
            super.paint(pen);
        }
    }

}