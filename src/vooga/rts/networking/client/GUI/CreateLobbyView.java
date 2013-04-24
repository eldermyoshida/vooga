package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vooga.rts.networking.NetworkBundle;
import vooga.rts.networking.communications.LobbyInfo;


/**
 * Represents the View for creating a new lobby.
 */
public class CreateLobbyView extends JPanel {

    private static final long serialVersionUID = -5215687034662203967L;

    private JTextField myServerField;
    private JComboBox myMapComboBox;
    private JComboBox myMaxPlayersComboBox;
    private List<Integer> myMaxPlayerArray;
    private List<String> myMapChoices;

    public CreateLobbyView (List<String> maps, List<Integer> maxPlayerArray) {
        setLayout(new BorderLayout(0, 0));
        myMaxPlayerArray = maxPlayerArray;
        myMapChoices = maps;
        add(createPanel(), BorderLayout.CENTER);
    }

    private JPanel createPanel () {
        JPanel innerPanel = new JPanel();

        innerPanel.add(new JLabel(NetworkBundle.getString("ServerName")));
        myServerField = new JTextField(20);
        innerPanel.add(myServerField);

        innerPanel.add(new JLabel(NetworkBundle.getString("Map")));
        DefaultComboBoxModel mapModel = new DefaultComboBoxModel(myMapChoices.toArray());
        myMapComboBox = new JComboBox(mapModel);
        innerPanel.add(myMapComboBox);
        myMapComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                String choice = (String) myMapComboBox.getSelectedItem();
                Integer maxPlayers = myMaxPlayerArray.get(myMapChoices.indexOf(choice));

                myMaxPlayersComboBox.removeAllItems();
                for (int i = 2; i < maxPlayers; i++) {
                    myMaxPlayersComboBox.insertItemAt(i-2, i);
                }

            }
        });

        innerPanel.add(new JLabel(NetworkBundle.getString("MaxPlayers")));
        myMaxPlayersComboBox = new JComboBox();
        innerPanel.add(myMaxPlayersComboBox);

        return innerPanel;
    }

    public boolean allItemsChosen () {
        return myMaxPlayersComboBox.getSelectedIndex() != -1 &&
               myMapComboBox.getSelectedIndex() != -1 &&
               myServerField.getText() != "";
    }

    public LobbyInfo getLobbyInfo () {
        return new LobbyInfo(myServerField.getText(),
                             (String) myMapComboBox.getSelectedItem(),
                             (Integer) myMaxPlayersComboBox.getSelectedItem(), 0);
    }
}
