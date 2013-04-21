package vooga.rts.networking.client.lobby;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import vooga.rts.networking.communications.LobbyInfo;

public class LobbyView extends JFrame{
    private Player myPlayer;//TODO: change to id system perhaps
    private LobbyInfo myLobbyInfo;
    
    
    public LobbyView(LobbyInfo info) {
        myLobbyInfo = info;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        String[] test = {"hi" , "lo" };
//        this.add(factionSelectionMenu(new RtsPlayer("", ""), test));
//        this.add(playerTable(test,test));
        Player[][] data =
            {
                {new Player("Color"), new Player("Red")},
                {new Player("Shape"), new Player("Square")},
                {new Player("Fruit"), new Player("Banana")}
                
            };
        ArrayList<RTSPlayer> players = new ArrayList<RTSPlayer>();
        players.add(new RTSPlayer("johnny"));
        players.add(new RTSPlayer("sam"));
        players.add(new RTSPlayer("kim"));
        this.add(new PlayerPane(test, players));
    }
    
    
    /**
     * player name --- team number menu ---- faction
     * @param columnTitles
     * @param defaultValues
     * @return
     */
    private JTable playerTable(String[] columnTitles, String[] defaultValues) {
        DefaultTableModel model = new DefaultTableModel();
        for (int i=0;i< columnTitles.length; i++) {
            model.addColumn(columnTitles[i]);
        }
        String[] test = {"hi" , "lo" };
//      this.add(factionSelectionMenu(new RtsPlayer("", ""), test));
        for (int i =0; i< myLobbyInfo.getMaxPlayers(); i++) {
//            model.addRow(factionSel
//            ectionMenu(new RtsPlayer("", ""), test));
        }
        
        
        JTable table = new JTable(model);
//        table.setEnabled(true);  only if its the current player
        return table;
    }
    
    
    
    private JComboBox factionSelectionMenu(final RTSPlayer player, String[] choices) {
        final JComboBox factionMenu = new JComboBox(choices);
        factionMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                updateFaction(player, (String)factionMenu.getSelectedItem());
            }
        });
        return factionMenu;
    }
    
//    public void actionPerformed(ActionEvent e) {
    
    private void updateFaction(RTSPlayer player, String faction) {
        player.setFaction(faction);
    }
    
    
    
    
    
    
    
    
    public static void main( String[] args) {
        LobbyView view = new LobbyView(new LobbyInfo("lobbyname", "mapName", 4, 2, 0));
        view.pack();
        view.setVisible(true);
    }
}
