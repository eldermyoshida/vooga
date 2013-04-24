package vooga.rts.networking.examplechat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class UsernameDialogBox {

    private JDialog myDialog;
    private JTextField myField;
    private ExampleChat myExampleChat;

    public UsernameDialogBox (ExampleChat chat) {
        myExampleChat = chat;
        myDialog = new JDialog();
        myDialog.setLayout(new BorderLayout());
        myDialog.setVisible(true);
        myField = new JTextField(20);
        myDialog.add(new JLabel("Enter Name: "), BorderLayout.NORTH);
        myField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                myDialog.dispose();
                myExampleChat.createView(myField.getText());
                myExampleChat.createFrame();
            }
        });
        myDialog.add(myField, BorderLayout.CENTER);
        myDialog.setPreferredSize(new Dimension(100, 100));
        myDialog.pack();
    }
}
