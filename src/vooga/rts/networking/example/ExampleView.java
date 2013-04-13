package vooga.rts.networking.example;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Used for chat example, deprecated.
 * @author David Winegar
 *
 */
public class ExampleView extends JFrame {
    int portdiff = 0;
    JPanel windowPanel;
    JPanel panel;

    public ExampleView () {
        setTitle("Example");
        panel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        windowPanel = new JPanel();
        windowPanel.setPreferredSize(new Dimension(800, 500));
        JButton button = new JButton("New chat window");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                windowPanel.add(createPane());
                setVisible(true);
            }
        });
        panel.add(button);
        panel.add(windowPanel);
        add(panel);
        pack();
        setVisible(true);
    }

    public JPanel createPane () {
        JPanel panel = new JPanel();
        JTextField field = new JTextField();
        JTextArea area = new JTextArea();
        area.setPreferredSize(new Dimension(260, 100));
        field.setPreferredSize(new Dimension(100, 100));
        panel.add(field);
        panel.add(area);
        //ExampleViewConnector connect = new ExampleViewConnector(area, field, portdiff);
        portdiff++;
        //connect.start();
        return panel;
    }

    public static void main (String[] args) {
        ExampleView view = new ExampleView();
    }
}
