package vooga.rts.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public abstract class NetworkThread extends Thread{
        private Socket mySocket;
        protected ObjectInputStream mySInput;
        protected ObjectOutputStream mySOutput;
        private int myID;
          
        /**
         * Represents a thread that communicates to a client
         * @param socket socket used for establishing the connection
         */
        NetworkThread(Socket socket){
            mySocket = socket;
            
            try {
                mySInput = new ObjectInputStream(mySocket.getInputStream());
                mySOutput = new ObjectOutputStream(mySocket.getOutputStream());
            }
            catch (IOException e) {
                
            }
        }
        
        /**
         * Closes streams and socket of this thread
         */
        public void close() {
            try {
                    if(mySOutput != null) mySOutput.close();
            }
            catch(Exception e) {}
            try {
                if(mySInput != null) mySInput.close();
            }
            catch(Exception e) {};
            try {
                if(mySocket != null) mySocket.close();
            }
            catch (Exception e) {}
        }
        
        /**
         * Broadcasts a Message object to the client
         * @param m Message object to be sent
         */
        public void sendMessage(Message m){
            if(!mySocket.isConnected()){
                socketDisconnected();
            }
            try {
                mySOutput.writeObject(m);
            }
            catch (IOException e) {
                
            }
        }
        
        /**
         * Handles socket disconnection
         */
        protected abstract void socketDisconnected();
        
}
