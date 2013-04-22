package vooga.rts.action;

import vooga.rts.manager.Manager;

public abstract class ManagerAction implements Action {

    private Manager myManager;
    
    public ManagerAction(Manager manager) {
        myManager = manager;
    }
    
    public Manager getManager() {
        return myManager;
    }
}
