package arcade.view;

import java.awt.Component;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import arcade.model.Model;
import arcade.util.BackgroundPanel;

@SuppressWarnings("serial")
public class RegisterView extends JFrame {
    private static final String IMAGES_LOCATION = "../resources/images/";
    private static final String BACKGROUND_FILENAME = "LoginBackGround.jpg";
    
    private Model myModel;
    private ResourceBundle myResources;

    public RegisterView (Model myModel, ResourceBundle myResources) {
        setTitle(myResources.getString(TextKeywords.TITLE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        JPanel background = new BackgroundPanel(IMAGES_LOCATION + BACKGROUND_FILENAME);
        getContentPane().add(background);
        background.add(createMainContents());

        setResizable(false);
        setVisible(true);
        pack();
    }

    private Component createMainContents () {
        JPanel panel = new JPanel();
        
        panel.setOpaque(false);
        return panel;
    }
    
    public static void main(String[] args) {
        new RegisterView(null, ResourceBundle.getBundle("arcade.resources.English"));
    }
    
    
}
