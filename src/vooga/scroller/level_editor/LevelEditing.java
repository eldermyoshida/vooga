package vooga.scroller.level_editor;

import vooga.scroller.util.mvc.vcFramework.IDomainDescriptor;
import vooga.scroller.util.mvc.vcFramework.Tools;

public class LevelEditing implements IDomainDescriptor {

    @Override
    public String getDomainName () {
        return VIEW_CONSTANTS.DOMAIN_NAME;
    }

    @Override
    public Tools<LevelEditing> getDomainTools () {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static class VIEW_CONSTANTS {
        public static final double DEFAULT_GRIDVIEW_HEIGHT_RATIO = .95;
        public static final double DEFAULT_GRIDVIEW_WIDTH_RATIO = .7;
        public static final double DEFAULT_TOOLSVIEW_HEIGHT_RATIO = .9;
        public static final double DEFAULT_TOOLSVIEW_WIDTH_RATIO = .25;
        public static final String SIMULATION_ERROR_MESSAGE = "SimulationError";
        public static final String DOMAIN_NAME = "Level Editor";
    }

}
