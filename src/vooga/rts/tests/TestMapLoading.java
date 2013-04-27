package vooga.rts.tests;

import static org.junit.Assert.*;
import java.io.File;
import java.net.URI;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.BeforeClass;
import org.junit.Test;
import vooga.rts.leveleditor.components.MapLoader;
import vooga.rts.map.GameMap;

public class TestMapLoading {

    @BeforeClass
    public static void setUpBeforeClass () throws Exception {
    }

    @Test
    public void testMapLoader () throws ParserConfigurationException {
        MapLoader ml = new MapLoader();
        GameMap m = null;
        try {            
            URI f = getClass().getResource("maps/ciemas/ciemas.xml").toURI();            
            ml.loadMapFile(new File(f));
            m = ml.getMyMap();
            m.update(100);
        }
        catch (Exception e) {            
            e.printStackTrace();
        }
        assertNotNull(m);
    }

}
