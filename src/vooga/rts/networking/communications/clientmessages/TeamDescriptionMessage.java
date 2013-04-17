package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.communications.Message;

public class TeamDescriptionMessage extends Message{
    String [][] myTeams;
    
    public TeamDescriptionMessage(int teams, int playersPerTeam) {
        myTeams = new String [teams][playersPerTeam];
    }
    
    public TeamDescriptionMessage(String[][] teams){
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
}
