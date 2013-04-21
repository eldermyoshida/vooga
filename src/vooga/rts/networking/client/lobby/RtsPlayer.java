package vooga.rts.networking.client.lobby;

public class RTSPlayer extends Player {
    
    private String myFaction;
    
    public RTSPlayer (String name, String faction) {
        super(name);
        myFaction = faction;
        
    }
    
    public RTSPlayer(String name) {
        super(name);
    }
    
    
    public String getFaction() {
        return myFaction;
    }

    public void setFaction(String faction) {
        myFaction = faction;
    }
}
