package vooga.rts.networking.examplechat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vooga.rts.networking.client.ClientModel;
import vooga.rts.networking.client.IClient;
import vooga.rts.networking.client.NetworkedGame;
import vooga.rts.networking.communications.ExpandedLobbyInfo;
import vooga.rts.networking.communications.PlayerInfo;

public class ExampleChat implements NetworkedGame {

    private ClientModel myModel;
    private JDialog myDialog;
    private JTextField myField;
    private JFrame myFrame;
    
    /**
     * Main for example chat program.
     * @param args
     */
    public static void main (String[] args) {
        new ExampleChat();
    }
    
    public ExampleChat() {
        myDialog = new JDialog();
        myDialog.setLayout(new BorderLayout());
        myDialog.setVisible(true);
        myField = new JTextField(20);
        myDialog.add(new JLabel("Enter Name: "), BorderLayout.NORTH);
        myField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                myDialog.dispose();
                createView(myField.getText());
                createFrame();
            }
        });
        myDialog.add(myField, BorderLayout.CENTER);
        myDialog.setPreferredSize(new Dimension(100, 100));
        myDialog.pack();
    }
    
    private void createFrame () {
        myFrame = new JFrame();
        //myFrame.add(myModel.getView());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(600, 500));
        myFrame.setVisible(true);
        myFrame.pack();
    }
    
    private void createView (String name) {
        List<String> factions = new ArrayList<String>();
        factions.add("chat person");
        List<String> maps = new ArrayList<String>();
        maps.add("chat room");
        List<Integer> maxPlayers = new ArrayList<Integer>();
        maxPlayers.add(8);
        //ClientModel model =
         //       new ClientModel(this, "Chat Room", name, factions, maps, maxPlayers);
    }

    @Override
    public void loadGame (ExpandedLobbyInfo info, PlayerInfo thisPlayer) {
        myFrame.removeAll();
        
    }

    @Override
    public void startGame (IClient client) {
        // TODO Auto-generated method stub
        
    }

}
