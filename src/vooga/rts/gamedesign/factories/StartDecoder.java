package vooga.rts.gamedesign.factories;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StartDecoder extends Decoder {

    private Factory myFactory;
    
    public StartDecoder(Factory factory){
        myFactory = factory;
    }
    @Override
    public void create (Document doc, String type) {
        NodeList starterPack = doc.getElementsByTagName(START_TAG).item(0).getChildNodes();
        for (int i = 0; i < starterPack.getLength(); i++) {
            Node elem = starterPack.item(i);
            if (elem.getNodeType() == Node.ELEMENT_NODE) {
                String name = elem.getNodeName();
                int amount = Integer.parseInt(elem.getTextContent());
                myFactory.put(name, amount);
            }
        }
        

    }

}
