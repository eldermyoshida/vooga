package vooga.scroller.level_editor;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.viewUtil.EasyGridFactory;
import vooga.scroller.viewUtil.IView;
import vooga.scroller.viewUtil.RadioGroup;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.WindowComponent;


/**
 * EditorView is responsible for presenting editing tools to the user.
 * It provides a UI for the user to select various kind of sprites or
 * environment elements and add them to the actual level being edited.
 * 
 * @author Dagbedji Fagnisse
 * 
 */
public class LEToolsView extends WindowComponent {

    private static final long serialVersionUID = 1L;
    private LETools myTools;
    private JTabbedPane myTabs;
    private JPanel mySpriteUI;
    private JPanel myOtherUI;
    private String mySelectedSprite;
    
    public LEToolsView (IView parent, double d, double e) {
        super(parent, d, e);
        // TODO Auto-generated constructor stub
    }

    public LEToolsView (LEWorkspaceView parent, double d, double e) {
        super(parent, d, e);
        myTabs = new JTabbedPane();
        myTools = (LETools) ((LEWorkspaceView) getResponsible()).getTools();
        mySpriteUI = new JPanel();
        JPanel spriteButtons = new RadioGroup(new SelectSpriteListener(),
                                              myTools.getSpriteMakingOptions());
        mySpriteUI.add(spriteButtons);
        myOtherUI = new JPanel();
        JPanel miscButtons = new RadioGroup(new SelectSpriteListener(),
                                            myTools.getMiscOptions());
        initBackgroundButtons(myTools.getBackgrounds());
        myOtherUI.add(miscButtons);
        myTabs.add(mySpriteUI, "Sprites");
        myTabs.add(myOtherUI, "Other");
        EasyGridFactory.layout(this, myTabs);
    }

    private JPanel initBackgroundButtons (Map<Object, String> backgrounds) {
        JPanel backgroundButtons = new JPanel();
        for (Object key : backgrounds.keySet()) {
            JButton currentButton = new JButton((ImageIcon) key);
            currentButton.addActionListener(new BackgroundListener(backgrounds.get(key)));
            backgroundButtons.add(currentButton);
        }
        return null;
    }

    // @Override
    // protected void initializeVariables () {
    // // TODO Auto-generated method stub
    // // this.setSize(120, 300);
    //
    // }

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

    private class BackgroundListener implements ActionListener {

        private String myID;

        BackgroundListener (String id) {
            myID = id;
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            sendBackground(myID);
        }

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

    public void setTools (LETools t) {
        myTools = t;
    }

}
