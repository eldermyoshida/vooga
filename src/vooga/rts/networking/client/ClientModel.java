package vooga.rts.networking.client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import vooga.rts.networking.client.GUI.CreateLobbyView;
import vooga.rts.networking.client.GUI.IModel;
import vooga.rts.networking.client.GUI.LobbyView;
import vooga.rts.networking.client.GUI.ServerBrowserTableAdapter;
import vooga.rts.networking.client.GUI.ServerBrowserView;
import vooga.rts.networking.client.GUI.ViewContainerPanel;
import vooga.rts.networking.communications.ExpandedLobbyInfo;
import vooga.rts.networking.communications.LobbyInfo;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.InitialConnectionMessage;
import vooga.rts.networking.communications.clientmessages.RequestServerListMessage;
import vooga.rts.networking.communications.servermessages.ServerInfoMessage;


/**
 * Model for the overall server browser on the client.
 * 
 * @author David Winegar
 * 
 */
public class ClientModel implements IMessageReceiver, IClientModel, IModel {

    // private IClient myClient = new Client(this);
    private ViewContainerPanel myContainerPanel;
    private ServerBrowserView myServerBrowserView;
    private CreateLobbyView myCreateLobbyView;
    private ServerBrowserTableAdapter myAdapter;
    private ExpandedLobbyInfo myLobbyInfo;
    private LobbyView myLobbyView;

    public ClientModel (String gameName, String userName, String[] maps, Integer[][] maxPlayerArray) {
        // Message initialConnection = new InitialConnectionMessage(gameName, userName);
        // myClient.sendData(initialConnection);
        myContainerPanel = new ViewContainerPanel(gameName);
        myAdapter = new ServerBrowserTableAdapter();
        myServerBrowserView = new ServerBrowserView(myAdapter);
        myCreateLobbyView = new CreateLobbyView(maps, maxPlayerArray);
        switchToServerBrowserView();
    }

    private JPanel getPanel () {
        return myContainerPanel;
    }

    private void requestLobbies () {
        // myClient.sendData(new RequestServerListMessage());
    }

    @Override
    public void getMessage (Message message) {
        if (message instanceof ServerInfoMessage) {
            ((ServerInfoMessage) message).affectClient(this);
        }
    }

    @Override
    public void closeConnection () {
        // myClient.close();
    }

    public void switchToServerBrowserView () {
        // TODO resources
        myContainerPanel.changeView(myServerBrowserView, " Server Browser");
        myContainerPanel.changeLeftButton("Host Game", new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                switchToCreateLobbyView();
            }
        });
        myContainerPanel.changeRightButton("Join Game", new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                switchToLobbyView();
            }
        });
    }

    public void switchToCreateLobbyView () {
        // TODO resources
        myContainerPanel.changeView(myCreateLobbyView, " Lobby Creation");
        myContainerPanel.changeLeftButton("Back to Server Browser", new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                switchToServerBrowserView();
            }
        });
        myContainerPanel.changeRightButton("Start Lobby", new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                switchToLobbyView();
            }
        });
    }

    public void switchToLobbyView () {
        // TODO resources
        myContainerPanel.changeView(myCreateLobbyView, " Lobby Creation");
        myContainerPanel.changeLeftButton("Leave Lobby", new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                switchToServerBrowserView();
            }
        });
        myContainerPanel.changeRightButton("Start Lobby", null);
    }

    /**
     * testing
     */
    public static void main (String[] args) {
        ClientModel model =
                new ClientModel("Test Game", "User 1", new String[] { "map1", "map2" },
                                new Integer[][] { { 2, 3, 4 }, { 2, 3, 4, 5, 6 } });

        JFrame frame = new JFrame();
        frame.add(model.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void addLobbies (LobbyInfo[] lobbies) {
        myAdapter.addLobbies(lobbies);
    }

    @Override
    public void updateFaction (String faction, int position) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTeam (int team, int position) {
        // TODO Auto-generated method stub

    }
}
