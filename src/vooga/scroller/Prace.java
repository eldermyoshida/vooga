package vooga.scroller;

import util.Vector;

public class Prace {

    /**
     * @param args
     */
    public static void main (String[] args) {
       Vector v = new Vector(0, 100);
       
       Vector v2 = new Vector (90, 100);
       
       System.out.println(v.getComponentVector(0));
       System.out.println(v.getComponentVector(90));
       System.out.println(v.getComponentVector(180));

    }

}
