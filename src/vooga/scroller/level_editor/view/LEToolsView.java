package vooga.scroller.level_editor.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.level_editor.controllerSuite.LETools;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.WindowComponent;
import vooga.scroller.viewUtil.EasyGridFactory;
import vooga.scroller.viewUtil.RadioGroup;


/**
 * EditorView is responsible for presenting editing tools to the user.
 * It provides a UI for the user to select various kind of sprites or
 * environment elements and add them to the actual level being edited.
 * 
 * @author Dagbedji Fagnisse
 * 
 */
public class LEToolsView extends WindowComponent {
    
    private static final double DEFAULT_HEIGHT_RATIO = 
            LEView.CONSTANTS.DEFAULT_TOOLSVIEW_HEIGHT_RATIO;
    private static final double DEFAULT_WIDTH_RATIO = 
            LEView.CONSTANTS.DEFAULT_TOOLSVIEW_WIDTH_RATIO;

    private static final long serialVersionUID = 1L;
    private LETools myTools;
    private JTabbedPane myTabs;
    private JPanel mySpriteUI;
    private JPanel myOtherUI;
    private String mySelectedSprite;
    private String mySelectedSpecialPoint;
    

    public LEToolsView (LEWorkspaceView parent) {
        super(parent, DEFAULT_WIDTH_RATIO, DEFAULT_HEIGHT_RATIO);
        myTabs = new JTabbedPane();
        myTools = (LETools) ((LEWorkspaceView) getResponsible()).getTools();
        mySpriteUI = new JPanel();
        mySpriteUI.setLayout(new BoxLayout(mySpriteUI, BoxLayout.PAGE_AXIS));
        for (Map<Object, String> m : myTools.getAllSprites()) {
            JPanel spriteButtons = new RadioGroup(this.getSize(), new SelectSpriteListener(), m);
            mySpriteUI.add(spriteButtons);
        }

        myOtherUI = new JPanel();
//        JPanel otherButtons = new RadioGroup(new SetSpecialPointListener(),
//                                             myTools.getOtherOptions());
//        myOtherUI.add(otherButtons);
        myTabs.add(mySpriteUI, "Sprites");
        myTabs.add(myOtherUI, "Other");
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
        mySelectedSpecialPoint = type;
        mySelectedSprite = type;
    }

    private void setSelectedSprite (String spriteID) {
        mySelectedSprite = spriteID;
    }
    
    private void sendBackground (String id) {
        process(CommandConstants.CHANGE_BACKGROUND + CommandConstants.SPACE + id);
    }

    public String getSelectedSpriteID () {
        return mySelectedSprite;
    }

    public int getSelectedTab () {
        return myTabs.getSelectedIndex();
    }
    
    public String getSelectedSpecialPoint() {
        return mySelectedSpecialPoint;
    }
    
    public void setTools (LETools t) {
        myTools = t;
    }

}
