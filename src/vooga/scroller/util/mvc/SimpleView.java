package vooga.scroller.util.mvc;

import java.awt.Dimension;
import javax.swing.JFrame;
import vooga.scroller.util.Renderable;

public class SimpleView extends JFrame implements IView {

    public SimpleView (String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void process (Object command) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render (Renderable<?> r) {
        // TODO Auto-generated method stub

    }

    @Override
    public Dimension getSize () {
        // TODO Auto-generated method stub
        return null;
    }

}
