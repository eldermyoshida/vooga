package vooga.rts;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import vooga.rts.controller.MainController;
import vooga.rts.resourcemanager.ImageResourceManager;


public class StartGUI {

    public static void main (String[] args) throws IllegalArgumentException, SecurityException,
                                           ClassNotFoundException, InstantiationException,
                                           IllegalAccessException, InvocationTargetException,
                                           NoSuchMethodException, ParserConfigurationException,
                                           SAXException, IOException {
        ImageResourceManager.instance().queueFile("tree.jpg");
        ImageResourceManager.instance().queueFile("got1.jpg");
        ImageResourceManager.instance().queueFile("got2.jpg");
        ImageResourceManager.instance().queueFile("got3.jpg");
        ImageResourceManager.instance().queueFile("got4.jpg");
        ImageResourceManager.instance().queueFile("got5.jpg");

        new MainController();
    }
}
