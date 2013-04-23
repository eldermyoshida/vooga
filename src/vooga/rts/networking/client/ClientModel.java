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
import vooga.rts.networking.communications.clientmessages.JoinLobbyMessage;
import vooga.rts.networking.communications.clientmessages.RequestServerListMessage;
import vooga.rts.networking.communications.clientmessages.StartGameMessage;
import vooga.rts.networking.communications.clientmessages.StartLobbyMessage;
import vooga.rts.networking.communications.servermessages.ServerInfoMessage;


/**
 * Model for the overall server browser on the client.
 * 
 * @author David Winegar
 * 
 */
public class ClientModel implements IMessageReceiver, IClientModel, IModel {

    private IClient myClient;
    private ViewContainerPanel myContainerPanel;
    private ServerBrowserView myServerBrowserView;
    private CreateLobbyView myCreateLobbyView;
    private ExpandedLobbyInfo myLobbyInfo;
    private LobbyView myLobbyView;
    private String[] myFactions;

    /**
     * This is the handler of information needed by all of the views in the process of connecting to
     * / creating a server, creating a game, waiting in a lobby.
     * 
     * @param gameName
     * @param userName
     * @param maps
     * @param maxPlayerArray
     */
    public ClientModel (String gameName,
                        String userName,
                        String[] factions,
                        String[] maps,
                        Integer[][] maxPlayerArray) {
        myFactions = factions;
        myContainerPanel = new ViewContainerPanel(gameName);
        myServerBrowserView = new ServerBrowserView(new ServerBrowserTableAdapter());
        myCreateLobbyView = new CreateLobbyView(maps, maxPlayerArray);
        myClient = new Client(this);
        myClient.beginAcceptingConnections();
        Message initialConnection = new InitialConnectionMessage(gameName, userName);
        myClient.sendData(initialConnection);
        switchToServerBrowserView();
    }

    private JPanel getPanel () {
        return myContainerPanel;
    }
    
    /**
     * testing
     */
    public static void main (String[] args) {
        ClientModel model =
                new ClientModel("Test Game", "User 1", new String[] { "protoss", "zerg" },
                                new String[] { "map1", "map2" },
                                new Integer[][] { { 2, 3, 4 }, { 2, 3, 4, 5, 6 } });

        JFrame frame = new JFrame();
        frame.add(model.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void getMessage (Message message) {
        if (message instanceof ServerInfoMessage) {
            ((ServerInfoMessage) message).affectClient(this);
        }
    }

    @Override
    public void closeConnection () {
        myClient.closeConnection();
    }

    /**
     * Switches the current View to the ServerBrowser.
     */
    private void switchToServerBrowserView () {
        requestLobbies();
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
                requestJoinLobby(myServerBrowserView.getSelectedID());
            }
        });
    }

    /**
     * Switches the current View to the LobbyCreatorScreen.
     */
    private void switchToCreateLobbyView () {
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
                startLobby(myCreateLobbyView.getLobbyInfo());
            }
        });
    }

    /**
     * Switches the current view to the Lobby.
     */
    private void switchToLobbyView (ExpandedLobbyInfo lobbyInfo) {
        // TODO resources
        myLobbyInfo = lobbyInfo;
        myLobbyView = new LobbyView(this, myFactions, myLobbyInfo.getMaxPlayers());
        myContainerPanel.changeView(myLobbyView, " Lobby Creation");
        myContainerPanel.changeLeftButton("Leave Lobby", new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {

                switchToServerBrowserView();
            }
        });
        myContainerPanel.changeRightButton("Start Lobby", new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                startGame();
            }
        });
    }

    private void requestLobbies () {
        myClient.sendData(new RequestServerListMessage());
    }

    private void requestJoinLobby (int id) {
        myClient.sendData(new JoinLobbyMessage(id));
    }

    private void startLobby (LobbyInfo lobbyInfo) {
        myClient.sendData(new StartLobbyMessage(lobbyInfo));
    }

    private void startGame () {
        myClient.sendData(new StartGameMessage());
    }

    @Override
    public void addLobbies (LobbyInfo[] lobbies) {
        myServerBrowserView.addLobbies(lobbies);
    }

    @Override
    public void updateFaction (String faction, int position) {
        myLobbyInfo.getPlayerAtPosition(position).setFaction(faction);
    }

    @Override
    public void updateTeam (int team, int position) {
        myLobbyInfo.getPlayerAtPosition(position).setTeam(team);
    }

    @Override
    public void switchToLobby (ExpandedLobbyInfo lobbyInfo) {
        switchToLobbyView(lobbyInfo);
    }

    @Override
    public void updateLobby (ExpandedLobbyInfo lobbyInfo) {
        myLobbyInfo = lobbyInfo;
    }
}
