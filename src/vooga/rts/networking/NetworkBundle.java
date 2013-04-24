package vooga.rts.networking;

import java.util.ResourceBundle;

public class NetworkBundle {
	private static String PROPERTIES = ".properties";
	private static String LANGUAGE = "english";
	private static String RESOURCE_PACKAGE = "resources.";
	public static ResourceBundle BUNDLE = ResourceBundle.getBundle(RESOURCE_PACKAGE+LANGUAGE+PROPERTIES);
	
	private ResourceBundle myBundle;
	private String myLanguage;
	
	public ResourceBundle getBundle() {
		return myBundle;
	}
	
	public void setLanguage(String language) {
		myLanguage = language;
		myBundle = ResourceBundle.getBundle(RESOURCE_PACKAGE+myLanguage+PROPERTIES);
	}
}
