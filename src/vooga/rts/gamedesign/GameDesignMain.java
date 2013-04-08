package vooga.rts.gamedesign;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;

import vooga.rts.gamedesign.sprite.rtsprite.Bullet;
import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Units;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
import vooga.rts.gamedesign.strategy.attackstrategy.CannotAttack;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.ArmorUpgradeNode;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.gamedesign.Weapon;

public class GameDesignMain {

    /**
     * @param args
     * @throws CloneNotSupportedException 
     * @throws NoSuchMethodException 
     * @throws InstantiationException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws IllegalArgumentException 
     */
    public static void main(String[] args) {


        Pixmap p = new Pixmap("soldier.png");
        Location l = new Location(40,50);
        Dimension s = new Dimension();
        Sound soun = new Sound("pikachu.wav");

        Units a = new Soldier(p,l,s,soun,20,40);
        a.setAttackStrategy(new CannotAttack());

        Units b = new Soldier(p,new Location(20,30),s,soun,20,50);
        Projectile proj = new Bullet(new Pixmap("bullet.png"), b.getCenter(), new Dimension(30, 30), soun, 10, 1);
        b.setAttackStrategy(new CanAttack());

        ((CanAttack) b.getAttackStrategy()).addWeapons(new Gun(0, proj, 50, b.getCenter(),20));
        a.accept(b);

        Units c = new Soldier(p,l,s,soun,20,40);
        c.setAttackStrategy(new CannotAttack());
        System.out.println("Soldier C before upgrade " + c.getHealth());
        
        try {
            c.upgradeNode(c.getTree().findCurrent("armor1"));
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Soldier C after upgrade " + c.getHealth());
        
        
    }

}
