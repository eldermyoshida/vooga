package vooga.rts.networking.client.clientgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import vooga.rts.networking.NetworkBundle;
import vooga.rts.networking.client.IClientModel;
import vooga.rts.networking.communications.ExpandedLobbyInfo;
import vooga.rts.networking.communications.clientmessages.LeaveLobbyMessage;

public class ClientViewAdapter {
	private ViewContainerPanel myContainerPanel;
    private TableContainerView myServerBrowserView;
    private CreateLobbyView myCreateLobbyView;
    private LobbyView myLobbyView;
    private ServerBrowserTableAdapter myServerBrowserAdapter = new ServerBrowserTableAdapter();
    private List<String> myFactions;
    private IClientModel myClientModel;
    
    public ClientViewAdapter(IClientModel model,
    		String gameName, List<String> factions,List<String> maps,
            List<Integer> maxPlayerArray) {
    	myClientModel = model;
    	myFactions = factions;
        myContainerPanel = new ViewContainerPanel(gameName);
        myServerBrowserView = new TableContainerView(myServerBrowserAdapter);
        myCreateLobbyView = new CreateLobbyView(maps, maxPlayerArray);
    }

    private void switchToServerBrowserView() {
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
    				requestJoinLobby(myServerBrowserAdapter
    						.getIdOfRow(myServerBrowserView
    								.getSelectedRow()));
    			}
    		}
    	});
    }
    
    /**
     * Switches the current View to the LobbyCreatorScreen.
     */
    private void switchToCreateLobbyView () {
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
    				startLobby(myCreateLobbyView.getLobbyInfo());
    			}
    		}
    	});
    }
    
    /**
     * Switches the current view to the Lobby.
     */
    private void switchToLobbyView (ExpandedLobbyInfo lobbyInfo) {
        myLobbyView = new LobbyView(this, myFactions, lobbyInfo.getMaxPlayers());
        updateLobby(lobbyInfo);
        sendUpdatedLobbyInfo();

        myContainerPanel.changeView(myLobbyView, NetworkBundle.getString("LobbyCreation"));
        myContainerPanel.changeLeftButton(NetworkBundle.getString("LeaveLobby"),
                                          new ActionListener() {
                                              @Override
                                              public void actionPerformed (ActionEvent arg0) {
                                                  myLobbyInfo.removePlayer(myUserControlledPlayers
                                                          .get(0));
                                                  myClient.sendData(new LeaveLobbyMessage(
                                                                                          myLobbyInfo));
                                                  switchToServerBrowserView();
                                              }
                                          });
        myContainerPanel.changeRightButton(NetworkBundle.getString("StartLobby"),
                                           new ActionListener() {
                                               @Override
                                               public void actionPerformed (ActionEvent arg0) {
                                                   if (myLobbyInfo.canStartGame()) {
                                                       requestStartGame();
                                                   }
                                               }
                                           });
    }
}
