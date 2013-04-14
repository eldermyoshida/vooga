package vooga.scroller.statistics;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerScore implements Statistic<Integer> {

    private int myScore;
    
    public PlayerScore(int startScore) {
        myScore = startScore;
    }
    
    @Override
    public void addValue (Integer obj) {
        myScore += obj;
        
    }

    @Override
    public void removeValue (Integer obj) {
        myScore -= obj;       
    }

    @Override
    public Collection<Integer> getAllValues () {
        Collection<Integer> res = new ArrayList<Integer>();
        res.add(myScore);
        return res;
    }

}
