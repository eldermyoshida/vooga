package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import java.awt.Graphics2D;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.RTSpriteVisitor;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;


public class InteractiveEntity extends GameEntity implements IAttackable{
	
	 
    private Sound mySound;
   
    private AttackStrategy myAttackStrategy;

    private int myArmor;


    public InteractiveEntity (Pixmap image, Location center, ThreeDimension size, Sound sound, int teamID) {
        super(image, center, size, teamID);
        mySound = sound;
        myAttackStrategy = new CannotAttack();
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


    public Sound getSound(){
        return mySound;
    }

    public void visit(IAttackable a) throws CloneNotSupportedException{
        if(!isDead()){
            myAttackStrategy.attack(a);
        }
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
     * Moves the Unit only. Updates first the angle the Unit is facing,
     * and then its location.
     * Possible design choice error. 
     */
    public void move(Location loc){
        double angle = getCenter().difference(loc).getDirection();
        double magnitude = getCenter().difference(loc).getMagnitude();
        turn(angle);
        setVelocity(angle, magnitude);
    }

    public int calculateDamage(int damage) {
        return damage * (1-(myArmor/(myArmor+100)));
    }



    /**
     * Returns the current attack strategy of the interactive
     * 
     * @return the current attack strategy
     */
    public AttackStrategy getAttackStrategy () {
        return myAttackStrategy;
    }


    public void paint(Graphics2D pen) {
        if (!isDead()) {
            super.paint(pen);
        }
    }
	
	
	
}
