package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * View for the server browser.
 * @author David Winegar
 *
 */
public class ServerBrowserView extends JComponent {

    JTable myTable;
    
    public ServerBrowserView (ServerBrowserTableAdapter adapter, String gameName) {
        myTable = new JTable(adapter);
        myTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        myTable.setFillsViewportHeight(true);
        JScrollPane pane = new JScrollPane();
        pane.add(myTable);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(pane, BorderLayout.CENTER);
        add(createTopPanel(gameName), BorderLayout.NORTH);
        
        setOpaque(true);
        setVisible(true);
    }
    
    private JPanel createTopPanel (String gameName) {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        
        JPanel innerPanel = new JPanel();
        FlowLayout innerLayout = new FlowLayout();
        innerPanel.setLayout(innerLayout);
        innerPanel.add(new JLabel(gameName));
        
        panel.add(innerPanel, BorderLayout.CENTER);
        
        JButton hostGame = new JButton("Host Game");
        panel.add(hostGame, BorderLayout.WEST);
        
        return panel;
    }
    
}
