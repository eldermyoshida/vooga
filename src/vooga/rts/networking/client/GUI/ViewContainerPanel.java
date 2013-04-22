package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * A panel that contains the other views and provides a common framework for changing views.
 * 
 * @author David Winegar
 * 
 */
public class ViewContainerPanel extends JPanel {

    BorderLayout myLayout = new BorderLayout(0, 0);
    JButton myLeftButton;
    JButton myRightButton;

    public ViewContainerPanel (String name) {
        setLayout(myLayout);

    }

    public void changeView (JPanel panel,
                            String leftButtonName,
                            ActionListener leftButtonListener,
                            String rightButtonName,
                            ActionListener rightButtonListener,
                            String titleText) {
        panel.remove(myLayout.getLayoutComponent(BorderLayout.CENTER));
        add(panel, BorderLayout.CENTER);
    }

    private void createTopPanel () {
        JPanel topPanel = new JPanel();
        JLabel label = new JLabel();
    }

}
