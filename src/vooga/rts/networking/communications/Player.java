package vooga.rts.networking.communications;
/**
 * Class represents a player that can play a game
 * (can be either AI or Human)
 * Note: hopefully this will be replaced by a Player class from the arcade, if not this
 * will at a minimum serve as a handover between arcade settings and game settigns
 * @author srwareham
 * @author Henrique Moraes
 *
 */
public class Player {
    private String myName;
    private int myID;
    private String myFaction;
    private int myTeam;
    
    public Player (String name, int team, String faction, int id) {
        myName = name;
        myID = id;
        myFaction = faction;
        myTeam = team;
    }
    
    public String getName() {
        return myName;
    }
    
    public int getID() {
        return myID;
    }
    
    public String getFaction () {
        return myFaction;
    }
    
    public int getTeam () {
        return myTeam;
    }
    
    public void setFaction (String faction) {
        myFaction = faction;
    }
    
    public void setTeam (int team) {
        myTeam = team;
    }
    
    @Override
    public boolean equals(Object obj){
    	if (!(obj instanceof Player)) return false;
    	Player other = (Player) obj;
    	if (other.getID() == myID) return true;
    	
    	return false;
    }

}
