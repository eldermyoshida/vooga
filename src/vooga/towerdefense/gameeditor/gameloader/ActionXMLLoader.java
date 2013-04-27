package vooga.towerdefense.gameeditor.gameloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.XMLTool;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.factories.actionfactories.ActionFactory;
import vooga.towerdefense.gameElements.GameElement;


public class ActionXMLLoader {
    private static final String ACTIONS_TAG = "actions";
    private static final String PARAMETER_TAG = "parameter";

    private XMLTool myXMLTool;

    /**
     * 
     * 
     * @param xmlTool an xmlTool
     */
    public ActionXMLLoader (XMLTool xmlTool) {
        myXMLTool = xmlTool;
    }

    /**
     * This method loads all the actions described in XML that
     * do not act upon a GameElement object.
     * 
     * @return loads a list of actions
     */
    public List<Action> loadActions (Element actionsElement) {
        return loadActions(null, actionsElement);
    }

    /**
     * This method loads all the actions described in XML that
     * act upon a GameElement object e.
     * 
     * @param e the game element object that an action acts on
     * @return a list of actions acting on e
     */
    public List<Action> loadActions (GameElement e, Element actionsElement) {
        List<ActionFactory> actionFactories = loadActionFactories(actionsElement);

        List<Action> actions = new ArrayList<Action>();
        for (ActionFactory af : actionFactories) {
            actions.add(af.createAction(e));
        }

        return actions;
    }

    /**
     * 
     * @return a list of action factories
     */
    public List<ActionFactory> loadActionFactories (Element actionsElement) {
        Map<String, Element> subElements = myXMLTool.getChildrenElementMap(actionsElement);

        List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
        for (Element e : subElements.values()) {
            actionFactories.add(loadActionFactory(e));
        }
        return actionFactories;
    }

    private ActionFactory loadActionFactory (Element actionElement) {
        String actionName = myXMLTool.getTagName(actionElement);
        
        List<String> parameterStrings = new ArrayList<String>();
        List<ActionFactory> subActions = new ArrayList<ActionFactory>();

        Map<String, Element> subElements = myXMLTool.getChildrenElementMap(actionElement);

        for (String subElementName : subElements.keySet()) {
            if (subElementName.equals(ACTIONS_TAG)) {
                subActions.add(loadActionFactory(subElements.get(subElementName)));
            }
            else {                
                parameterStrings.add(loadParameterString(subElements.get(subElementName)));
            }
        }
        String[] parameterStringsArray = parameterStrings.toArray(new String[] {});
        
        Class actionFactoryClass = null;
        ActionFactory af = null;
        try {
            String thing = "";
            if (actionName.contains("Wave")) {
                thing = "vooga.towerdefense.factories.waveactionfactories.";
            } else {
                thing = "vooga.towerdefense.factories.actionfactories.";
            }
            String classPath = thing + actionName + "Factory";
            actionFactoryClass = Class.forName(classPath);

            Constructor[] constructors = actionFactoryClass.getDeclaredConstructors();            
            Constructor constructor = constructors[0];
            af = (ActionFactory) constructor.newInstance(parameterStringsArray);
        }
        catch (InstantiationException e) {
            System.out.println("InstantiationException");
            return null;
        }
        catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
            return null;
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
            return null;
        }
        catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException");
            return null;
        }
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            return null;
        }
        af.addFollowUpActionsFactories(subActions);
        return af;
    }

    private String loadParameterString (Element parameterElement) {
        return myXMLTool.getContent(parameterElement);
    }
}
