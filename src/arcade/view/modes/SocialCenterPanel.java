package arcade.view.modes;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SocialCenterPanel extends JPanel {
    public SocialCenterPanel () {
        setBackground(Color.WHITE);
        JLabel title = new JLabel("Social Center");
        add(title);
    }
}
