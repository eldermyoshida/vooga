package vooga.towerdefense.gameeditor.gameloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.factories.rulefactories.RuleFactory;
import vooga.towerdefense.model.GameModel;
import vooga.towerdefense.model.rules.Rule;

public class RulesXMLLoader {

    private XMLTool myXMLTool;

    public RulesXMLLoader (XMLTool xmlTool) {
        myXMLTool = xmlTool;
    }
    
    public List<Rule> getRules(GameModel gameModel, Element rulesElement) {
        List<RuleFactory> ruleFactories = getRuleFactories(rulesElement);
        
        List<Rule> rules = new ArrayList<Rule>();
        for (RuleFactory rf : ruleFactories) {
            rules.add(rf.create(gameModel));
        }
        
        return rules;
    }
    
    public List<RuleFactory> getRuleFactories(Element rulesElement) {
        Map<String, Element> subElements = myXMLTool.getChildrenElementMap(rulesElement);
        
        List<RuleFactory> ruleFactories = new ArrayList<RuleFactory>();
        for (Element ruleElement : subElements.values()) {
            ruleFactories.add(getRuleFactory(ruleElement));
        }
        
        return ruleFactories;
    }

    private RuleFactory getRuleFactory (Element ruleNameElement) {
        List<String> constructorParams = getRuleFactoryConstructorParameters(ruleNameElement);
        
        try {
            Class ruleFactoryClass = Class.forName(myXMLTool.getContent(ruleNameElement));
            Constructor c = ruleFactoryClass.getConstructors()[0];
            RuleFactory ruleFactory =
                    (RuleFactory) c.newInstance(constructorParams.toArray(new String[] {}));
            return ruleFactory;
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
    }

    private List<String> getRuleFactoryConstructorParameters (Element ruleNameElement) {
        Map<String, Element> subElements = myXMLTool.getChildrenElementMap(ruleNameElement);

        List<String> ruleFactoryConstructorParameters = new ArrayList<String>();
        for (Element e : subElements.values()) {
            ruleFactoryConstructorParameters.add(getRuleFactoryConstructorParameter(e));
        }

        return ruleFactoryConstructorParameters;
    }

    private String getRuleFactoryConstructorParameter (Element ruleParameterElement) {
        return myXMLTool.getContent(ruleParameterElement);
    }

}
