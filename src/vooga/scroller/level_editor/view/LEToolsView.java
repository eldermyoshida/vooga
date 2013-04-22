package vooga.scroller.level_editor.view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.level_editor.controllerSuite.LETools;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.Renderer;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.WindowComponent;
import vooga.scroller.viewUtil.BackgroundButton;
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
public class LEToolsView extends WindowComponent implements Renderer<LETools> {

    private class SelectSpriteListener implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            setSelectedSprite(e.getActionCommand());
        }

    }

    private static final long serialVersionUID = 1L;

    public static double getDefaultHeightRatio () {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_TOOLSVIEW_HEIGHT_RATIO;
    }

    public static double getDefaultWidthRatio () {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_TOOLSVIEW_WIDTH_RATIO;
    }

    private JPanel myOtherUI;
    private String mySelectedSpecialPoint;
    private String mySelectedSprite;

    private JPanel mySpriteUI;

    private JTabbedPane myTabs;

    private LETools myTools;

    public LEToolsView (LETools leTools, IView parent) {
        super(parent, getDefaultWidthRatio(), getDefaultHeightRatio());
        myTabs = new JTabbedPane();
        myTools = leTools;
        mySpriteUI = new JPanel();
        mySpriteUI.setLayout(new BoxLayout(mySpriteUI, BoxLayout.PAGE_AXIS));
        for (Map<Object, String> m : myTools.getAllSprites()) {
            JPanel spriteButtons = new RadioGroup(this.getSize(), new SelectSpriteListener(), m);
            mySpriteUI.add(spriteButtons);
        }

        myOtherUI = new JPanel();
        JPanel backgroundView = new JPanel();
        backgroundView.setLayout(new GridLayout());
        for (Object key : myTools.getBackgrounds().keySet()) {
            backgroundView.add(makeBackgroundButton((Image) key, 
                               myTools.getBackgrounds().get(key)));
        }
        myOtherUI.add(backgroundView);
        myTabs.add(mySpriteUI, "Sprites");
        myTabs.add(myOtherUI, "Other");
        EasyGridFactory.layout(this, myTabs);
    }

    private JButton makeBackgroundButton (Image background, String id) {
       final BackgroundButton button = new BackgroundButton(new ImageIcon(background), id);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed (ActionEvent e) {
                sendBackground(button.getID());
            }
            
        });
        return button;
    }

    @Override
    public LETools getRenderable () {
        // TODO Auto-generated method stub
        return null;
    }

    public String getSelectedSpecialPoint () {
        return mySelectedSpecialPoint;
    }

    public String getSelectedSpriteID () {
        return mySelectedSprite;
    }

    public int getSelectedTab () {
        return myTabs.getSelectedIndex();
    }

    @Override
    public void render (LETools renderable) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render (Renderable r) { // TODO - Should not really be used/needed
        if (r instanceof LETools) {
            LETools t = (LETools) r;
            myTools = t;
            t.initializeRenderer(getResponsible());
        }
    }

    private void sendBackground (String id) {
        process(CommandConstants.CHANGE_BACKGROUND + CommandConstants.SPACE + id);
    }

    @Override
    public void setRenderable (LETools tools) {
        myTools = tools;
    }

    private void setSelectedSprite (String spriteID) {
        mySelectedSprite = spriteID;
    }

    public void setTools (LETools t) {
        myTools = t;
    }

}
