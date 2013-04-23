import arcade.controller.Controller;

/**
 * The one class that starts the entire project.
 * 
 * @author The Arcade Team
 */
public class Main {
    
    
    private static final String LANGUAGE = "English";
    
    
    private Main () {
        // does not make sense to construct this class
    }

    /**
     * main --- where the program starts
     * 
     * @param args anything passed in from the command-line
     */
    public static void main (String[] args) {
    	Controller controller = new Controller(LANGUAGE);
    	
    	/*
        ResourceBundle rb = ResourceBundle.getBundle(RESOURCE_LOCATION + LANGUAGE);
        Model model = new Model(rb, LANGUAGE);
        LoginView login = new LoginView(model, rb);
        model.setLoginView(login);
        */
        
    }
}
