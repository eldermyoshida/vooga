package vooga.towerdefense.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


/**
 * This utility creates an XML document.
 * It must handle creation/addition, addition to point of Elements and Contents from
 * Lists, Maps, Trees.
 * It must support images and audio files.
 * It must be able to inform the user about its content.
 * 
 * @author Yoshida
 * 
 */
public class XMLBuilder {

    private Document myDoc;
    private String myURL;

    /**
     * The constructor of this XML file builder automatically creates a buffered
     * document with the destination of the argument path, ready to receive elements.
     * 
     * @param path The destination URL including <filename>.xml
     */
    public XMLBuilder (String path) {
        myURL = path;
        makeDoc();
    }

    // ////////////////////////DOC Operations/////////////////////////////

    /**
     * Creates a new document.
     */
    public void makeDoc () {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            myDoc = dbFactory.newDocumentBuilder().newDocument();
        }
        catch (ParserConfigurationException e) {
            throw new RuntimeException("Could not create a new instance of a Document.", e);
        }
    }

    /**
     * Sets a new document from an XML file.
     * 
     * @param file
     */
    public void setDoc (File file) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            myDoc = dbFactory.newDocumentBuilder().parse(file);
        }
        catch (IOException e) {
            throw new RuntimeException("Could not open file.", e);
        }
        catch (ParserConfigurationException e) {
            throw new RuntimeException("Could not create a new instance of a Document.", e);
        }
        catch (SAXException e) {
            throw new RuntimeException("XML document is corrupted.", e);
        }
    }

    /**
     * Gets the document being written in this XML Builder.
     * 
     * @return A document with an XML format.
     */
    public Document getDoc () {
        return myDoc;
    }

    // //////////////////////ELEMENT OPERATIONS/////////////////////////////
    /*
     * The element operations consist of creating element trees.
     * The use of attributes is avoided because they are difficult to read
     * and to maintain. (Reference: w3schools.com)
     */
    // /////////////////////////////////////////////////////////////////////

    // //Making////

    /**
     * Creates a new empty element in the Doc.
     * 
     * @param tag The tag of the element
     * @param content The content of the element.
     * @return
     */
    public Element makeElement (String tag) {
        Element element = myDoc.createElement(tag);
        return element;
    }

    /**
     * Creates a new element in the Doc with a content.
     * 
     * @param tag The tag of the element
     * @param content The content of the element.
     * @return
     */
    public Element makeElement (String tag, String content) {
        Element element = makeElement(tag);
        element.setTextContent(content);
        return element;
    }

    /**
     * Creates a new elements tree from a Map.
     * 
     * @param tag
     * @param elementsMap
     * @return the parent element
     */
    public Element makeElementsFromMap (String tag, Map<String, String> elementsMap) {
        Element parent = makeElement(tag);
        for (String name : elementsMap.keySet()) {
            String value = elementsMap.get(name);
            addChild(parent, name, value);
        }
        return parent;
    }

    // //Adding////
    /**
     * Adds a element child to an specific parent element
     * 
     * @param parent
     * @param child
     * @return child
     */
    public Element addChild (Element parent, Element child) {
        parent.appendChild(child);
        return child;
    }

    /**
     * Creates a new child element from a tag and adds it to an specific parent element
     * 
     * @param parent
     * @param tag
     * @return the newly created child
     */
    public Element addChild (Element parent, String tag) {
        Element child = makeElement(tag);
        return addChild(parent, child);
    }

    /**
     * Creates a new child element from a tag, adds a value to it and adds it to a parent element
     * 
     * @param parent
     * @param tag
     * @param content
     * @return the newly created child
     */
    public Element addChild (Element parent, String tag, String content) {
        Element child = makeElement(tag, content);
        return addChild(parent, child);
    }

    // //Setting to position////

    // //////////////////////WRITING TO FILE/////////////////////////////

    /**
     * Translates a document into an XML formatted String.
     * 
     * @param doc document with its elements.
     * @return String with XML formatting
     * @throws TransformerException
     */
    public String translateToXMLString (Document doc) throws TransformerException {
        DOMSource source = new DOMSource(doc);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        transformer.transform(source, result);
        String xmlString = sw.toString();
        return xmlString;
    }

    /**
     * This simple method makes it easy for the user to write the XML file.
     * 
     */
    public void writeFile () {
        try {
            writeFile(translateToXMLString(myDoc), myURL);
        }
        catch (TransformerException e) {
            throw new RuntimeException("The document could not be converted into a string", e);
        }
    }

    /**
     * This <code>FileWriter</code> creates the document in an specific location,
     * form an String.
     * 
     * @param XMLString A converted string from an XMLDocument
     * @param path The destination URL with the <filename>.XML
     */
    public void writeFile (String XMLString, String path) {
        FileWriter writer;
        try {
            writer = new FileWriter(path);
            writer.write(XMLString);
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException("File could not be written.", e);
        }
    }
}
