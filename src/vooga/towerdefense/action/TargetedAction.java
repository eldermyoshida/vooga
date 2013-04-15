package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.gameElements.GameElement;

/**
 * Action that targets a GameElement or multiple GameElements
 * @author Matthew Roy
 *
 */
public class TargetedAction extends AbstractAction {
    
    protected List<GameElement> myTargets;

    public TargetedAction (GameElement initiator, GameElement target) {
        super(initiator);
        myTargets = new ArrayList<GameElement>();
        myTargets.add(target);
    }
    
    /**
     * Acts on the list of targets
     * @param initiator
     * @param targets list of the targets for this action
     */
    public TargetedAction (GameElement initiator, List<GameElement> targets) {
        super(initiator);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void initAction () {
        // TODO Auto-generated method stub

    }

    @Override
    public void execute (double elapsedTime) {
        // TODO Auto-generated method stub

    }
    
    public List<GameElement> getTargets() {
        return myTargets;
    }
    
    public void addTarget(GameElement target) {
        myTargets.add(target);
    }

}
