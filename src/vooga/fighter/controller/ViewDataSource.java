package vooga.fighter.controller;

import java.awt.Dimension;
import arcade.util.Location;
import vooga.fighter.util.Paintable;


public interface ViewDataSource {

    public int ObjectNumber ();

    public Paintable getPaintable (int index);

    public Location getLocation (int index);

    public Dimension getSize (int index);
}
