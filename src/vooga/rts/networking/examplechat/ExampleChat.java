package vooga.rts.networking.examplechat;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import vooga.rts.networking.client.ClientModel;
import vooga.rts.networking.client.IClient;
import vooga.rts.networking.client.IMessageReceiver;
import vooga.rts.networking.client.NetworkedGame;
import vooga.rts.networking.communications.ExpandedLobbyInfo;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.PlayerInfo;
import vooga.rts.networking.communications.UserTimeStamp;


/**
 * An example client for games that wish to use networking.
 * 
 * @author David Winegar
 * 
 */
public class ExampleChat implements NetworkedGame, IChatModel, IMessageReceiver {

    private ClientModel myModel;
    private JFrame myFrame;
    private ChatPanel myChatPanel;
    private IClient myClient;
    private PlayerInfo myPlayer;
    private ExpandedLobbyInfo myInfo;
    private long myStartTime;

    /**
     * Main for example chat program.
     * 
     * @param args
     */
    public static void main (String[] args) {
        new ExampleChat();
    }

    /**
     * Starts by creating the dialog box.
     */
    public ExampleChat () {
        new UsernameDialogBox(this);
    }

    protected void createFrame () {
        myFrame = new JFrame();
        myFrame.add(myModel.getView());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.setPreferredSize(new Dimension(600, 500));
        myFrame.setVisible(true);
        myFrame.pack();
    }

    protected void createView (String name) {
        List<String> factions = new ArrayList<String>();
        factions.add("chat person");
        List<String> maps = new ArrayList<String>();
        maps.add("chat room");
        List<Integer> maxPlayers = new ArrayList<Integer>();
        maxPlayers.add(8);
        myModel = new ClientModel(this, "Chat Room", name, factions, maps, maxPlayers);
    }

    @Override
    public void loadGame (ExpandedLobbyInfo info, PlayerInfo thisPlayer) {
        myFrame.dispose();
        myFrame = new JFrame();
        myChatPanel = new ChatPanel(this);
        myFrame.add(myChatPanel);
        myPlayer = thisPlayer;
        myInfo = info;

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(600, 500));
        myFrame.setVisible(true);
        myFrame.pack();
    }

    @Override
    public void startGame (IClient client) {
        myClient = client;
        client.setMessageReceiver(this);
        myStartTime = System.nanoTime();
    }

    @Override
    public void getMessage (Message message) {
        if (message instanceof ChatMessage) {
            ChatMessage chat = (ChatMessage) message;
            myChatPanel.appendMessage(
                    chat.getInitialTime() + " : " +
                            myInfo.getPlayer(chat.getSender()).getName() + " : " +
                            chat.getMessage() + "\n");

        }
    }

    @Override
    public void messageEntered (String message) {
        myClient.sendData(new ChatMessage(
                                          new UserTimeStamp(
                                                            (System.nanoTime() - myStartTime) / 1000000),
                                          message, myPlayer.getId()));
    }

}
