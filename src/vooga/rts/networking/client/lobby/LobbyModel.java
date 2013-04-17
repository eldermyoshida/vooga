package vooga.rts.networking.client.lobby;

import java.util.Comparator;
import java.util.PriorityQueue;
import vooga.rts.networking.communications.LobbyInfo;

public class LobbyModel {
    private LobbyInfo myInfo;
    private PriorityQueue<Team> myTeams;
    private String myLobbyName;
    private String myMapName;
    
    
/**
 * This functions as the waiting area for a game about to commence.
 * This also contains necessary state to pass along to the game in order to begin the simulation/ gameplay.
 * Note: this will probably be mooved to the server, and the view for this will live
 * in the client (and pull from the server-side model)
 * @param lobbyName
 * @param mapName
 * @param seedPlayer
 * @param maxPlayers
 * @param playersPerTeam
 */
    public LobbyModel(String lobbyName,String mapName, Player seedPlayer, int maxPlayers, int playersPerTeam) {
        myLobbyName = lobbyName;
        myMapName= mapName;
        
        int numTeams = maxPlayers/ playersPerTeam;
        Comparator<Team> comparator = new LobbyTeamComparator();
        myTeams = new PriorityQueue<Team>(numTeams, comparator);
    }
    
    
    /**
     * This function serves to offer support for sending a serialized summary of the lobby
     * so that connected clients can have an object sent to them containing relevant on-screen information.
     * @return
     */
    public LobbyInfo getLobbyInfo() {
        return myInfo;
        
    }
    /**
     * This function serves to offer support of overwriting the state of the model from a summary file
     * Note :This will only be used if we decide to implement the LobbyModel in both the server and Client
     * @param info
     */
    public void updateLobbyInfo(LobbyInfo info) {
        myInfo = info;
    }
    
    /**
     * This Method checks to see if there are any available slots in the lobby, if so, 
     * A player is added to the team with the fewest players.  If all teams share
     * the same number of players, the new player is added to the team with the lowest number, ie team 1 first.
     * @param player
     */
    public void addPlayer(Player player) {
        Team head = myTeams.peek();
        if (!head.isFull()) {
            head.addPlayer(player);
        }else{
            //TODO:throw error message that the server is full.  once again this
            //is called internally and this error should never occur
        }
    }
    /**
     * This method returns whether or not the lobby is full.
     * 
     * Note: could probably just return the value of the head, because the queue is in order
     * @return
     */
    public boolean isLobbyFull() {
        for (Team team: myTeams) {
            if (!team.isFull()) {
                return false;
            }
        }
        return true;
    }    
    
    //TODO:  Either need a method to actually start the game by passing all the necessary constructors,
    //or some sort of boolean that states that the game is ready to be played, so come find my relevant information
    //and begin the game with it
}
