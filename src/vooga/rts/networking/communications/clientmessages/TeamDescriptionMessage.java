package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.communications.Message;
import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.GUIThreadContainer;
import vooga.rts.networking.server.IThreadContainer;

/**
 * 
 * @author Henrique Moraes
 *
 */
public class TeamDescriptionMessage extends GUIMessage{
    String [][] myTeams;
    
    public TeamDescriptionMessage(String host, int teams, int playersPerTeam) {
        super(host);
        myTeams = new String [teams][playersPerTeam];
    }
    
    public TeamDescriptionMessage(String host, String[][] teams){
        super(host);
        myTeams = teams;
    }
    
    public String[] getTeam(int teamIndex){
        return myTeams[teamIndex];
    }
    
    public String [][] getAllTeams(){
        return myTeams;
    }
    
    public void setPlayer(String playerName, int teamIndex){
        for (int i = 0; i < myTeams[teamIndex].length; i++){
            String name = myTeams[teamIndex][i];
            if (name == null || name.isEmpty()){
                myTeams[teamIndex][i] = playerName;
                break;
            }
        }
    }
    
    public void removePlayer(String playerName) {
        for (int i = 0; i< myTeams.length ; i++){
            for (int j =0; j< myTeams[i].length ; j++) {
                if (playerName.equals(myTeams[i][j])){
                    myTeams[i][j] = "";
                }
            }
        }
    }
    
    @Override
    public void affectServer (ConnectionThread thread, IThreadContainer server) {
        GUIThreadContainer gui = (GUIThreadContainer) server;
        gui.readMessage(this);    
    }
}
