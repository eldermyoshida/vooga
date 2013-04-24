package vooga.scroller.level_editor.view;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vooga.scroller.level_editor.LevelEditing;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.level_editor.controllerSuite.GridSpinner;
import vooga.scroller.level_editor.controllerSuite.LETools;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.Renderer;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.IDomainDescriptor;
import vooga.scroller.util.mvc.vcFramework.Tools;
import vooga.scroller.util.mvc.vcFramework.WindowComponent;
import vooga.scroller.viewUtil.EasyGridFactory;
import vooga.scroller.viewUtil.RadioGroup;


/**
 * EditorView is responsible for presenting editing tools to the user.
 * It provides a UI for the user to select various kind of sprites or
 * environment elements and add them to the actual level being edited.
 * TODO - needs to 
 * @author Dagbedji Fagnisse
 * 
 */
public class TabbedToolsView<D extends IDomainDescriptor> extends 
    WindowComponent<D> {

    public class UpdateGridSizeListener implements ActionListener {
        
        @Override
        public void actionPerformed (ActionEvent e) {
            process(CommandConstants.CHANGE_GRID_SIZE + " " + 
                    myGridSpinner.getGridWidth() + ", " +
                    myGridSpinner.getGridHeight());
        }

    }
    
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
    private Tools<D> myTools;
    
    GridSpinner myGridSpinner;

    public TabbedToolsView (Tools<D> leTools, IView<D> parent) {
        super(parent, getDefaultWidthRatio(), getDefaultHeightRatio());
        myTabs = new JTabbedPane();
        myEditableDependentsUI = new JPanel();
        myEditableDependentsUI.setLayout(new BoxLayout(myEditableDependentsUI, BoxLayout.PAGE_AXIS));
        myIndependentsUI = new JPanel();
        myIndependentsUI.setLayout(new BoxLayout(myIndependentsUI, BoxLayout.PAGE_AXIS));
        setRenderable((Renderable<D>)leTools);
    }

    public String getSelectedEditableDependent () {
        return mySelectedEditableDependent;
    }
    
    private JComponent addOtherSpecificTools() {
        myGridSpinner = new GridSpinner();
        JButton validator = new JButton("Update Grid Size");
        validator.addActionListener(new UpdateGridSizeListener());
        myGridSpinner.add(validator);
        return myGridSpinner;
    }
    
    @Override
    public void render (Renderable<D> tools) {
//        mySpriteUI.setLayout(new SpringLayout());
        for (Map<Image, String> m : myTools.EditableDependents()) {
            if (m.size()>0) {
            JPanel ed_dep_Buttons = new RadioGroup(this.getSize(), 
                                                   new SelectEditableDependentsListener(),
                                                   m);
            myEditableDependentsUI.add(ed_dep_Buttons);
            }
        }

//        myOtherUI.setLayout(new GridLayout());
        for (String keyword : myTools.getEditableIndependents().keySet()) {
            Map<Image, String> m = myTools.getEditableIndependents().get(keyword);
            if (m.size()>0) {
            JPanel ed_ind_Buttons = new RadioGroup(this.getSize(), 
                                   new EditableIndependentsListener(keyword),
                                   m);
            myIndependentsUI.add(ed_ind_Buttons);
            }
        }
        myTabs.add(myEditableDependentsUI, myTools.EditableDependentsTitle());
        myTabs.add(myIndependentsUI, myTools.getEditableIndependentsTitle());
//        myTabs.add(addOtherSpecificTools());
        EasyGridFactory.layout(this, myTabs);
    }

    private void setSelectedEditableDependent (String spriteID) {
        mySelectedEditableDependent = spriteID;
    }

    public void setTools (Tools<D> t) {
        myTools = t;
    }

    @Override
    public void setRenderable (Renderable<D> tools) {
        myTools = (Tools<D>) tools;
        render(tools);
    }

    @Override
    public Renderable<D> getRenderable () {
        return (Renderable<D>) myTools;
    }

}
