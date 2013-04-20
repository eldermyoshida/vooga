package vooga.rts.util;

import java.util.TimerTask;

public class GameTimer {
    
    private long myLastRun = System.nanoTime();
    
    public GameTimer(TimerTask update, TimerTask paint, int FPS) {
        long now = System.nanoTime();
        long updateTime = now - myLastRun;
        double elapsedSeconds = updateTime / 1000*1000*1000;
        
    }
}
