package vooga.rts.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExampleViewConnector {

    JTextArea outputArea;
    JTextField inputArea;
    private static final int PORT = 2233;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    
    public ExampleViewConnector (JTextArea output, JTextField input) {
        outputArea = output;
        inputArea = input;
        try {
            Socket sock = new Socket("localhost", PORT);
            out = new ObjectOutputStream(sock.getOutputStream());
            in = new ObjectInputStream(sock.getInputStream());
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
