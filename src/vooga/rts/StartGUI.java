package vooga.rts;

import vooga.rts.controller.MainController;
import vooga.rts.resourcemanager.ResourceManager;


public class StartGUI {
    public static void main (String[] args) {
        ResourceManager.instance().queueFile("tree.jpg");
        ResourceManager.instance().queueFile("got1.jpg");
        ResourceManager.instance().queueFile("got2.jpg");
        ResourceManager.instance().queueFile("got3.jpg");
        ResourceManager.instance().queueFile("got4.jpg");
        ResourceManager.instance().queueFile("got5.jpg");
        
        new MainController();
    }
}
