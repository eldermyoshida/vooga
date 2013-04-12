package vooga.rts.gamedesign.factories;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** 
 *  This class will be an abstract class for factories that will be able to
 *  read in from an xml file or some input.
 *  
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 */
public abstract class Factory {

	public void load() {
	}

	public void create() {
	}

}