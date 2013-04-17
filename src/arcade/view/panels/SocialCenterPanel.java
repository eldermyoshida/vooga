package arcade.view.panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SocialCenterPanel extends JPanel {
    public SocialCenterPanel(){
        setLayout(null);

        setBackground(Color.WHITE);
        JLabel title = new JLabel("Social Center");
        title.setBounds(5,5,40,40);
        add(title);
}

}
