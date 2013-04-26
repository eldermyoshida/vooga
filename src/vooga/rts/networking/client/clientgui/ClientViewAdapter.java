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


public class ClientViewAdapter {
    private ViewContainerPanel myContainerPanel;
    private TableContainerView myServerBrowserView;
    private CreateLobbyView myCreateLobbyView;
    private LobbyView myLobbyView;
    private ServerBrowserTableAdapter myServerBrowserAdapter = new ServerBrowserTableAdapter();
    private List<String> myFactions;
    private ClientModel myModel;
    private ExpandedLobbyInfo myLobbyInfo;

    public ClientViewAdapter (IModel model,
                              String gameName, List<String> factions, List<String> maps,
                              List<Integer> maxPlayerArray) {
        myModel = (ClientModel) model;
        myLobbyInfo = myModel.getLobbyInfo();
        myFactions = factions;
        myContainerPanel = new ViewContainerPanel(gameName);
        myServerBrowserView = new TableContainerView(myServerBrowserAdapter);
        myCreateLobbyView = new CreateLobbyView(maps, maxPlayerArray);
    }

    public void switchToServerBrowserView () {
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
                                                  myModel.switchToServerBrowserView();
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
    public void switchToLobbyView () {
        myLobbyView = new LobbyView(myModel, myFactions, myLobbyInfo.getMaxPlayers());

        myContainerPanel.changeView(myLobbyView, NetworkBundle.getString("LobbyCreation"));
        myContainerPanel.changeLeftButton(NetworkBundle.getString("LeaveLobby"),
                                          new ActionListener() {
                                              @Override
                                              public void actionPerformed (ActionEvent arg0) {
                                                  myLobbyInfo.removePlayer(myModel.getPlayersInfo()
                                                          .get(0));
                                                  myModel.leaveLobby();
                                                  myModel.switchToServerBrowserView();
                                              }
                                          });
        myContainerPanel.changeRightButton(NetworkBundle.getString("StartLobby"),
                                           new ActionListener() {
                                               @Override
                                               public void actionPerformed (ActionEvent arg0) {
                                                   if (myLobbyInfo.canStartGame()) {
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
    
    public void changeLobbies (LobbyInfo[] lobbies) {
        myServerBrowserAdapter.changeLobbies(lobbies);
    }
    
    public void updateLobby () {
        myLobbyView.update(myModel.getPlayersInfo(), myLobbyInfo.getPlayers());
    }
    
    public void alertClient (String title, String message) {
        myContainerPanel.showMessageDialog(title, message);
    }
    
    public List<String> getFactions() {
        return myFactions;
    }
}
