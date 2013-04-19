
package vooga.scroller.level_editor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vooga.scroller.viewUtil.EasyGridFactory;
import vooga.scroller.viewUtil.IView;
import vooga.scroller.viewUtil.RadioGroup;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.WindowComponent;
/**
 * EditorView is responsible for presenting editing tools to the user.
 * It provides a UI for the user to select various kind of sprites or 
 * environment elements and add them to the actual level being edited.
 * @author Dagbedji Fagnisse
 *
 */
public class LEToolsView extends WindowComponent {

    private LETools myTools;
    private JTabbedPane myTabs;
    private JPanel spriteUI;
    private JPanel otherUI;
    private String selectedSprite;
    private String selectedSpecialPoint;
    

    public LEToolsView (IView parent, double d, double e) {
        super(parent, d, e);
        // TODO Auto-generated constructor stub
    }
    
    public LEToolsView (LEWorkspaceView parent, double d, double e) {
        super(parent, d, e);
        myTabs = new JTabbedPane();
        myTools = (LETools) ((LEWorkspaceView) getResponsible()).getTools();
        spriteUI = new JPanel();
        spriteUI.setLayout(new BoxLayout(spriteUI, BoxLayout.PAGE_AXIS));
        for (Map<Object, String> m : myTools.getAllSprites()) {
            JPanel spriteButtons = new RadioGroup(new SelectSpriteListener(), m);
            spriteUI.add(spriteButtons);
        }
        
        otherUI = new JPanel();
//        JPanel otherButtons = new RadioGroup(new SetSpecialPointListener(),
//                                             myTools.getOtherOptions());
//        otherUI.add(otherButtons);
        myTabs.add(spriteUI, "Sprites");
        myTabs.add(otherUI, "Other");
        EasyGridFactory.layout(this, myTabs);
    }

    @Override
    public void render (Renderable r) {
        // TODO Auto-generated method stub
        
    }
    
    private class SelectSpriteListener implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            setSelectedSprite(e.getActionCommand());
        }
        
    }
    
    private class SetSpecialPointListener implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            setSpecialPoint(e.getActionCommand());
        }
        
    }
    
    //TODO - decide if it is best to treat doors as sprite
    private void setSpecialPoint (String type) {
        selectedSpecialPoint = type;
        selectedSprite = type;
    }
    
    private void setSelectedSprite(String spriteID) {
        selectedSprite = spriteID;
    }
    
    public String getSelectedSpriteID() {
        return selectedSprite;
    }
    
    public String getSelectedSpecialPoint() {
        return selectedSpecialPoint;
    }
    
    public void setTools(LETools t) {
        myTools = t;
    }

}
