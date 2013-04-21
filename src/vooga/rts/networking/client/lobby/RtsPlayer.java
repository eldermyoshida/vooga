package vooga.rts.networking.client.lobby;

public class RtsPlayer extends Player {
    
    private String myFaction;
    
    public RtsPlayer (String name, String faction) {
        super(name);
        myFaction = faction;
        
    }

}
