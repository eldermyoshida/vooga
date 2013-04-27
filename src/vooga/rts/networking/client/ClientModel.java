package vooga.rts.networking.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JPanel;
import vooga.rts.networking.NetworkBundle;
import vooga.rts.networking.client.clientgui.ClientViewAdapter;
import vooga.rts.networking.client.clientgui.CreateLobbyView;
import vooga.rts.networking.client.clientgui.IModel;
import vooga.rts.networking.client.clientgui.LobbyView;
import vooga.rts.networking.client.clientgui.ServerBrowserTableAdapter;
import vooga.rts.networking.client.clientgui.TableContainerView;
import vooga.rts.networking.client.clientgui.ViewContainerPanel;
import vooga.rts.networking.communications.ExpandedLobbyInfo;
import vooga.rts.networking.communications.LobbyInfo;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.PlayerInfo;
import vooga.rts.networking.communications.clientmessages.InitialConnectionMessage;
import vooga.rts.networking.communications.clientmessages.JoinLobbyMessage;
import vooga.rts.networking.communications.clientmessages.LeaveLobbyMessage;
import vooga.rts.networking.communications.clientmessages.ReadyToStartGameMessage;
import vooga.rts.networking.communications.clientmessages.RequestServerListMessage;
import vooga.rts.networking.communications.clientmessages.RequestStartGameMessage;
import vooga.rts.networking.communications.clientmessages.StartLobbyMessage;
import vooga.rts.networking.communications.clientmessages.UpdateLobbyInfoMessage;
import vooga.rts.networking.communications.servermessages.ServerInfoMessage;


/**
 * Model for the overall server browser on the client.
 * 
 * @author David Winegar
 * @author Sean Wareham
 * @author Henrique Morales
 * 
 */
public class ClientModel extends Observable implements IClientModel, IModel {

    private IClient myClient;
    private String myUserName;
    // private ViewContainerPanel myContainerPanel;
    // private TableContainerView myServerBrowserView;
    // private CreateLobbyView myCreateLobbyView;
    private ExpandedLobbyInfo myLobbyInfo;
    // private LobbyView myLobbyView;
    // private List<String> myFactions;
    private List<PlayerInfo> myUserControlledPlayers = new ArrayList<PlayerInfo>();
    private PlayerInfo myPlayer;
    // private ServerBrowserTableAdapter myServerBrowserAdapter = new ServerBrowserTableAdapter();
    private NetworkedGame myGame;
    private ClientViewAdapter myViewAdapter;

    /**
     * This is the handler of information needed by all of the views in the process of connecting to
     * / creating a server, creating a game, waiting in a lobby.
     * 
     * @param gameName
     * @param userName
     * @param factions
     * @param maps
     * @param maxPlayerArray
     */
    public ClientModel (NetworkedGame game,
                        String gameName,
                        String userName,
                        List<String> factions,
                        List<String> maps,
                        List<Integer> maxPlayerArray) {
        myGame = game;
        myUserName = userName;
        
        // myFactions = factions;
        // myContainerPanel = new ViewContainerPanel(gameName);
        // myServerBrowserView = new TableContainerView(myServerBrowserAdapter);
        // myCreateLobbyView = new CreateLobbyView(maps, maxPlayerArray);
        myClient = new Client(this);
        Message initialConnection = new InitialConnectionMessage(gameName, userName);
        myClient.sendData(initialConnection);
        myViewAdapter = new ClientViewAdapter(this, gameName, factions, maps, maxPlayerArray);
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

//    /**
//     * Switches the current View to the ServerBrowser.
//     */
//    private void switchToServerBrowserView () {
//        requestLobbies();
//        myViewAdapter.switchToServerBrowserView();
//         myContainerPanel.changeView(myServerBrowserView,
//         NetworkBundle.getString("ServerBrowser"));
//         myContainerPanel.changeLeftButton(NetworkBundle.getString("HostGame"),
//         new ActionListener() {
//         @Override
//         public void actionPerformed (ActionEvent arg0) {
//         switchToCreateLobbyView();
//         }
//         });
//         myContainerPanel.changeRightButton(NetworkBundle.getString("JoinGame"),
//         new ActionListener() {
//         @Override
//         public void actionPerformed (ActionEvent arg0) {
//         if (myServerBrowserView.hasSelectedRow()) {
//         requestJoinLobby(myServerBrowserAdapter
//         .getIdOfRow(myServerBrowserView
//         .getSelectedRow()));
//         }
//         }
//         });
//    }

//    /**
//     * Switches the current View to the LobbyCreatorScreen.
//     */
//    private void switchToCreateLobbyView () {
//        myViewAdapter.switchToCreateLobbyView();
//         myContainerPanel.changeView(myCreateLobbyView, NetworkBundle.getString("LobbyCreation"));
//         myContainerPanel.changeLeftButton(NetworkBundle.getString("BackToBrowser"),
//         new ActionListener() {
//         @Override
//         public void actionPerformed (ActionEvent arg0) {
//         switchToServerBrowserView();
//         }
//         });
//         myContainerPanel.changeRightButton(NetworkBundle.getString("StartLobby"),
//         new ActionListener() {
//         @Override
//         public void actionPerformed (ActionEvent arg0) {
//         if (myCreateLobbyView.allItemsChosen()) {
//         startLobby(myCreateLobbyView.getLobbyInfo());
//         }
//         }
//         });
//    }

//    /**
//     * Switches the current view to the Lobby.
//     */
//    private void switchToLobbyView (ExpandedLobbyInfo lobbyInfo) {
//        updateLobby(lobbyInfo);
//        sendUpdatedLobbyInfo();
//        myViewAdapter.switchToLobbyView();
//         myLobbyView = new LobbyView(this, myFactions, lobbyInfo.getMaxPlayers());
//         updateLobby(lobbyInfo);
//         sendUpdatedLobbyInfo();
//        
//         myContainerPanel.changeView(myLobbyView, NetworkBundle.getString("LobbyCreation"));
//         myContainerPanel.changeLeftButton(NetworkBundle.getString("LeaveLobby"),
//         new ActionListener() {
//         @Override
//         public void actionPerformed (ActionEvent arg0) {
//         myLobbyInfo.removePlayer(myUserControlledPlayers
//         .get(0));
//         myClient.sendData(new LeaveLobbyMessage(
//         myLobbyInfo));
//         switchToServerBrowserView();
//         }
//         });
//         myContainerPanel.changeRightButton(NetworkBundle.getString("StartLobby"),
//         new ActionListener() {
//         @Override
//         public void actionPerformed (ActionEvent arg0) {
//         if (myLobbyInfo.canStartGame()) {
//         requestStartGame();
//         }
//         }
//         });
//    }

    /**
     * Request currently available lobbies from the server
     */
    public void requestLobbies () {
        myClient.sendData(new RequestServerListMessage());
    }

    /**
     * Request to join a lobby on the server
     * 
     * @param id ID of the lobby to join
     */
    public void requestJoinLobby (int id) {
        myClient.sendData(new JoinLobbyMessage(id));
    }
    
    /**
     * Request to leave a lobby on the server
     */
    public void leaveLobby () {
        myClient.sendData(new LeaveLobbyMessage(myLobbyInfo));
    }

    /**
     * Starts a new lobby for purposes of hosting a game
     * 
     * @param lobbyInfo Lobby containing information to host a game
     */
    public void startLobby (LobbyInfo lobbyInfo) {
        myClient.sendData(new StartLobbyMessage(lobbyInfo));
    }

    /**
     * Request to initiate the game in this lobby
     */
    public void requestStartGame () {
        myClient.sendData(new RequestStartGameMessage());
    }

    /**
     * Sends an infoLobby so other users can view that the state of
     * the lobby has changed
     */
    public void sendUpdatedLobbyInfo () {
        myClient.sendData(new UpdateLobbyInfoMessage(myLobbyInfo));
    }

    /**
     * 
     * @return the view used by all networking functions
     */
    public JPanel getView () {
        return myViewAdapter.getView();
    }

    @Override
    public void addLobbies (LobbyInfo[] lobbies) {
        myViewAdapter.changeLobbies(lobbies);
    }

    @Override
    public void updateFaction (String faction, int position) {
        myLobbyInfo.getPlayerAtPosition(position).setFaction(faction);
        sendUpdatedLobbyInfo();
    }

    @Override
    public void updateTeam (int team, int position) {
        myLobbyInfo.getPlayerAtPosition(position).setTeam(team);
        sendUpdatedLobbyInfo();
    }

    @Override
    public void switchToLobby (ExpandedLobbyInfo lobbyInfo, int playerID) {
        myPlayer = new PlayerInfo(myUserName, 1, myViewAdapter.getFactions().get(0), playerID);
        myUserControlledPlayers.clear();
        myUserControlledPlayers.add(myPlayer);
        lobbyInfo.addPlayer(myPlayer);
        myViewAdapter.switchToLobbyView(lobbyInfo);
    }

    @Override
    public void updateLobby (ExpandedLobbyInfo lobbyInfo) {
        myLobbyInfo = lobbyInfo;
        myViewAdapter.updateLobby();
    }

    @Override
    public void alertClient (String title, String message) {
        myViewAdapter.alertClient(title, message);
    }

    @Override
    public void loadGame (ExpandedLobbyInfo lobbyInfo) {
        myGame.loadGame(lobbyInfo, myPlayer);
        myClient.sendData(new ReadyToStartGameMessage());
    }

    @Override
    public void startGame () {
        myGame.startGame(myClient);
    }
    
    public ExpandedLobbyInfo getLobbyInfo() {
        return myLobbyInfo;
    }
    
    public List<PlayerInfo> getPlayersInfo() {
        return myUserControlledPlayers;
    }
}
