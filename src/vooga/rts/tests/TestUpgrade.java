package vooga.rts.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vooga.rts.commands.Command;
import vooga.rts.gamedesign.factories.Factory;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Soldier;
import vooga.rts.gamedesign.upgrades.UpgradeNode;

public class TestUpgrade {
	
	/**
	 * This test was designed for creating upgrade tree, loading actions, and
	 * applying actions. It is out of date as UpgradeTrees are now stored in
	 * each Unit, instead of an UpgradeBuilding specifically in charge of upgrades.
	 * Also, now upgrade Actions are stored in upgrade strategies, and the action
	 * is only applied to the unit that owns the tree, instead of all units of
	 * the same type.
	 */
	private void OldTestOne() throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException{
		Factory factory = new Factory();
		
		factory.loadXMLFile("Factory.xml");
		
		//creates an UpgradeBuilding
		/**UpgradeBuilding upgradeBuilding = new UpgradeBuilding();
		
		//creates two Units - adds upgrade Actions to the UpgradeBuilding
		//the first Unit needs to specify the UpgradeTree all Units will be using.
		InteractiveEntity oneUnit = new Unit();
		//oneUnit.setUpgradeTree(resultTree);
		upgradeBuilding.addUpgradeActions(resultTree);
		InteractiveEntity twoUnit = new Unit();
		oneUnit.setAttackStrategy(new CanAttack());
		twoUnit.setAttackStrategy(new CanAttack());
		for (Action a: upgradeBuilding.getActions()) {
			System.out.println("Action type: " + a.getName());
		}
		System.out.println(oneUnit.getMaxHealth());
		System.out.println(twoUnit.getMaxHealth());
		
		//finds Action  - 
		Action WorstArmorAction = upgradeBuilding.findAction("Boost1");
		//WorstArmorAction.apply();
		System.out.println(oneUnit.getMaxHealth());
		System.out.println(twoUnit.getMaxHealth());*/
	}

	private static String readUserInput(String printMessage)
			throws IOException {
		System.out.print(printMessage);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String returnString;
		try {
			returnString = br.readLine();
		} catch (IOException e) {
			throw new IOException(e);
		}
		return returnString;
	}
	
	private void upgradeWithNewManager() throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException{
		Factory factory = new Factory();
		factory.loadXMLFile("Factory.xml");
		Soldier soldier = new Soldier();
		soldier.setUpgradeTree(factory.getUpgradeTrees().get(""));
		try {
			while (true) {
				for (UpgradeNode currentUpgrade: soldier.getUpgradeTree().getCurrentUpgrades()) {
					System.out.println("Current upgrades: " + currentUpgrade.getUpgradeName());
				}
				String s = readUserInput("enter upgrade to be activated: ");
				soldier.getAction(new Command(s)).apply();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] argu) throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException{
		TestUpgrade testUpgrade = new TestUpgrade();
		testUpgrade.upgradeWithNewManager();
	}
}
