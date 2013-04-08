package vooga.rts.gamedesign;

import java.awt.Dimension;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

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
        Interactive b = new Soldier(p,l,s,soun,20,20);

        //a.visit(b);
        b.accept(a);


    }

}
