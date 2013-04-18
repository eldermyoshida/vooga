package vooga.rts;

import vooga.rts.state.MainState;
import vooga.rts.gui.Window;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.resourcemanager.exceptions.FileNotSupportedException;


public class StartGUI {
    public static void main (String[] args) {
        try {
            ResourceManager.getInstance().queueFile("tree.jpg");
            ResourceManager.getInstance().queueFile("got1.jpg");
            ResourceManager.getInstance().queueFile("got2.jpg");
            ResourceManager.getInstance().queueFile("got3.jpg");
            ResourceManager.getInstance().queueFile("got4.jpg");
            ResourceManager.getInstance().queueFile("got5.jpg");
        }
        catch (FileNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new MainState();
    }
}
