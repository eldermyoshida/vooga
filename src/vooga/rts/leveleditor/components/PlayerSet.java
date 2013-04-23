package vooga.rts.leveleditor.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.util.Location;

public class PlayerSet {
    
    private int myPlayerUpperLimit;
    private int myTeamUpperLimit;
    private int myPlayerNumber;
    
    private Map<Integer,List<Location>> myPlayers;
    
    
    public PlayerSet(int playerLimit, int teamLimit) {
        myPlayerUpperLimit = playerLimit;
        myTeamUpperLimit = teamLimit;
        myPlayerNumber = 0;
        
        myPlayers = new HashMap<Integer,List<Location>>();
    }
    
    public void addPlayer(Location loc, int teamIndex) {
        if(myPlayers.containsKey(teamIndex)) {
            myPlayers.get(teamIndex).add(loc);
            myPlayerNumber ++;
        } else {
            List<Location> teamPlayers = new ArrayList<Location>();
            teamPlayers.add(loc);
            myPlayers.put(teamIndex, teamPlayers);
        }
    }
    
    public void addPlayer(int x, int y,int teamIndex) {
        addPlayer(new Location(x,y),teamIndex);
    }
    
    public void removePlayer(Location startLocation, Location endLocation) {
        int startX = (int)startLocation.getX();
        int startY = (int)startLocation.getY();
        
        int endX = (int) endLocation.getX();
        int endY = (int) endLocation.getY();
        removePlayer(startX,startY,endX,endY);      
    }
    
    public void removePlayer(int startX, int startY, int endX, int endY) {
        for(Integer i : myPlayers.keySet()) {
          List<Location> teamPlayers = myPlayers.get(i);
          for(Location loc : teamPlayers) {
               int x= (int)loc.getX();
               int y = (int)loc.getY();
               if( ((x>=startX && x<=endX)||(x<=startX && x>= endX))&&((y>=startY && y<=endY)||(y<=startY && y>= endY))) {
                   myPlayers.remove(i);
               }
          }
        }

    }

    public void clearPlayers() {
        myPlayers.clear();
    }
}
