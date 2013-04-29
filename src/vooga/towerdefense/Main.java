package vooga.towerdefense;

import java.lang.reflect.InvocationTargetException;

import vooga.towerdefense.controller.Controller;

public class Main {
    
    private Main() {
        // prevent instantiation of this class
    }
    
    public static void main(String[] args) throws IllegalArgumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
<<<<<<< HEAD
        new Controller("English", "/src/vooga/towerdefense/resources/ClownsGame.xml");
=======
        new Controller("English", "/src/vooga/towerdefense/resources/PokemonSwarm.xml");
>>>>>>> 27723a754e12161c2bf059aafb17ec8adc496bff
    }
}

