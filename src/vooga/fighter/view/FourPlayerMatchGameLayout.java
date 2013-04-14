package fighter.view;

import java.awt.Dimension;
import java.awt.Graphics;
import src.vooga.fighter.controller.ViewDataSource;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class FourPlayerMatchGameLayout extends CanvasLayout {
    private static final int MAX_TIMER = 1;
    private static final int MAX_PLAYER = 4;
    private static final int PLAYER_STATS_PADDING_BLOCKS = 2;
    private static final int SCREEN_ROWS = 7;
    private static final int VALUE_ROW = 6;
    
    public void paintComponents (Graphics pen, ViewDataSource data, Dimension screenSize) {
        int timerCount = 0;
        int playerCount = 0;
        
        for (int n = 0; n < data.ObjectNumber(); n++) {
            if (timerCount < 1 && data.getPaintable(n) instanceof HUDTimer) {
                Point2D.Double location = new Point2D.Double(screenSize.width / 2, 0);
                data.getPaintable(n).paint(pen, location, data.getSize(n));
                timerCount++;
            }
            else if (playerCount < MAX_PLAYER && data.getPaintable(n) instanceof HUDPlayerValue) {
                Point2D.Double location = 
                        new Point2D.Double(screenSize.width / (MAX_PLAYER + PLAYER_STATS_PADDING_BLOCKS) * playerCount + 1,
                                                             screenSize.height / SCREEN_ROWS * VALUE_ROW);
                data.getPaintable(n).paint(pen, location, data.getSize(n));
                playerCount++;
            }
            else {
                defaultPaint(pen, data, n);
            }
        }
    }
}
