package vooga.rts.gamedesign;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.rtsprite.Bullet;
import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
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
        Location l = new Location();
        Dimension s = new Dimension();
        Sound soun = new Sound("pikachu.wav");

        Interactive a = new Soldier(p,l,s,soun,20,20);
        a.setAttackStrategy(new CanAttack());
        Projectile proj = new Bullet(new Pixmap("bullet.png"), a.getCenter(), new Dimension(30, 30), soun, 10, 1);
        ((CanAttack) a.getAttackstrategy()).addWeapons(new Gun(10, proj, 10, a.getCenter()));
        Interactive b = new Soldier(p,l,s,soun,20,20);

        //a.visit(b);
        b.accept(a);


    }

}
