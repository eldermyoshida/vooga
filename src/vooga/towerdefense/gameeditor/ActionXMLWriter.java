package vooga.towerdefense.gameeditor;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import util.XMLTool;

/**
 * 
 * @author Erick Gonzalez
 */
public class ActionXMLWriter {
    private static final String PARAM_TAG = "parameter";
    
    private int index;
    private XMLTool myXMLTool;
    
    public ActionXMLWriter(XMLTool xmlTool) {
        index = 0;
        myXMLTool = xmlTool;
    }
    
    public Element parse(Element rootElement, String dataString) {
        String[] dataArray = dataString.split("\n");
        
        while (index < dataArray.length) {
            myXMLTool.addChildElement(rootElement, parse(dataArray, 0));
        }        
        return rootElement;
    }
    
    private Element parse(String[] dataArray, int numTabs) {
        String actionString = dataArray[index++];
        String actionName = getActionName(actionString);
        List<String> params = getParams(actionString);
        
        Element currentElement = myXMLTool.makeElement(actionName);
        
        for (String param : params) {
           Element parameterElement = myXMLTool.makeElement(PARAM_TAG, param);
           myXMLTool.addChildElement(currentElement, parameterElement);
        }
        while (index < dataArray.length) {
            String next = dataArray[index];
            if (countTabs(next) > numTabs) {
                Element child = parse(dataArray, numTabs + 1);
                myXMLTool.addChildElement(currentElement, child);
            } else {
                break;
            }
        }
        return currentElement;
    }
    
    private String getActionName(String actionString) {
        String[] actionSplitString = actionString.trim().split("\\s+");
        return actionSplitString[0];
    }
    
    private List<String> getParams(String actionString) {
        String[] actionSplitString = actionString.trim().split("\\s+");
        List<String> params = new ArrayList<String>();
        for (int i = 1; i < actionSplitString.length; ++i) {
            params.add(actionSplitString[i]);
        }
        return params;
    }
 
    private int countTabs(String test) {
        int count = 0;
        for (int i = 0; i < test.length(); ++i) {
            if (test.charAt(i) == '\t') {
                count++;
            }
        }
        return count;
    }    
}
