package vooga.rts.networking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExampleView extends JFrame{
    private JTextField myField;
    private JTextArea myDisplay;
    public ExampleView(){
        setTitle("Example");
        JPanel panel = new JPanel();
        myField = new JTextField();
        myDisplay = new JTextArea();
       // setPreferredSize(new Dimension(300,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        myDisplay.setPreferredSize(new Dimension(300,380));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(myField);
        panel.add(myDisplay,BorderLayout.CENTER);
        add(panel);
        pack();
    }
    public JTextField getField(){
        return myField;
    }
    public JTextArea getDisplay(){
        return myDisplay;
    }
}
