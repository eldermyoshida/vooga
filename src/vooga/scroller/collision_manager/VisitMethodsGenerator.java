package vooga.scroller.collision_manager;

import games.mario.Mario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Secretary;
import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.util.Sprite;


public class VisitMethodsGenerator {

    private Secretary mySecretary;
    private Set<String> interfaceStrings;
    
    // If I could use reflection to look through the interfaces package and then generate the
    // VisitMethods.java file, that would be BOMB!

    
    
    
    private static final String PART_ONE = "public void visit (";
    private static final String PART_TWO = ") {}";
    private static final String COMMA = ", ";
    
    private List<Sprite> testList = new ArrayList<Sprite>();
    

    public VisitMethodsGenerator (List<Sprite> spriteList) {
        mySecretary = new Secretary();
        interfaceStrings = new HashSet<String>();
        
        testList.add(new MarioLib.Koopa());
        testList.add(new MarioLib.Koopa());
        testList.add(new MarioLib.Koopa());
        testList.add(new MarioLib.Koopa());
        testList.add(new MarioLib.Coin());
        testList.add(new MarioLib.Turtle());
        testList.add(new MarioLib.Platform());
        testList.add(new LevelPortal());
        generateInterfaceStrings(testList);
        generateVisitMethods();
    }
    
    /**
     * We are assuming that spriteList does not contain the player
     * @param spriteList
     */
    private void generateInterfaceStrings(List<Sprite> spriteList) {
        String interfaceString;
        for (Sprite s : spriteList) {
            String tmp = s.getClass().getInterfaces()[0].toString();
            interfaceString = tmp.substring(tmp.lastIndexOf(".") + 1); //general parsing of the getInterface method
            if (!interfaceStrings.contains(interfaceString)) {
                interfaceStrings.add(interfaceString);
            }
        }
        
        System.out.println(interfaceStrings.toString());
    }

    /**
     * This method is a helper I created to generate all the visit methods CollisionManager
     * uses. It can be a real pain typing out all those visit methods. This method merely
     * takes a list of Strings - you need a unique String for each sprite type you have -
     * and it writes all combinations of sprite combinations to calculate all visit method
     * combinations.
     * 
     * The result is stored in a file called visitMethods.txt under the files package of
     * collision_manager.
     * 
     * @param List<Strings> spriteStrings
     * @author Jay Wang
     */
    public void generateVisitMethods () {
        List<String> interfaceList = new ArrayList<String>(interfaceStrings);
        interfaceList.add(0, "IPlayer");
        for (int i = 0; i < interfaceList.size(); i++) {
            for (int j = i + 1; j < interfaceList.size(); j++) {

                mySecretary.write(PART_ONE + interfaceList.get(i) + COMMA + interfaceList.get(j) +
                                  PART_TWO);
            }
        }
    }
}
