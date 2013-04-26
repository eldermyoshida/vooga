package vooga.towerdefense;

import java.lang.reflect.InvocationTargetException;
import vooga.towerdefense.controller.Controller;

public class Main {
    
    private Main() {
        // prevent instantiation of this class
    }
    
    public static void main(String[] args) throws IllegalArgumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Controller controller = new Controller("English", "game.xml");
        controller.start();
    }
}
