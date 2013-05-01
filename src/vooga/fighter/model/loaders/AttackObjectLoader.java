package vooga.fighter.model.loaders;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.model.ModelConstants;
import vooga.fighter.model.objects.AttackObject;
import vooga.fighter.model.utils.Effect;

/**
 * Loads the resources necessary for AttackObjects. Reads the data from the file designated
 * in the path ModelConstants.ATTACKLOADER_PATH_TAG.
 * @author David Le, alanni
 *
 */
public class AttackObjectLoader extends ObjectLoader {

    /**
     * The AttackObject which will be modified
     */
    private AttackObject myAttack;
    /**
     * Constructs the attack loader with the name to be loaded and the attack which the
     * loader will modify.
     * @param attackName The name of the attack to be matched in the xml file
     * @param attack The AttackObject to modify
     * @param pathHierarchy The path to the folder containing the game's resources
     */
    public AttackObjectLoader (String attackName, AttackObject attack, String pathHierarchy) {
        super(ModelConstants.ATTACKLOADER_PATH_TAG, pathHierarchy);  
        myAttack = attack;
        load(attackName, pathHierarchy);
    }

    /**
     * Loads resources for the appropriate attack object matched by the param attackName
     * @param attackName Name tag of the attack to be loaded in the xml file
     * @param pathHierarchy The path to the folder containing the game's resources
     */
    @Override
    protected void load(String attackName, String pathHierarchy) {
        Document doc = getDocument();
        NodeList attackNodes = doc.getElementsByTagName(ModelConstants.ATTACK_PROPERTY);

        for (int i = 0; i < attackNodes.getLength(); i++) {
            Element attackNode = (Element) attackNodes.item(i);
            String name = getAttributeValue(attackNode, ModelConstants.ATTACKNAME_PROPERTY);
            NodeList effects= doc.getElementsByTagName(ModelConstants.EFFECT_PROPERTY);;
            if (attackName.equals(name)) {
                addProperties(attackNode, myAttack);
                NodeList stateNodes = attackNode.getElementsByTagName(ModelConstants.STATE_PROPERTY);
                addStates(stateNodes, myAttack);
                myAttack.defineDefaultState(getAttributeValue(attackNode, ModelConstants.DEFAULT_PROPERTY));
                addEffects(effects, pathHierarchy);

            }
        }
    }


    /**
     * Creates effect objects and adds them to attack 
     */

    protected void addEffects(NodeList effects, String pathHierarchy){
        for (int i=0; i<effects.getLength(); i++){
            Node effect= effects.item(i);
            String effectPath= getResourceBundle().getString(ModelConstants.EFFECT_PATH_TAG);
            String effectName= getAttributeValue(effect,ModelConstants.EFFECTNAME_PROPERTY);
            Object effectObject = null;
            Effect curr = null;
            try {
                Class<?> newEffects = null;
                newEffects = Class.forName(effectPath+effectName);
                effectObject = newEffects.newInstance();
                curr = (Effect) effectObject;
            }
            catch (Exception e) {
                throw new NullPointerException(ModelConstants.NO_CLASS_EXCEPTION);
            }
            getAndAddProperty(effect, ModelConstants.DURATION_PROPERTY, curr);
            getAndAddProperty(effect, ModelConstants.DAMAGE_PROPERTY, curr);
            myAttack.addEffect(curr);
        }
    }

    /**
     * Adds property values for Effects
     */
    private void getAndAddProperty(Node node, String property, Effect effect){
        int propertyValue= Integer.parseInt(getAttributeValue(node, property));
        effect.addProperty(property, propertyValue);
    }

}
