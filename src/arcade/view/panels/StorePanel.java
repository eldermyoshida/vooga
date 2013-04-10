package arcade.view.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StorePanel extends JPanel {
    public StorePanel(){
        setLayout(null);
        
        JLabel title = new JLabel("Store");
        title.setBounds(5,5,40,40);
        add(title);
}
}
