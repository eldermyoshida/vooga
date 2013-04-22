package vooga.scroller.collision_manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Secretary;
import vooga.scroller.util.Sprite;


public class VisitMethodsGenerator {

    private Secretary mySecretary;
    private Set<String> interfaceStrings;
        
    private static final String PART_ONE = "public void visit (";
    private static final String PART_TWO = ") {}";
    private static final String COMMA = ", ";
    private static final String DIRECTORY_LOCATION = "src/vooga/scroller/collision_manager/files/";
    private static final String FILE_NAME = "visitMethods.txt";
        

    public VisitMethodsGenerator (List<Sprite> spriteList) throws IOException {
        mySecretary = new Secretary(DIRECTORY_LOCATION, FILE_NAME);
        interfaceStrings = new HashSet<String>();
        generateInterfaceStrings(spriteList);
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
     * @throws IOException 
     */
    public void generateVisitMethods () throws IOException {
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
