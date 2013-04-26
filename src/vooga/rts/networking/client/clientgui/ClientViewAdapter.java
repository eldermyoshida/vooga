package vooga.rts.networking.client.clientgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import vooga.rts.networking.NetworkBundle;

public class ClientViewAdapter {
	private ViewContainerPanel myContainerPanel;
    private TableContainerView myServerBrowserView;
    private CreateLobbyView myCreateLobbyView;
    private LobbyView myLobbyView;
    private ServerBrowserTableAdapter myServerBrowserAdapter = new ServerBrowserTableAdapter();
    private List<String> myFactions;
    
    public ClientViewAdapter(String gameName, List<String> factions,List<String> maps,
            List<Integer> maxPlayerArray) {
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
}
