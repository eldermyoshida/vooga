package vooga.rts.networking.client.lobby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import vooga.rts.networking.communications.LobbyInfo;
import vooga.rts.player.RTSPlayer;

public class LobbyView extends JFrame{
    /**
     * 
     */
    private static final long serialVersionUID = 740756183302788979L;
    private Player myPlayer;//TODO: change to id system perhaps
    private LobbyInfo myLobbyInfo;
    
    
    public LobbyView(LobbyInfo info) {
        myLobbyInfo = info;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        String[] factions = {"Toss", "terran" , "zerg"};
        List<RTSPlayer> myPlayers = new ArrayList<RTSPlayer>();
        String[] columnTitles = {"Player","Team" ,"Faction"};
        String currentPlayer = "john";
        
        
        myPlayers.add(new RTSPlayer("john"));
        myPlayers.add(new RTSPlayer("tom"));
        myPlayers.add(null);
        myPlayers.add(new RTSPlayer("bob"));
        myPlayers.add(null);
//        PlayerPane p = (new PlayerPane(factions, myPlayers, columnTitles));
//        p.setVisible(true);
//        p.setEnabled(true);
        TestPlayerFrame p = new TestPlayerFrame();
        this.add(p);
    }
    
    
  
     //* player name --- team number menu ---- faction
 
    
    
    
    
    
    
    
    
    public static void main( String[] args) {
        LobbyView view = new LobbyView(new LobbyInfo("lobbyname", "mapName", 4, 2, 0));
        view.pack();
        view.setVisible(true);
    }
}
