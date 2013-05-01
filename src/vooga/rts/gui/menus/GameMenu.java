package vooga.rts.gui.menus;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.annotation.Resource;
import javax.annotation.Resources;
import util.Location;
import vooga.rts.commands.ClickCommand;
import vooga.rts.commands.Command;
import vooga.rts.commands.InformationCommand;
import vooga.rts.commands.PositionCommand;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gui.Button;
import vooga.rts.gui.Menu;
import vooga.rts.gui.Window;
import vooga.rts.gui.buttons.ImageButton;
import vooga.rts.gui.menus.gamesubmenus.ActionsSubMenu;
import vooga.rts.gui.menus.gamesubmenus.InfoSubMenu;
import vooga.rts.gui.menus.gamesubmenus.MiniMapSubMenu;
import vooga.rts.gui.menus.gamesubmenus.ResourcesMenu;
import vooga.rts.gui.menus.gamesubmenus.SubMenu;
import vooga.rts.manager.IndividualResourceManager;
import vooga.rts.manager.Manager;
import vooga.rts.state.GameOver;


public class GameMenu extends Menu {

    // Image paths
    private static final String EXIT_IMAGE_URL = "images/gamemenu/menu_button.png";
    private static final String MINIMAP_IMAGE_URL = "images/gamemenu/menu_minimap.png";
    private static final String INFO_IMAGE_URL = "images/gamemenu/menu_info.png";
    private static final String ACTIONS_IMAGE_URL = "images/gamemenu/menu_actions.png";

    // Dimensions
    private static final Dimension EXIT_BUTTON_DIMENSION = new Dimension(200, 40);
    private static final Dimension MINIMAP_DIMENSION = new Dimension(206, 206);

    private static final Dimension INFO_DIMENSION = new Dimension(800, 135);
    private static final Dimension ACTIONS_DIMENSION = new Dimension(360, 175);

    private static final Location EXIT_BUTTON_LOCATION =
            new Location(Window.D_X - EXIT_BUTTON_DIMENSION.getWidth(), 0);
    private static final Location MINIMAP_LOCATION = new Location(0,
                                                                  Window.D_Y -
                                                                          MINIMAP_DIMENSION
                                                                                  .getHeight());
    private static final Location INFO_LOCATION = new Location(MINIMAP_LOCATION.getX() +
                                                               MINIMAP_DIMENSION.getWidth(),
                                                               Window.D_Y -
                                                                       INFO_DIMENSION
                                                                               .getHeight());
    private static final Location ACTIONS_LOCATION = new Location(INFO_LOCATION.getX() +
                                                                  INFO_DIMENSION.getWidth(),
                                                                  Window.D_Y -
                                                                          ACTIONS_DIMENSION
                                                                                  .getHeight());
    private static final Location RESOURCES_LOCATION = new Location(25, 25);

    private InteractiveEntity mySelectedEntity;

    private Button myExitButton;

    private List<SubMenu> mySubMenus;
    private SubMenu myMiniMapSubMenu;
    private SubMenu myInfoSubMenu;
    private SubMenu myActionsSubMenu;

    public GameMenu (IndividualResourceManager individualResourceManager) {

        myExitButton = new ImageButton(EXIT_IMAGE_URL, EXIT_BUTTON_DIMENSION, EXIT_BUTTON_LOCATION);
        addButton(myExitButton);

        mySubMenus = new ArrayList<SubMenu>();

        myMiniMapSubMenu =
                new MiniMapSubMenu(MINIMAP_IMAGE_URL, MINIMAP_DIMENSION, MINIMAP_LOCATION);
        addSubMenu(myMiniMapSubMenu);

        myInfoSubMenu = new InfoSubMenu(INFO_IMAGE_URL, INFO_DIMENSION, INFO_LOCATION);
        addSubMenu(myInfoSubMenu);

        myActionsSubMenu =
                new ActionsSubMenu(ACTIONS_IMAGE_URL, ACTIONS_DIMENSION, ACTIONS_LOCATION);
        addSubMenu(myActionsSubMenu);
        
        addSubMenu(new ResourcesMenu(individualResourceManager, EXIT_IMAGE_URL, new Dimension(), RESOURCES_LOCATION));

    }

    private void addSubMenu (SubMenu m) {
        mySubMenus.add(m);
        m.addObserver(this);
    }

    public boolean withinBoundary (Command command) {
        Location l = null;
        if (command instanceof ClickCommand) {
            ClickCommand c = (ClickCommand) command;
            l = c.getPosition();
        }
        else if (command instanceof PositionCommand) {
            PositionCommand c = (PositionCommand) command;
            l = c.getPosition();
        }
        if (l == null)
            return false;
        for (SubMenu s : mySubMenus) {
            if (s.checkWithinBounds(l)) { return true; }
        }
        for (Button b : myButtons) {
            if (b.checkWithinBounds(l)) { return true; }
        }

        return false;
    }

    @Override
    public void paint (Graphics2D pen) {
        super.paint(pen);
        for (SubMenu s : mySubMenus) {
            s.paint(pen);
        }

    }

    @Override
    public void update (Observable o, Object arg) {

        if (arg instanceof InformationCommand) {
            InformationCommand i = (InformationCommand) arg;
            setChanged();
            notifyObservers(i);

        }

        if (o instanceof Manager) {
            Boolean b = (Boolean) arg;
            Manager m = (Manager) o;
            if (b) {
                setSelected(m.getSelected());
            }
            else {
                setDeselected();
            }
            return;
        }

        if (o.equals(myExitButton)) {
            setChanged();
            notifyObservers(GameOver.QUIT);
        }
    }

    private void setDeselected () {
        mySelectedEntity = null;
        for (SubMenu b : mySubMenus) {
            b.setSelectedEntity(null);
        }
    }

    private void setSelected (List<InteractiveEntity> selected) {
        if (selected.size() == 0) {
            return;            
        }
        mySelectedEntity = selected.get(0); // The current select method if there is more than
                                            // one is just to choose the first one
        for (SubMenu b : mySubMenus) {
            b.setSelectedEntity(mySelectedEntity);
        }
    }

    public void handleMouseDown (int x, int y) {
        for (SubMenu b : mySubMenus) {
            if (b.checkWithinBounds(x, y)) {
                b.processClick(x, y);
            }
        }
        for (Button b : myButtons) {
            if (b.checkWithinBounds(x, y)) {
                b.processClick();
            }
        }
    }

    public void handleMouseMovement (int x, int y) {
        for (SubMenu b : mySubMenus) {
            if (b.checkWithinBounds(x, y)) {
                b.processHover(x, y);
                b.setFocused(true);
            }
            else {
                b.setFocused(false);
            }
        }
    }

}
