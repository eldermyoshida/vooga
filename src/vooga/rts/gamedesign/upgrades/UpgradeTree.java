package gamedesign.upgrades;

/**
 * This class is the tree of upgrades that any object that can be upgraded will
 * hold.  For example, every unit will have an upgrade tree (and each unit of
 * the same type will have the same upgrade tree).  Upgrades are being stored
 * in a tree like structure because in some cases upgrades are specified in
 * certain branches so that buying a certain tier 1 upgrade does not
 * necessarily mean that all tier 2 upgrades are now available.  For example
 * buying the tier 1 armor upgrade does not mean that the tier 2 weapon upgrade
 * is available (only the tier 2 armor upgrade would be available).  If there
 * are multiple types of tier 1 upgrades, the root of the tree would not
 *  contain an upgrade.  
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class UpgradeTree {
}