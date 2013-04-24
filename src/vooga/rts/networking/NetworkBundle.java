package vooga.rts.networking;

import java.util.ResourceBundle;

/**
 * Class used to manage resources of the networking package
 * By default, the resourcebundle seeks an english.properties file and can be
 * accessed statically to preserve lines of code
 * 
 * However, the user can still get a different resourcebundle if he sets the language
 * and/or path
 * 
 * @author Henrique Moraes
 *
 */
public class NetworkBundle {
	private static String PROPERTIES = ".properties";
	private static String LANGUAGE = "english";
	private static String RESOURCE_PACKAGE = "resources.";
	public static ResourceBundle BUNDLE = ResourceBundle.getBundle(RESOURCE_PACKAGE+LANGUAGE+PROPERTIES);
	
	private ResourceBundle myBundle;
	private String myLanguage;
	private String myRelativePath = RESOURCE_PACKAGE;
	
	/**
	 * 
	 * @return ResourceBundle
	 */
	public ResourceBundle getBundle() {
		return myBundle;
	}
	
	/**
	 * Sets the language used by this resourcebundle according to its filename 
	 * @param language Name of the file in which resources are located
	 */
	public void setLanguage(String language) {
		myLanguage = language;
		myBundle = ResourceBundle.getBundle(myRelativePath+myLanguage+PROPERTIES);
	}
	
	/**
	 * 
	 * @param path The relative path to the desired file
	 */
	public void setRelativePath(String path) {
		if (path.charAt(path.length()-1) != '.')
			path = path+'.';
		myRelativePath = path;
	}
}
