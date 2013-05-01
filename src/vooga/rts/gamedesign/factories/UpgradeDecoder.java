package vooga.rts.gamedesign.factories;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.ReflectionHelper;

/**
 * This class is an extension of Decoder class that is in charge of the creation
 * of UpgradeTree for upgrade package.
 * 
 * @author Wenshun Liu
 *
 */
public class UpgradeDecoder extends Decoder {
	public static final String TREE_TAG = "tree";
	public static final String TREE_NAME_TAG = "treeName";
	public static final String UPGRADE_CATEGORY_TAG = "type";
	public static final String CATEGORY_NAME_TAG = "name";
	public static final String INDIVIDUAL_UPGRADE_TAG = "upgradeNode";
	public static final String PARENT_UPGRADE_TAG = "parent";
	public static final String TITLE_TAG = "nodeName";
	public static final String AFFECTING_OBJECT_TAG = "object";
	public static final String AFFECTING_VALUE_TAG = "value";
	public static final String COSTING_RESOURCE_TYPE_TAG = "resourceCostType";
	public static final String COSTING_RESOURCE_AMOUNT_TAG = "resourceAmount";
	
	private Factory myFactory;
	private Map<String, String> myUpgradeNodeType;
	
	public UpgradeDecoder(Factory factory) throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException{
		myFactory = factory;
		myUpgradeNodeType = new HashMap<String, String>();
		myFactory.loadMappingInfo("UpgradeNodeMatchUp", myUpgradeNodeType);
	}

	/**
	 * Creates the UpgradeTrees and puts them into map in Factory by receiving
	 * Document passed in from the Factory, containing necessary information
	 * related to the UpgradeTree
	 * 
	 * @param doc the Document passed in from Factory
	 * @throws NumberFormatException 
	 * 
	 */
	public void create(Document doc, String type) throws NumberFormatException {
		NodeList treeLst = doc.getElementsByTagName(TREE_TAG);		
		for (int i = 0; i < treeLst.getLength(); i++) {
			Element treeElmnt = (Element) treeLst.item(i);
			Element treeNameElmnt = (Element) treeElmnt.getElementsByTagName(TREE_NAME_TAG).item(0);
			NodeList treeName = treeNameElmnt.getChildNodes();
			createSingleTree(((Node) treeName.item(0)).getNodeValue(), treeElmnt);
		}
	}
	
	/**
	 * Creates a single upgrade tree based on information loaded from the input
	 * xml file.
	 * 
	 * @param treeName
	 * @param treeElmnt
	 */
	private void createSingleTree(String treeName, Element treeElmnt) {
		UpgradeTree upgradeTree = new UpgradeTree();
		NodeList nodeLst = treeElmnt.getElementsByTagName(UPGRADE_CATEGORY_TAG);

		for (int i = 0; i < nodeLst.getLength(); i++) {

			Element typeElmnt = (Element) nodeLst.item(i);
			Element nameElmnt = (Element) typeElmnt.
					getElementsByTagName(CATEGORY_NAME_TAG).item(0);
			NodeList name = nameElmnt.getChildNodes();
			upgradeTree.addBranch(((Node) name.item(0)).getNodeValue());

			NodeList upgradeNodeList = typeElmnt.
					getElementsByTagName(INDIVIDUAL_UPGRADE_TAG);
			for (int j=0; j<upgradeNodeList.getLength(); ++j) {
				Element upgradeNodeElement = (Element) upgradeNodeList.item(j);

				String parent = getElement(upgradeNodeElement,
						PARENT_UPGRADE_TAG);
				String nodeName = getElement(upgradeNodeElement,
						TITLE_TAG);
				String object = getElement(upgradeNodeElement,
						AFFECTING_OBJECT_TAG);
				String value = getElement(upgradeNodeElement,
						AFFECTING_VALUE_TAG);
				String costedResource = getElement(upgradeNodeElement,
						COSTING_RESOURCE_TYPE_TAG);
				String costedResourceAmount = getElement(upgradeNodeElement,
						COSTING_RESOURCE_AMOUNT_TAG);

				UpgradeNode newUpgrade = (UpgradeNode) ReflectionHelper.
						makeInstance(myUpgradeNodeType.get(object),
								upgradeTree, nodeName, Integer.parseInt(value),
								Integer.parseInt(costedResourceAmount));
				UpgradeNode current = upgradeTree.findNode(parent);
				current.addChild(newUpgrade);
			}
		}
		upgradeTree.updateTreeStatus();		
		myFactory.put(treeName, upgradeTree);
	}
	
	/**
	 * TESTING PURPOSE. PRINTS TREE.
	 * @param upgradeTree
	 */
	private void printTree(UpgradeTree upgradeTree) {
		for (UpgradeNode u: upgradeTree.getHead().getChildren()) {
			UpgradeNode current = u;
			while (!current.getChildren().isEmpty()) {
				for (UpgradeNode node: current.getChildren()) {
					System.out.println("Name: " + node.getUpgradeName() +
							" Parent Name " + current.getUpgradeName());
				}
				current = current.getChildren().get(0);
						//should recurse if really want to print the whole tree
			}
		}
		for (UpgradeNode u: upgradeTree.getCurrentUpgrades()) {
			System.out.println("Current Upgrades: " + u.getUpgradeName());
		}
	}
}
