package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;
import java.awt.Graphics2D;


import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;

public class Bullet extends Projectile{

    public Bullet(Pixmap pixmap, Location loc, Dimension size, int teamID, int damage, int health){
        super(pixmap, loc, size, teamID, damage, health);
    }
    
    public void paint(Graphics2D pen){
        super.paint(pen);
    }
}

