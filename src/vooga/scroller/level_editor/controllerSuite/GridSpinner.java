package vooga.scroller.level_editor.controllerSuite;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vooga.scroller.util.mvc.vcFramework.ViewConstants;

public class GridSpinner extends JPanel implements ChangeListener {

        /**
     * 
     */
    private static final long serialVersionUID = -4816807088612765588L;
        private int gridHeight = LEController.DEFAULT_SPRITE_GRID_SIZE;
        private int gridWidth = LEController.DEFAULT_SPRITE_GRID_SIZE;
        private JSpinner hspinner;
        private JSpinner wspinner;
        int step = 5;
        
        public GridSpinner() {
            this(LEController.MIN_SPRITE_GRID_SIZE,
                 LEController.MAX_SPRITE_GRID_SIZE);
        }
        public GridSpinner(int min, int max) {
            this.setBorder(ViewConstants.DEFAULT_BORDER);
            this.setLayout(new GridLayout(0, 2));
            SpinnerModel model =
                    new SpinnerNumberModel(gridHeight, 
                                           min, max,
                                           step);
            SpinnerModel wmodel =
                    new SpinnerNumberModel(gridWidth,
                                           min, max,
                                           step);
            hspinner = new JSpinner(model);
            JLabel l = new JLabel("Height");
            wspinner= new JSpinner(wmodel);
            JLabel l2 = new JLabel("Width");
            this.add(l);
            l.setLabelFor(hspinner);
            this.add(hspinner);
            this.add(l2);
            l2.setLabelFor(wspinner);
            this.add(wspinner);
            hspinner.addChangeListener(this);
            wspinner.addChangeListener(this);
        }
        @Override
        public void stateChanged (ChangeEvent e) {
            gridHeight = (int) hspinner.getModel().getValue();
            gridWidth = (int) wspinner.getModel().getValue();
        }
        public int getGridWidth () {
            return gridWidth;
        }
        public int getGridHeight () {
            return gridHeight;
        }

    }