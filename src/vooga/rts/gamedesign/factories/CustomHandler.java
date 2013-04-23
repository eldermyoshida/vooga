package vooga.rts.gamedesign.factories;

import java.lang.reflect.InvocationTargetException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import vooga.rts.gamedesign.sprite.gamesprites.Resource;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.util.ReflectionHelper;

public class CustomHandler {
	
	private static final String CUSTOM_TAG = "custom";
	private static final String NAME_TAG = "name";
	private static final String SOURCE_TAG = "src";
	
	private Factory myFactory;
	public CustomHandler(Factory factory){
		myFactory = factory;
	}

	
	public void addAllCustoms(Document doc, String type){
		NodeList custom = doc.getElementsByTagName(CUSTOM_TAG + type);
		for(int i = 0; i < custom.getLength() ; i++){
			Element customElement = (Element) custom.item(i);
			String path = customElement.getAttributes().getNamedItem(SOURCE_TAG).getTextContent();
			String name = customElement.getElementsByTagName(NAME_TAG).item(0).getTextContent();

				
		}
		
		
	}
	
	
	
	
	

}
