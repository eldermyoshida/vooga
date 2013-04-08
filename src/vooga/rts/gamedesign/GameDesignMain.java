package vooga.rts.gamedesign;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.rtsprite.Bullet;
import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.gamedesign.Weapon;

public class GameDesignMain {

    /**
     * @param args
     */
    public static void main(String[] args) {


        Pixmap p = new Pixmap("soldier.png");
        Location l = new Location(40,50);
        Dimension s = new Dimension();
        Sound soun = new Sound("pikachu.wav");

        Interactive a = new Soldier(p,l,s,soun,20,40);
        a.setAttackStrategy(new CannotAttack());
       
        
        
        Interactive b = new Soldier(p,new Location(20,30),s,soun,20,50);
        Projectile proj = new Bullet(new Pixmap("bullet.png"), b.getCenter(), new Dimension(30, 30), soun, 10, 1);
        b.setAttackStrategy(new CanAttack());
        ((CanAttack) b.getAttackstrategy()).addWeapons(new Gun(0, proj, 50, b.getCenter()));

        
        for(int i = 0 ; i < 10 ; i++){
        	if(a.isDead()){
        	    System.out.println("SOldier A DIED WOOHOO");
        	}
        	else {
        	    System.out.println(a.getHealth());
        	    a.accept(b);
        	}
        }


    }

}
