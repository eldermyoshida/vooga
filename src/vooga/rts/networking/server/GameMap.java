package vooga.rts.networking.server;

public interface GameMap {

    public String getName ();
    
    public int getMaxPlayers ();
    
    public int getMaxTeams ();
    
    public int getMaxPlayersPerTeam ();
}
