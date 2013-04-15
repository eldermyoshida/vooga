package vooga.rts.networking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExampleViewConnector extends Thread {

    JTextArea outputArea;
    JTextField inputArea;
    private static final int PORT = 2233;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    
    public ExampleViewConnector (JTextArea output, JTextField input, int portDiff) {
        outputArea = output;
        inputArea = input;
        try {
            Socket sock = new Socket("localhost", PORT + portDiff);
            out = new ObjectOutputStream(sock.getOutputStream());
            in = new ObjectInputStream(sock.getInputStream());
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        inputArea.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent arg0) {
                String message = inputArea.getText();
                ChatMessage chat = new ChatMessage(0, message);
                try {
                    out.writeObject(chat);
                }
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                inputArea.setText("");
            }
            
        });
    }
    
    public void run () {
        while(true) {
            Object obj;
            try {
                if((obj = in.readObject()) != null && obj instanceof ChatMessage) {
                    ChatMessage message = (ChatMessage) obj;
                    outputArea.append(message.getMessage() + "\n");
                }
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
