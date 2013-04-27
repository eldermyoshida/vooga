package vooga.scroller.util.mvc.vcFramework;

import java.util.List;
import javax.swing.JMenu;

public interface IDomainDescriptor {
    
    String getDomainName();
    
    Tools<? extends IDomainDescriptor> getDomainTools();
    
    List<JMenu> getDomainSpecificMenus();
    

}
