package vooga.towerdefense.gameeditor.gameloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.factories.actionfactories.ActionFactory;
import vooga.towerdefense.gameElements.GameElement;


/**
 * This class is responsible for loading all Action objects.
 * 
 * @author Erick Gonzalez
 */
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
        System.out.println(actionFactories);

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
            if (subElementName.equals(PARAMETER_TAG)) {
                parameterStrings.add(loadParameterString(subElements.get(subElementName)));
            }
            else {
                subActions.add(loadActionFactory(subElements.get(subElementName)));
            }
        }
        String[] parameterStringsArray = parameterStrings.toArray(new String[] {});
        
        Class actionFactoryClass = null;
        ActionFactory af = null;
        try {
            String classPath = "vooga.towerdefense.factories.actionfactories." + actionName + "Factory";
            actionFactoryClass = Class.forName(classPath);

            Constructor[] constructors = actionFactoryClass.getDeclaredConstructors();            
            Constructor constructor = constructors[0];
            af = (ActionFactory) constructor.newInstance(parameterStringsArray);
        }
        catch (InstantiationException e) {
            return null;
        }
        catch (IllegalAccessException e) {
            return null;
        }
        catch (IllegalArgumentException e) {
            return null;
        }
        catch (InvocationTargetException e) {
            return null;
        }
        catch (ClassNotFoundException e) {
            return null;
        }
        af.addFollowUpActionsFactories(subActions);
        return af;
    }

    private String loadParameterString (Element parameterElement) {
        return myXMLTool.getContent(parameterElement);
    }
}
