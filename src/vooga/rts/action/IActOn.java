package vooga.rts.action;

import vooga.rts.commands.Command;

public interface IActOn {
    // Possible an addAction() method
    public void put (String input, Action action);
    
    public void updateAction (Command command);
}
