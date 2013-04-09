package arcade.view.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SocialCenterPanel extends JPanel {
    public SocialCenterPanel(){
        setLayout(null);
        
        JLabel title = new JLabel("Social Center");
        title.setBounds(5,5,40,40);
        add(title);
}

}
