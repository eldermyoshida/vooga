package vooga.towerdefense.gameeditor.gameloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.factories.actionfactories.ActionFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;


public class ActionXMLLoader {
    private static final String ACTIONS_TAG = "actions";

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
    public List<Action> loadActions (Element actionsElement, GameMap gameMap) {
        return loadActions(null, actionsElement, gameMap);
    }

    /**
     * This method loads all the actions described in XML that
     * act upon a GameElement object e.
     * 
     * @param e the game element object that an action acts on
     * @return a list of actions acting on e
     */
    public List<Action> loadActions (GameElement e, Element actionsElement, GameMap gameMap) {
        List<ActionFactory> actionFactories = loadActionFactories(actionsElement, gameMap);

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
    public List<ActionFactory> loadActionFactories (Element actionsElement, GameMap gameMap) {
        Map<String, Element> subElements = myXMLTool.getChildrenElementMap(actionsElement);

        List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
        for (Element e : subElements.values()) {
            actionFactories.add(loadActionFactory(e, gameMap));
        }
        return actionFactories;
    }

    private ActionFactory loadActionFactory (Element actionElement, GameMap gameMap) {
        String actionName = myXMLTool.getTagName(actionElement);
        
        List<String> parameterStrings = new ArrayList<String>();
        List<ActionFactory> subActions = new ArrayList<ActionFactory>();

        List<Element> subElements = myXMLTool.getChildrenList(actionElement);

        for (Element subElement: subElements) {
            String subElementName = myXMLTool.getTagName(subElement);
            if (subElementName.equals(ACTIONS_TAG)) {
                subActions.add(loadActionFactory(subElement, gameMap));
            }
            else {                
                parameterStrings.add(loadParameterString(subElement));
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
        af.initialize(gameMap);
        return af;
    }

    private String loadParameterString (Element parameterElement) {
        return myXMLTool.getContent(parameterElement);
    }
}
