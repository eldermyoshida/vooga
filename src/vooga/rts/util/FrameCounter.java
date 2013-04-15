package vooga.rts.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Queue;
import vooga.rts.IGameLoop;

public class FrameCounter implements IGameLoop{

    private static final int COUNT_PER_CYCLE = 10;
    
    private Queue<Long> myTimes;

    private double myRate;
    
    
    public FrameCounter () {
        myTimes = new LinkedList<Long>();
    }


    @Override
    public void update (double elapsedTime) {
        
        myTimes.add(System.currentTimeMillis());
        
        if (myTimes.size() > COUNT_PER_CYCLE) {
            long change = System.currentTimeMillis() - myTimes.poll();
            double inS = ((double)change) / 1000;
            myRate = COUNT_PER_CYCLE / inS;
        }
    }


    @Override
    public void paint (Graphics2D pen) {
        Text f = new Text("FPS: " + String.format("%.2f", myRate));
        f.paint(pen, new Location(50, 10), Color.RED);
    }

}
