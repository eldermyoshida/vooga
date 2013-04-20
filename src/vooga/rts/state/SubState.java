package vooga.rts.state;

import java.util.Observable;
import java.util.Observer;

public abstract class SubState extends Observable implements State {

    public SubState (Observer observer) {
        addObserver(observer);
    }
}
