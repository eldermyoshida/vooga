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
     * @throws CloneNotSupportedException 
     */
    public static void main(String[] args) throws CloneNotSupportedException {


        Pixmap p = new Pixmap("soldier.png");
        Location l = new Location(40,50);
        Dimension s = new Dimension();
        Sound soun = new Sound("pikachu.wav");

        Interactive a = new Soldier(p,l,s,soun,20,20);
        a.setAttackStrategy(new CannotAttack());
       
        
        
        Interactive b = new Soldier(p,new Location(20,30),s,soun,20,20);
        Projectile proj = new Bullet(new Pixmap("bullet.png"), b.getCenter(), new Dimension(30, 30), soun, 10, 1);
        b.setAttackStrategy(new CanAttack());
        ((CanAttack) b.getAttackstrategy()).addWeapons(new Gun(0, proj, 50, b.getCenter()));

        
        for(int i = 0 ; i < 10 ; i++){
        	System.out.println(b.getHealth());
        	if(((CanAttack) b.getAttackstrategy()).hasWeapon()){
        	    System.out.println("er ma gawd");
        	}
        	a.accept(b);
        }


    }

}
