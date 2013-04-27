package vooga.rts.networking.client.clientgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import vooga.rts.networking.NetworkBundle;
import vooga.rts.networking.client.ClientModel;
import vooga.rts.networking.client.IClientModel;
import vooga.rts.networking.communications.ExpandedLobbyInfo;
import vooga.rts.networking.communications.LobbyInfo;
import vooga.rts.networking.communications.PlayerInfo;
import vooga.rts.networking.communications.clientmessages.LeaveLobbyMessage;
import vooga.rts.player.Player;

/**
 * Class used as a meddler between the client view and model
 * It manages the necessary operations on the model given the 
 * user input and keeps the display information up to date 
 * in case data comes from the network
 * @author Henrique Moraes
 *
 */
public class ClientViewAdapter {
    private ViewContainerPanel myContainerPanel;
    private TableContainerView myServerBrowserView;
    private CreateLobbyView myCreateLobbyView;
    private LobbyView myLobbyView;
    private ServerBrowserTableAdapter myServerBrowserAdapter = new ServerBrowserTableAdapter();
    private List<String> myFactions;
    private ClientModel myModel;

    /**
     * Constructor for this class.
     * @param model 
     * @param gameName
     * @param factions
     * @param maps
     * @param maxPlayerArray
     */
    public ClientViewAdapter (IModel model,
                              String gameName, List<String> factions, List<String> maps,
                              List<Integer> maxPlayerArray) {
        myModel = (ClientModel) model;
        myFactions = factions;
        myContainerPanel = new ViewContainerPanel(gameName);
        myServerBrowserView = new TableContainerView(myServerBrowserAdapter);
        myCreateLobbyView = new CreateLobbyView(maps, maxPlayerArray);
        switchToServerBrowserView();
    }

    /**
     * Switches the current View to the ServerBrowser.
     */
    public void switchToServerBrowserView () {
        myModel.requestLobbies();
        myContainerPanel.changeView(myServerBrowserView, NetworkBundle.getString("ServerBrowser"));
        myContainerPanel.changeLeftButton(NetworkBundle.getString("HostGame"),
                                          new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                switchToCreateLobbyView();
            }
        });
        myContainerPanel.changeRightButton(NetworkBundle.getString("JoinGame"),
                                           new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                if (myServerBrowserView.hasSelectedRow()) {
                    myModel.requestJoinLobby(myServerBrowserAdapter
                                             .getIdOfRow(myServerBrowserView
                                                         .getSelectedRow()));
                }
            }
        });
    }

    /**
     * Switches the current View to the LobbyCreatorScreen.
     */
    public void switchToCreateLobbyView () {
        myContainerPanel.changeView(myCreateLobbyView, NetworkBundle.getString("LobbyCreation"));
        myContainerPanel.changeLeftButton(NetworkBundle.getString("BackToBrowser"),
                                          new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                switchToServerBrowserView();
            }
        });
        myContainerPanel.changeRightButton(NetworkBundle.getString("StartLobby"),
                                           new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                if (myCreateLobbyView.allItemsChosen()) {
                    myModel.startLobby(myCreateLobbyView.getLobbyInfo());
                }
            }
        });
    }

    /**
     * Switches the current view to the Lobby.
     */
    public void switchToLobbyView (ExpandedLobbyInfo lobbyInfo) {
        myLobbyView = new LobbyView(myModel, myFactions, lobbyInfo.getMaxPlayers());
        myModel.updateLobby(lobbyInfo);
        myModel.sendUpdatedLobbyInfo();

        myContainerPanel.changeView(myLobbyView, NetworkBundle.getString("LobbyCreation"));
        myContainerPanel.changeLeftButton(NetworkBundle.getString("LeaveLobby"),
                                          new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                myModel.getLobbyInfo().removePlayer(myModel.getPlayersInfo()
                                                    .get(0));
                myModel.leaveLobby();
                switchToServerBrowserView();
            }
        });
        myContainerPanel.changeRightButton(NetworkBundle.getString("StartLobby"),
                                           new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                if (myModel.getLobbyInfo().canStartGame()) {
                    myModel.requestStartGame();
                }
            }
        });
    }

    /**
     * 
     * @return the view used by all networking functions
     */
    public JPanel getView () {
        return myContainerPanel;
    }

    /**
     * 
     * @param lobbies array with LobbyInfo that should update
     * the ServerBrowserAdapter
     */
    public void changeLobbies (LobbyInfo[] lobbies) {
        myServerBrowserAdapter.changeLobbies(lobbies);
    }

    /**
     * Updates the information on the LobbyView according to the
     * model's current information
     */
    public void updateLobby () {
        myLobbyView.update(myModel.getPlayersInfo(), 
                           myModel.getLobbyInfo().getPlayers());
    }

    /**
     * Displays a window to the user with a specific message
     * @param title Title of the window
     * @param message String to inform the user
     */
    public void alertClient (String title, String message) {
        myContainerPanel.showMessageDialog(title, message);
    }

    /**
     * 
     * @return A list with name of factions of this client view
     */
    public List<String> getFactions() {
        return myFactions;
    }
}
