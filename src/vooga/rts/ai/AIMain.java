package vooga.rts.ai;

import java.util.List;
import java.awt.Dimension;
import vooga.rts.map.*;
import vooga.rts.util.Location;

public class AIMain {

    /**
     * @param args
     */
    public static void main (String[] args) {
        GameMap map = new GameMap(new Dimension(0,0), new Dimension(0,0));
        PathingHelper help = new PathingHelper(map);
        help.constructPath(map.get(0,0), map.get(5,2));
        MapNode next = null;
        System.out.println(help.size());
        while(help.size() > 0) {
            next = help.getNext(next);
            System.out.print(next.getX() + " ");
            System.out.println(next.getY());
        }
    }

}
