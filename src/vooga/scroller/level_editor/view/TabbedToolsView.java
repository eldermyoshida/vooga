package vooga.scroller.level_editor.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vooga.scroller.level_editor.controllerSuite.LETools;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.Renderer;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.Tools;
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
public class TabbedToolsView extends 
    WindowComponent<TabbedToolsView> 
    implements Renderer<Tools<TabbedToolsView>>{

    public class EditableIndependentsListener implements ActionListener {
        String myKeyword;
        EditableIndependentsListener(String s) {
            myKeyword = s;
        }
        
        @Override
        public void actionPerformed (ActionEvent e) {
            process(myKeyword + " " + e.getActionCommand());
        }

    }

    private class SelectEditableDependentsListener implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            setSelectedEditableDependent(e.getActionCommand());
        }

    }

    private static final long serialVersionUID = 1L;

    public static double getDefaultHeightRatio () {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_TOOLSVIEW_HEIGHT_RATIO;
    }

    public static double getDefaultWidthRatio () {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_TOOLSVIEW_WIDTH_RATIO;
    }

    private JPanel myIndependentsUI;

    private String mySelectedEditableDependent;
    private JPanel myEditableDependentsUI;

    private JTabbedPane myTabs;

    private Tools<TabbedToolsView> myTools;

    public TabbedToolsView (Tools<TabbedToolsView> leTools, IView parent) {
        super(parent, getDefaultWidthRatio(), getDefaultHeightRatio());
        myTabs = new JTabbedPane();
        myEditableDependentsUI = new JPanel();
        myEditableDependentsUI.setLayout(new BoxLayout(myEditableDependentsUI, BoxLayout.PAGE_AXIS));
        myIndependentsUI = new JPanel();
        render(leTools);
    }

    public String getSelectedEditableDependent () {
        return mySelectedEditableDependent;
    }

    @Override
    public void render (Renderable<TabbedToolsView> r) { // TODO - Should not really be used/needed
        if (r instanceof Tools) {
            Tools<TabbedToolsView> t = (Tools<TabbedToolsView>) r;
            render(t);
        }
    }
    
    public void render (Tools<TabbedToolsView> tools) {
        myTools = tools;
//        mySpriteUI.setLayout(new SpringLayout());
        for (Map<Object, String> m : myTools.EditableDependents()) {
            if (m.size()>0) {
            JPanel ed_dep_Buttons = new RadioGroup(this.getSize(), 
                                                   new SelectEditableDependentsListener(),
                                                   m);
            myEditableDependentsUI.add(ed_dep_Buttons);
            }
        }

//        myOtherUI.setLayout(new GridLayout());
        JPanel independentsUI = new RadioGroup(this.getSize(), 
                                               new EditableIndependentsListener(
                                               myTools.getEditableIndependentsKeyword()),
                                               myTools.getEditableIndependents());
        myIndependentsUI.add(independentsUI);
        myTabs.add(myEditableDependentsUI, myTools.EditableDependentsTitle());
        myTabs.add(myIndependentsUI, myTools.getEditableIndependentsTitle());
        EasyGridFactory.layout(this, myTabs);
    }

    private void setSelectedEditableDependent (String spriteID) {
        mySelectedEditableDependent = spriteID;
    }

    public void setTools (LETools t) {
        myTools = t;
    }

    @Override
    public void setRenderable (Tools<TabbedToolsView> tools) {
        // TODO Auto-generated method stub
        myTools = tools;
//      mySpriteUI.setLayout(new SpringLayout());
      for (Map<Object, String> m : myTools.EditableDependents()) {
          if (m.size()>0) {
          JPanel ed_dep_Buttons = new RadioGroup(this.getSize(), 
                                                 new SelectEditableDependentsListener(),
                                                 m);
          myEditableDependentsUI.add(ed_dep_Buttons);
          }
      }

//      myOtherUI.setLayout(new GridLayout());
      JPanel independentsUI = new RadioGroup(this.getSize(), 
                                             new EditableIndependentsListener(
                                             myTools.getEditableIndependentsKeyword()),
                                             myTools.getEditableIndependents());
      myIndependentsUI.add(independentsUI);
      myTabs.add(myEditableDependentsUI, myTools.EditableDependentsTitle());
      myTabs.add(myIndependentsUI, myTools.getEditableIndependentsTitle());
      EasyGridFactory.layout(this, myTabs);
    }

    @Override
    public Tools<TabbedToolsView> getRenderable () {
        return myTools;
    }

}
