package util.XMLToolExample;


import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;


/**
 * This is example code shows how to use the XMLtool.
 * 
 * @author Yoshida
 * 
 */
public class XMLToolExample {
    private static final String SAVING_LOCATION = "/src/util/XMLToolExample/";
    private static final String FILENAME = "XMLTest.xml";

    private static XMLTool myDoc;
    private static XMLTool myReadDoc;
    
    /**
     * Loads the XMLTool tester methods.
     * 
     * @param args
     */
    public static void main (String args[]) {
        // makes the file;
        makeXMLFile();
        // Writes the document
        myDoc.writeFile(SAVING_LOCATION+FILENAME);
        // Reads the file
        readFile();
    }
    
    private static void makeXMLFile () {
        // Step 1: Create a new XML document
        myDoc = new XMLTool();
        
        // Step 2: Creates a new root with the desired tag. Import org.w3c.dom.Element
        Element earth = myDoc.makeRoot("Earth");
        
        /*
         * Step 3: Make Elements. The XML file can be viewed as a tree data structure. Those
         * elements are the nodes of the XML tree. There are three basic ways to create an Element.
         */
        
        /*
         * Creating a new node without a value. Later on any node must be appended to the tree with
         * the root. Otherwise, the element will not show up in the XML file.
         */
        Element PrimateElement = myDoc.makeElement("Primates");
        
        /*
         * Creating a new node with a value. However if the element is not a leaf, the value
         * will be lost it the file. In this case, "Homo sapiens" will be lost in the document.
         * Create an new element, such as "species" with a value "Homo sapiens"
         */
        Element humanElement = myDoc.makeElement("Human", "Homo sapiens");
        
        // Creating a HashMap with some stuff in it.
        Map<String, String> duvallMap = new HashMap<String, String>();
        duvallMap.put("fingers", "10");
        duvallMap.put("eyes", "2");
        duvallMap.put("language", "Java");
        duvallMap.put("occupation", "writing good code");
        
        /*
         * Creating an element from a Map. This method is particularly useful when working with
         * a high amount of information to be recorded in the XML file.
         */
        Element duvallElement = myDoc.makeElementsFromMap("Robert", duvallMap);
        
        // Add/append Elements
        myDoc.addChild(earth, humanElement);
        myDoc.addChild(humanElement, duvallElement);
        
    }
    
    private static void readFile () {
        myReadDoc = new XMLTool(SAVING_LOCATION+FILENAME);
        
        // getting one unique element form the XML file.
        Element bobElement = myReadDoc.getElement("Robert");
        Element languageElement = myReadDoc.getElement("language");
        // getting the value from an element.
        System.out.println("The content of the element " + languageElement.getTagName() + " is: " +
                           languageElement.getTextContent());
        // It is also possible to get the content of an element using the XMLTool.
        // Note that the XMLTool has a slightly different implementation.
        System.out.println("The content of the element " + "language" + " is: " +
                           myReadDoc.getContent("language"));
        // The XMLTool also lets you get a Map that was initially added to the file.
        Map<String, String> bobMap = new HashMap<String, String>();
        bobMap = myReadDoc.getChildrenStringMap(bobElement);
        System.out.println(bobMap.toString());
        
    }
}
