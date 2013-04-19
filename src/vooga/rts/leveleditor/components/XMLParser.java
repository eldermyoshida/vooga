package vooga.rts.leveleditor.components;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import vooga.rts.leveleditor.Exceptions.MapNotMatchException;

public class XMLParser {
   
    private Pattern myContentPattern ;
    private Pattern myTitlePattern ;
    private Pattern mySpacePattern ;
    private Pattern myEqualPattern ;
    
    public XMLParser() {
        myContentPattern = Pattern.compile("[<(/>)]");
        myTitlePattern = Pattern.compile("[<>]");
        mySpacePattern = Pattern.compile("[\\s]+");
        myEqualPattern = Pattern.compile("[=]");
    }
    
    public String splitContent(String str) throws MapNotMatchException {
        String[] buffer = cutBlanks(myContentPattern.split(str));
        if(buffer.length == 1) {
            return buffer[0];
        } else {
            throw new MapNotMatchException("map file not match");
        }
    }
    
    public String splitIndex(String str) throws MapNotMatchException {
        String[] buffer = cutBlanks(myTitlePattern.split(str));
        if(buffer.length == 1) {
            return buffer[0];
        } else {
            throw new MapNotMatchException("map file not match");
        }
    }
    
    
    
    public String[] cutBlanks(String[] buffer) {
        int size = buffer.length;
        int count = 0;
        for(int i =0 ; i<size ; i++) {
            if (buffer[i].length() == 0 || mySpacePattern.matcher(buffer[i]).matches()) {
                count ++;
            }
        }
        String[] result = new String[size-count];
        int index = 0;
        for(int i =0 ; i<size ; i++) {
            if (buffer[i].length() != 0 && !mySpacePattern.matcher(buffer[i]).matches()) {
                result[index] = buffer[i]; 
                index ++;
            }
        }
        return result;
    }
    
    public String getTitle(String str) {
        int index = str.indexOf(">")+1;
        String buffer = str.substring(index);
        index = buffer.indexOf("<");
        return buffer.substring(0,index);
    }
    
    public String[] splitByBlanks(String str) {
        return cutBlanks(mySpacePattern.split(str));
    }
    
    public String[] cutKeyAndValue(String str) {
        return cutBlanks(myEqualPattern.split(str));
    }
    
    public Pattern getMyContentPattern () {
        return myContentPattern;
    }



    public Pattern getMyTitlePattern () {
        return myTitlePattern;
    }



    public Pattern getMySpacePattern () {
        return mySpacePattern;
    }

    public Pattern getMyEqualPattern() {
        return myEqualPattern;
    }
}
