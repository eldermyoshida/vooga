package vooga.rts.networking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ExampleView extends JFrame {
    JPanel windowPanel;

    public ExampleView () {
        setTitle("Example");
        JPanel panel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        BorderLayout layout = new BorderLayout();
        windowPanel = new JPanel();
        JButton button = new JButton("New chat window");
        button.setVisible(true);
        button.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                windowPanel.add(createPane());
            }    
        });
        //layout.addLayoutComponent(button, BorderLayout.NORTH);
        //layout.addLayoutComponent(windowPanel, BorderLayout.SOUTH);
        //panel.setLayout(layout);
        panel.add(button);
        panel.add(windowPanel);
        add(panel);
        pack();

    }
    
    public JPanel createPane() {
        JPanel panel = new JPanel();
        JTextField field = new JTextField();
        JTextArea area = new JTextArea();
        area.setPreferredSize(new Dimension(300, 380));
        panel.add(field);
        panel.add(field);
        new ExampleViewConnector(area, field);
        return panel;
    }

    public static void main (String[] args) {
        ExampleView view = new ExampleView();
    }
}
