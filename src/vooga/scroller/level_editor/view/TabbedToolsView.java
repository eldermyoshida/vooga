package vooga.scroller.level_editor.view;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vooga.scroller.level_editor.LevelEditing;
import vooga.scroller.util.Renderable;
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
 * @param <D> - Domain Descriptor
 * @author Dagbedji Fagnisse
 * 
 */
public class TabbedToolsView<D extends IDomainDescriptor> 
                               extends WindowComponent<D> {
    

    private static final long serialVersionUID = 1L;

    private JPanel myIndependentsUI;

    private String mySelectedEditableDependent;
    private JPanel myEditableDependentsUI;

    private JTabbedPane myTabs;
    private Tools<D> myTools;





    /**
     * Build a side tabbed option view with the provided tools.
     * @param tools - to be used to configure this view
     * @param parent - container
     */
    public TabbedToolsView (Tools<D> tools, IView<D> parent) {
        super(parent, getDefaultWidthRatio(), getDefaultHeightRatio());
        myTabs = new JTabbedPane();
        myEditableDependentsUI = new JPanel();
        myEditableDependentsUI.setLayout(new BoxLayout(myEditableDependentsUI, BoxLayout.PAGE_AXIS));
        myIndependentsUI = new JPanel();
        myIndependentsUI.setLayout(new BoxLayout(myIndependentsUI, BoxLayout.PAGE_AXIS));
        setRenderable((Renderable<D>)tools);
    }
    
    
    private static double getDefaultHeightRatio () {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_TOOLSVIEW_HEIGHT_RATIO;
    }

    private static double getDefaultWidthRatio () {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_TOOLSVIEW_WIDTH_RATIO;
    }

    /**
     * State to keep track of the currently selected location-dependent option
     * It is like a flip-flop
     * @return
     */
    public String getSelectedEditableDependent () {
        return mySelectedEditableDependent;
    }


    @Override
    public void render (Renderable<D> tools) {
        setup((Tools<D>) tools);
    }

    private void setSelectedEditableDependent (String spriteID) {
        mySelectedEditableDependent = spriteID;
    }

    private void setTools (Tools<D> t) {
        myTools = t;
    }

    @Override
    public void setRenderable (Renderable<D> tools) {
        setTools((Tools<D>) tools);
        render(tools);
    }

    private void setup(Tools<D> tools) {

        for (Map<Image, String> m : myTools.getEditableDependents()) {
            if (m.size() > 0) {
                JPanel edDepButtons = new RadioGroup(this.getSize(), 
                                                       new SelectEditableDependentsListener(),
                                                       m);
                myEditableDependentsUI.add(edDepButtons);
            }
        }

        for (String keyword : myTools.getEditableIndependents().keySet()) {
            Map<Image, String> m = myTools.getEditableIndependents().get(keyword);
            if (m.size() > 0) {
                JPanel edIndButtons = new RadioGroup(this.getSize(), 
                                                       new EditableIndependentsListener(keyword),
                                                       m);
                myIndependentsUI.add(edIndButtons);
            }
        }
        myTabs.add(myEditableDependentsUI, myTools.getEditableDependentsTitle());
        myTabs.add(myIndependentsUI, myTools.getEditableIndependentsTitle());
        EasyGridFactory.layout(this, myTabs);
    }

    @Override
    public Renderable<D> getRenderable () {
        return (Renderable<D>) myTools;
    }


    private class EditableIndependentsListener implements ActionListener {
        private String myKeyword;
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
}
