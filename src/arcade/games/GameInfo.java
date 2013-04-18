package arcade.games;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import arcade.model.Model;
import arcade.util.Pixmap;


public class GameInfo {
    public static final String FILEPATH = "games.";
    public static final String RESOURCE_DIR_NAME = ".resources.";

    public static final String FILE_NAME = ".example";

    public static final String GAME_NAME = "name";
    public static final String THUMBNAIL_NAME = "thumbnail";
    public static final String AD_SCREEN = "adscreen";
    public static final String AGE_LIMIT_NAME = "agepermission";
    public static final String PRICE_KEYWORD = "price";
    public static final String GAME_MAIN_CLASS_KEYWORD = "extendsGame";
    public static final String MULTIPLAYER_GAME_MAIN_CLASS_KEYWORD = "extendsMultiplayergame";
    public static final String DESCRIPTION_KEYWORD = "description";

    private ResourceBundle myResourceBundle;
    private Model myModel;

    public GameInfo (String gamename, String genre, String language, Model model) {
        // String filepath = FILEPATH + gamename + "." + genre + RESOURCE_DIR_NAME + language;
        
        myModel = model;
        String filepath = FILEPATH + gamename + RESOURCE_DIR_NAME + language;
        myResourceBundle = ResourceBundle.getBundle(filepath);
    }

    public Pixmap getThumbnail () {
        return new Pixmap(myResourceBundle.getString(THUMBNAIL_NAME));
    }

    public String getName () {
        return myResourceBundle.getString(GAME_NAME);
    }

    public String getDescription () {
        return myResourceBundle.getString(DESCRIPTION_KEYWORD);
    }

    public Pixmap getAdScreen () {
        return new Pixmap(myResourceBundle.getString(AD_SCREEN));
    }

    private Class getGameClass () {
        try {
            return Class.forName(myResourceBundle.getString(GAME_MAIN_CLASS_KEYWORD));
        }
        catch (ClassNotFoundException e) {
            // add some additional tries for letter case, then throw an exception

            return null;
        }
    }

    public double getRating () {
        return myModel.getAverageRating(myResourceBundle.getString(GAME_NAME));
    }

    public List<String[]> getComments () {
        List<String[]> comments = new ArrayList<String[]>();
        String[] comment1 = { "subject", "theCoolestGuy", "5.0", "this game is awesome" };
        comments.add(comment1);
        return comments;
    }
    
    
    

    // Here, there be shiny reflective dragons . . .

    // untested . . . hope it works . . .
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public MultiplayerGame getMultiplayerGame (Model model) {
        Class gameClass = getMultiplayerGameClass();
        try {
            Constructor con = gameClass.getConstructor(MultiplayerArcadeInteraction.class);
            try {
                return (MultiplayerGame) con.newInstance(model);
            }
            catch (IllegalArgumentException e) {}
            catch (InstantiationException e) {}
            catch (IllegalAccessException e) {}
            catch (InvocationTargetException e) {}
        }
        catch (SecurityException e) {}
        catch (NoSuchMethodException e) {}
        return null;
    }

    private Class getMultiplayerGameClass () {
        try {
            return Class.forName(myResourceBundle.getString(MULTIPLAYER_GAME_MAIN_CLASS_KEYWORD));
        }
        catch (ClassNotFoundException e) {
            // add some additional tries for letter case, then throw an exception
        }
        return null;
    }

    // I SAY I will add better exception handling here but . . . .
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Game getGame (Model model) {
        Class gameClass = getGameClass();
        try {
            Constructor con = gameClass.getConstructor(ArcadeInteraction.class);
            try {
                return (Game) con.newInstance(model);
            }
            catch (IllegalArgumentException e) {}
            catch (InstantiationException e) {}
            catch (IllegalAccessException e) {}
            catch (InvocationTargetException e){}
        }
        catch (SecurityException e) {}
        catch (NoSuchMethodException e) {}
        return null;
    }

    public Method getRunMethod (Class gameClass) {
        try {
            return gameClass.getDeclaredMethod("run", new Class[] { ArcadeInteraction.class });
        }
        catch (SecurityException e) {}
        catch (NoSuchMethodException e) {}

        return null;

    }

}
