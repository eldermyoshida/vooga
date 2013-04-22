package vooga.scroller.VisitMethodsGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import vooga.scroller.util.Sprite;



public class Main {
    
    private static final String DIRECTORY_LOCATION = "src/vooga/scroller/VisitMethodsGenerator/files/";
    private static final String FILE_NAME = "visitMethods.txt";

    /**
     * @param args
     * @throws IOException 
     */
    public static void main (String[] args) throws IOException {
       

        List<Sprite> names = Arrays.asList(); //TODO: FILL IN THE SPRITES YOU ARE USING 
        VisitMethodsGenerator generator = new VisitMethodsGenerator(names, DIRECTORY_LOCATION, FILE_NAME);
        generator.generateVisitMethods();
        
    }
}
